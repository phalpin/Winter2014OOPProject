/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import PizzaShop.Models.*;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author phalpin
 */
@Path("/cs")
public class CustomersResource {

    @Context
    private UriInfo context;
    private static Person cust;

    /**
     * Creates a new instance of CustomersResource
     */
    public CustomersResource() {}
    
    
        /**
     * POST method for creating an instance of CustomerResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response Create(String content) {
        try{
            Person p = new Person();
            p.fromJson(content);
            CustomersResource.cust = p;
        }
        catch(Exception ex){
            
        }
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Retrieves representation of an instance of Resources.CustomersResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public String Read() {
        return CustomersResource.cust.toJson();
    }
    
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public String Update(String content){
        //Do stuff
        return "UPDATE";
    }
    
    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    public String Delete(String content){
        return "DELETE";
    }


    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public CustomerResource getCustomerResource(@PathParam("id") String id) {
        return CustomerResource.getInstance(id);
    }
}
