/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.WebServices;

import PizzaShop.Data.ServiceFactory;
import PizzaShop.Models.Session;
import PizzaShop.Models.User;
import PizzaShop.Resources.IActionResult;
import PizzaShop.Services.SessionService;
import PizzaShop.Services.UserService;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

public class BaseSvc {
    
    private static UserService _usrSvc = ServiceFactory.Instance().getUsrSvc();
    private static SessionService _ssnSvc = ServiceFactory.Instance().getSsnSvc();
    
    public static Response Success(){
        return Response.status(200).build();
    }
    
    public static Response Success(int result){
        return Response.status(200).entity(result).build();
    }
    
    public static Response Success(Object result){
        return Response.status(200).entity(result).build();
    }
    
    public static Response Success(IActionResult result){
        if(result.isSuccess()){
            return Response.status(200).entity(result.getResult()).build();    
        }
        else{
            return Response.status(200).entity(result.getMessage()).build();
        }
    }
    
    public static Response Fail(){
        return Response.status(500).build();
    }
    
    public static Response Fail(String message){
        return Response.status(500).entity(message).build();
    }
    
    public static Response Fail(IActionResult result){
        return Response.status(500).entity(result.getMessage()).build();
    }
    
    public static Response Fail(Exception ex){
        return Response.status(500).entity(ex.getMessage()).build();
    }
    
    public static boolean IsAuthorized(String token){
        IActionResult<Session> sess = _ssnSvc.ReadByToken(token);
        
        return sess.isSuccess();

        //TODO: Implement Time checking for session to make sure everything is kosher in terms of startDate vs now..
        /*
        if(sess.isSuccess()){
            
        }
        else{
            return false;
        }
        */
    }
    
    public static boolean IsAuthorized(HttpHeaders headers){
        return IsAuthorized(headers.getHeaderString("Authorization"));
    }
    
    public static User GetUser(HttpHeaders headers){
        String token = headers.getHeaderString("Authorization");
        
        if(_ssnSvc.SessionCached(token)){
            return _ssnSvc.GetUserFromSession(headers.getHeaderString("Authorization"));
        }
        else{
            IActionResult<Session> sess = _ssnSvc.ReadByToken(token);
            if(sess.isSuccess()){
                IActionResult<User> usr = _usrSvc.Read(sess.getResult().getUserId());
                if(usr.isSuccess()){
                    return usr.getResult();
                }
                else{
                    return null;
                }
            }
            else{
                return null;
            }
        }
    }
    
    /**
     * Generic Result Return - In the event there's no need to descend any more business logic.
     * @param result Result to parse to determine whether to send back success or fail.
     * @return a response.
     */
    public static Response Result(IActionResult result){
        switch(result.getStatus()){
            case SUCCESS:
                return Response.status(200).entity(result.getResult()).build();
            case FAILURE:
                return Response.status(500).entity(result.getMessage()).build();
        }
        
        return Response.status(500).build();
    }
}
