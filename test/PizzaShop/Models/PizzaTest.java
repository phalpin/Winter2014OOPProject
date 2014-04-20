/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author phalpin
 */
public class PizzaTest {
    public PizzaTest(){}
    
    @Test
    public void testCost(){
        System.out.println("[PizzaTest][testCost]");
        Pizza p = new Pizza(PizzaSize.Large, PizzaType.Chicago);
        double expected = p.getSize().getCost() + p.getType().getCost();
        assertEquals(expected, p.getCost(), 0.01);
        p.addTopping(PizzaTopping.Pepperoni);
        assertEquals(expected + 0.25, p.getCost(), 0.01);
    }
    
    @Test
    public void testAddTopping(){
        System.out.println("[PizzaTest][testAddTopping]");
        Pizza p = new Pizza(PizzaSize.Large, PizzaType.Chicago);
        PizzaTopping top1 = PizzaTopping.Pepperoni;
        PizzaTopping top2 = PizzaTopping.Sausage;
        PizzaTopping top3 = PizzaTopping.BlackOlives;
        p.addTopping(top1);
        p.addTopping(top2);
        p.addTopping(top3);
        assertEquals(3, p.getToppings().size());
    }
    
    @Test
    public void testRemoveTopping(){
        System.out.println("[PizzaTest][testRemoveTopping]");
        Pizza p = new Pizza(PizzaSize.Large, PizzaType.Chicago);
        PizzaTopping top1 = PizzaTopping.Pepperoni;
        PizzaTopping top2 = PizzaTopping.Sausage;
        p.addTopping(top1);
        p.addTopping(top2);
        assertEquals(2, p.getToppings().size());
        p.removeTopping(top1);
        assertEquals(1, p.getToppings().size());
        assertEquals(p.getToppings().get(0), top2);
    }
    
    @Test
    public void testHasTopping(){
        System.out.println("[PizzaTest][testHasTopping]");
        Pizza p = new Pizza(PizzaSize.Large, PizzaType.Chicago);
        PizzaTopping top1 = PizzaTopping.Pepperoni;
        PizzaTopping top2 = PizzaTopping.Sausage;
        p.addTopping(top1);
        p.addTopping(top2);
        assertTrue(p.hasTopping(top1));
        assertTrue(p.hasTopping(top2));
    }
}
