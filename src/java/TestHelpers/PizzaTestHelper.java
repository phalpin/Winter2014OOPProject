/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestHelpers;

import PizzaShop.Models.Pizza;
import PizzaShop.Models.PizzaSize;
import PizzaShop.Models.PizzaTopping;
import PizzaShop.Models.PizzaType;
import org.junit.Ignore;
import static org.junit.Assert.*;

/**
 *
 * @author phalpin
 */
@Ignore
public class PizzaTestHelper {
    
    @Ignore
    public static Pizza getPizza(){
        Pizza result = new Pizza(PizzaSize.Large, PizzaType.Italian);
        result.addTopping(PizzaTopping.Pepperoni);
        result.addTopping(PizzaTopping.Jalapenos);
        result.addTopping(PizzaTopping.Sausage);
        return result;
    }
    
    @Ignore
    public static void assertPizza(Pizza expected, Pizza actual){
        assertEquals(expected.getCost(), actual.getCost());
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getSize(), actual.getSize());
        assertEquals(expected.getToppings().size(), actual.getToppings().size());
        assertEquals(expected.getType(), actual.getType());
        for(PizzaTopping p : expected.getToppings()){
            assertTrue(actual.hasTopping(p));
        }
    }
}
