/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author phalpin
 */
public class CustomerResource {

    private String id;

    /**
     * Creates a new instance of CustomerResource
     */
    private CustomerResource(String id) {
        this.id = id;
    }

    /**
     * Get instance of the CustomerResource
     */
    public static CustomerResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of CustomerResource class.
        return new CustomerResource(id);
    }

    /**
     * Retrieves representation of an instance of Resources.CustomerResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of CustomerResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    /**
     * DELETE method for resource CustomerResource
     */
    @DELETE
    public void delete() {
    }
}
