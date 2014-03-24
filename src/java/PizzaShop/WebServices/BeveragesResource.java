/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.WebServices;

import PizzaShop.Models.Beverage;
import PizzaShop.Services.BeverageService;
import PizzaShop.Services.IDataService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author phalpin
 */
@Path("Beverages")
public class BeveragesResource {

    @Context
    private UriInfo context;

    public IDataService<Beverage> _svc;
    
    /**
     * Creates a new instance of BeveragesResource
     */
    public BeveragesResource() {
    }

    /**
     * Retrieves representation of an instance of PizzaShop.WebServices.BeveragesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of BeveragesResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
