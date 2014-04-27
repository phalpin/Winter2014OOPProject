/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.WebServices;

import PizzaShop.Models.Pizza;
import PizzaShop.Models.PizzaSize;
import PizzaShop.Models.PizzaType;
import PizzaShop.Services.IDataService;
import PizzaShop.Services.PizzaService;
import static PizzaShop.WebServices.BaseSvc.Success;
import static PizzaShop.WebServices.BaseSvc.Success;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author phalpin
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
     * Retrieves representation of an instance of PizzaShop.WebServices.PizzasResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PizzasResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    
    @Path("Sizes")
    @GET
    @Produces("application/json")
    public Response sizes(){
        return Success(PizzaSize.getOptions());
    }
    
    @Path("Types")
    @GET
    @Produces("application/json")
    public Response types(){
        return Success(PizzaType.getOptions());
    }
}
