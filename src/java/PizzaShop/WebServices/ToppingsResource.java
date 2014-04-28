package PizzaShop.WebServices;

import PizzaShop.Models.PizzaTopping;
import PizzaShop.Services.PizzaService;
import static PizzaShop.WebServices.BaseSvc.Success;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Toppings Endpoint.
 */
@Path("Toppings")
public class ToppingsResource {

    @Context
    private UriInfo context;

    public PizzaService _svc;
    
    /**
     * Creates a new instance of ToppingsResource
     */
    public ToppingsResource() {
    }

    /**
     * Retrieves JSON representation of all available toppings.
     * @return JSON representation of all available toppings.
     */
    @GET
    @Produces("application/json")
    public Response getToppings() {
        return Success(PizzaTopping.getOptions());
    }
}