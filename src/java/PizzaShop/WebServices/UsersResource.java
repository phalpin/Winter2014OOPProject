/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.WebServices;

import PizzaShop.Data.ServiceFactory;
import PizzaShop.Models.Session;
import PizzaShop.Models.User;
import PizzaShop.Models.UserType;
import PizzaShop.Resources.ActionResultStatus;
import PizzaShop.Resources.GsonManager;
import PizzaShop.Resources.IActionResult;
import PizzaShop.Services.SessionService;
import PizzaShop.Services.UserService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Path("Users")
public class UsersResource extends BaseSvc {

    @Context
    private UriInfo context;
    
    public UserService _usrSvc = ServiceFactory.Instance().getUsrSvc();
    public SessionService _sessSvc = ServiceFactory.Instance().getSsnSvc();

    /**
     * Creates a new instance of UsersResource
     */
    public UsersResource() {
    }

    /**
     * Retrieves representation of an instance of PizzaShop.UsersResource
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getJson(@PathParam("id") String id, @Context HttpHeaders headers) {
        if(IsAuthorized(headers)){
            IActionResult<User> result = _usrSvc.Read(Integer.parseInt(id));
            return Result(result);            
        }
        else return Fail("Unauthorized");
    }

    /**
     * PUT method for updating or creating an instance of UsersResource
     * @param headers headers coming into this function
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response putJson(String content, @Context HttpHeaders headers) {
        IActionResult<User> result = null;
        try{            
            User incoming = GsonManager.GO.fromJson(content, User.class);
            //If they're PUTing an existing user.
            if(incoming.getId() != 0){
                result = _usrSvc.Update(incoming);
                return Result(result);
            }
            else{
                IActionResult<User> userExistsResult = _usrSvc.ReadByUserName(incoming.getUsername());

                //If user does not already exist.
                if(userExistsResult.getStatus() == ActionResultStatus.FAILURE){
                    result = _usrSvc.Create(incoming);
                    return Result(result);
                }
                else return Fail(userExistsResult);
            }            
        }
        catch(Exception ex){
            return Fail(ex);
        }

    }
    
    
    @POST
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response Login(String content){
        IActionResult<User> result = null;
        
        User incoming = GsonManager.GO.fromJson(content, User.class);
        
        result = _usrSvc.ReadByUserName(incoming.getUsername());
        if(result.getStatus() == ActionResultStatus.SUCCESS){
            String origPassword = incoming.getPassword();
            incoming = result.getResult();
            
            if(incoming.CheckPassword(origPassword)){
                
                //if there's an existing active session, maybe they've navigated away from the site or something.
                //Go ahead and remove it.
                if(incoming.getSessionId() != 0){
                    Session sess = incoming.getSession();
                    _sessSvc.Delete(incoming.getSessionId());
                }
                
                Session sess = new Session(incoming);
                IActionResult<Session> sessionCreation = _sessSvc.Create(sess);
                if(sessionCreation.getStatus() == ActionResultStatus.FAILURE){
                    return Fail(sessionCreation);
                }
                else{
                   incoming.setSession(sessionCreation.getResult());
                   _sessSvc.AddSessionToCache(sessionCreation.getResult(), incoming);
                   return Success(sess);
                }
            }
            else{
                return Success("Invalid Password");
            }
        }
        else{
            return Success("Invalid Username");
        }
    }
    
    @POST
    @Path("register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response Register(String content){
        try{
            User incoming = GsonManager.GO.fromJson(content, User.class);
            incoming.setType(UserType.Customer);
            IActionResult<User> userExistsResult = _usrSvc.ReadByUserName(incoming.getUsername());
            if(userExistsResult.isSuccess()){
                return Success("User Exists");
            }
            else{
                IActionResult<User> creationResult = _usrSvc.Create(incoming);
                if(creationResult.isSuccess()){
                    return Success("Successfully created the user");
                }
                else return Success("Failed to create the user: " + creationResult.getMessage());                
            }
        }
        catch(Exception ex){
            return Fail();
        }
    }
    
    @GET
    @Path("AccessLevel")
    @Consumes("application/json")
    @Produces("application/json")
    public Response GetAccessLevel(@Context HttpHeaders headers){
        User requestingUser = GetUser(headers);
        if(requestingUser != null){
            return Success(requestingUser.getType());
        }
        
        return Fail();
    }
}
