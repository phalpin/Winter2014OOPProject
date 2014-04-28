package PizzaShop.WebServices;

import PizzaShop.Models.Pizza;
import PizzaShop.Models.PizzaSize;
import PizzaShop.Models.PizzaType;
import PizzaShop.Services.IDataService;
import static PizzaShop.WebServices.BaseSvc.Success;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Pizza Endpoint.
 *
 */
@Path("Pizzas")
public class PizzasResource {

    @Context
    private UriInfo context;
    
    public IDataService<Pizza> _svc;

    /**
     * Creates a new instance of PizzasResource
     */
    public PizzasResource() {
    }
    
    /**
     * Returns sizes available for pizzas.
     * @return Sizes available.
     */
    @Path("Sizes")
    @GET
    @Produces("application/json")
    public Response sizes(){
        return Success(PizzaSize.getOptions());
    }
    
    /**
     * Returns Types available for pizzas.
     * @return Types available.
     */
    @Path("Types")
    @GET
    @Produces("application/json")
    public Response types(){
        return Success(PizzaType.getOptions());
    }
}
