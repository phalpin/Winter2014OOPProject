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
        p.addTopping(new PizzaTopping("Pepperoni", 0.25));
        assertEquals(expected + 0.25, p.getCost(), 0.01);
    }
    
    @Test
    public void testAddTopping(){
        System.out.println("[PizzaTest][testAddTopping]");
        Pizza p = new Pizza(PizzaSize.Large, PizzaType.Chicago);
        PizzaTopping top1 = new PizzaTopping("Pepperoni", 0.50);
        PizzaTopping top2 = new PizzaTopping("Sausage", 0.75);
        PizzaTopping top3 = new PizzaTopping("Black Olives", 0.90);
        p.addTopping(top1);
        p.addTopping(top2);
        p.addTopping(top3);
        assertEquals(3, p.getToppings().size());
    }
    
    @Test
    public void testRemoveTopping(){
        System.out.println("[PizzaTest][testRemoveTopping]");
        Pizza p = new Pizza(PizzaSize.Large, PizzaType.Chicago);
        PizzaTopping top1 = new PizzaTopping("Pepperoni", 0.50);
        PizzaTopping top2 = new PizzaTopping("Sausage", 0.75);
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
        PizzaTopping top1 = new PizzaTopping("Pepperoni", 0.50);
        PizzaTopping top2 = new PizzaTopping("Sausage", 0.50);
        p.addTopping(top1);
        p.addTopping(top2);
        assertTrue(p.hasTopping(top1));
        assertTrue(p.hasTopping(top2));
    }
}
