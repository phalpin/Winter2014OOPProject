/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.WebServices;

import PizzaShop.Models.PizzaTopping;
import PizzaShop.Services.IDataService;
import PizzaShop.Services.PizzaService;
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
     * Retrieves representation of an instance of PizzaShop.WebServices.ToppingsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public Response getJson() {
        return Success(PizzaTopping.getOptions());
    }

    /**
     * PUT method for updating or creating an instance of ToppingsResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
