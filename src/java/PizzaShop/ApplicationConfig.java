package PizzaShop;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * Auto Generated Stuff for Jax-rs
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(PizzaShop.WebServices.OrdersResource.class);
        resources.add(PizzaShop.WebServices.PizzasResource.class);
        resources.add(PizzaShop.WebServices.UsersResource.class);
    }
    
}
