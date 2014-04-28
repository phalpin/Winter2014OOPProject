package PizzaShop.WebServices;

import PizzaShop.Data.ServiceFactory;
import PizzaShop.Models.Order;
import PizzaShop.Models.Pizza;
import PizzaShop.Models.User;
import PizzaShop.Models.UserType;
import PizzaShop.Resources.GsonManager;
import PizzaShop.Resources.IActionResult;
import PizzaShop.Services.OrderService;
import PizzaShop.Services.PizzaService;
import static PizzaShop.WebServices.BaseSvc.GetUser;
import static PizzaShop.WebServices.BaseSvc.Success;
import com.google.common.reflect.TypeToken;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Path("Orders")
public class OrdersResource {

    @Context
    private UriInfo context;
    
    public OrderService _svc = ServiceFactory.Instance().getOrdSvc();
    public PizzaService _pzaSvc = ServiceFactory.Instance().getPzaSvc();

    /**
     * Creates a new instance of OrdersResource
     */
    public OrdersResource() {
    }

    /**
     * Retrieves all orders for a given user.
     * @param headers Auto sent headers from application.
     * @return Response w/ data populated with orders if available.
     */
    @GET
    @Produces("application/json")
    public Response readAllForUser(@Context HttpHeaders headers) {
        User orderingUser = GetUser(headers);
        if(orderingUser != null){
            IActionResult<ArrayList<Order>> ordersResult = _svc.ReadAllForUser(orderingUser.getId());
            return Success(ordersResult);
        }
        else{
            return Success("Unauthorized.");
        }
    }
    
    /**
     * Submits an order 
     * @param content JSON representation of an order.
     * @param headers Headers auto sent from application.
     * @return Response w/ creation status.
     */
    @Path("Submit")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response submit(String content, @Context HttpHeaders headers){        
        User orderingUser = GetUser(headers);
        if(orderingUser != null){
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Pizza>>(){}.getType();
            ArrayList<Pizza> pizzas = GsonManager.GO.fromJson(content, listType);
            
            Order o = new Order();
            o.setUserId(orderingUser.getId());
            IActionResult<Order> orderCreation = _svc.Create(o);
            
            if(orderCreation.isSuccess()){
                for(Pizza p : pizzas){
                    p.setOrderId(o.getId());
                    _pzaSvc.Create(p);
                    o.addPizza(p);
                }
                return Success(orderCreation);
            }
        }
        
        return Success("Order not submitted.");
    }
    
    /**
     * Method for retrieving all orders for all users.
     * @param headers Headers to examine to make sure user is an administrator.
     * @return All orders / unauthorized.
     */
    @Path("All")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public Response getAllOrders(@Context HttpHeaders headers){
        User requestingUser = GetUser(headers);
        if(requestingUser.getType() == UserType.Administrator){
            IActionResult<ArrayList<User>> allOrders = _svc.ReadAll();
            return Success(allOrders);
        }
        return Success("Unauthorized");
    }
}
