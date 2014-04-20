/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;


import TestHelpers.PizzaTestHelper;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author phalpin
 */
public class OrderTest {
    
    @Test
    public void testAddPizza(){
        System.out.println("[OrderTest][testAddPizza]");
        Order o = new Order();
        o.addPizza(new Pizza(PizzaSize.Large, PizzaType.Italian));
        assertEquals(1, o.getPizzas().size());
        assertEquals(PizzaSize.Large, o.getPizzas().get(0).getSize());
        assertEquals(PizzaType.Italian, o.getPizzas().get(0).getType());
    }
    
    @Test
    public void testRemovePizza(){
        System.out.println("[OrderTest][testRemovePizza]");
        Order o = new Order();
        Pizza p = new Pizza(PizzaSize.Large, PizzaType.Italian);
        o.addPizza(p);
        assertEquals(1, o.getPizzas().size());
        o.removePizza(p);
        assertEquals(0, o.getPizzas().size());
    }
    
    @Test
    public void testHasPizza(){
        System.out.println("[OrderTest][testHasPizza]");
        Order o = new Order();
        Pizza p1 = new Pizza(PizzaSize.Large, PizzaType.Italian);
        Pizza p2 = new Pizza(PizzaSize.Large, PizzaType.Chicago);
        o.addPizza(p1);
        o.addPizza(p2);
        assertTrue(o.hasPizza(p1));
        assertTrue(o.hasPizza(p2));
    }
    
    @Test
    public void testAddSide(){
        System.out.println("[OrderTest][testAddSide]");
        Order o = new Order();
        Beverage b1 = new Beverage("Pepsi", 2.0, 2.00);
        Beverage b2 = new Beverage("Coke", 2.0, 2.00);
        AssortedSide s1 = new AssortedSide("Breadsticks", 6, 2.50);
        AssortedSide s2 = new AssortedSide("Buffalo Wings", 6, 3.00);
        o.addSide(b1);
        assertEquals(1, o.getSides().size());
        o.addSide(b2);
        assertEquals(2, o.getSides().size());
        o.addSide(s1);
        assertEquals(3, o.getSides().size());
        o.addSide(s2);
        assertEquals(4, o.getSides().size());
        
        ArrayList<Side> sidesPresent = o.getSides();
        
        assertEquals(4, sidesPresent.size());
        assertEquals(b1, sidesPresent.get(0));
        assertEquals(b2, sidesPresent.get(1));
        assertEquals(s1, sidesPresent.get(2));
        assertEquals(s2, sidesPresent.get(3));
    }
    
    @Test
    public void testRemoveSide(){
        System.out.println("[OrderTest][testRemoveSide]");
        Order o = new Order();
        Beverage b1 = new Beverage("Pepsi", 2.0, 2.00);
        Beverage b2 = new Beverage("Coke", 2.0, 2.00);
        AssortedSide s1 = new AssortedSide("Breadsticks", 6, 2.50);
        AssortedSide s2 = new AssortedSide("Buffalo Wings", 6, 3.00);
        o.addSide(b1);
        o.addSide(b2);
        o.addSide(s1);
        o.addSide(s2);
        
        assertEquals(4, o.getSides().size());
        
        o.removeSide(s2);
        assertEquals(3, o.getSides().size());
        o.removeSide(s1);
        assertEquals(2, o.getSides().size());
        o.removeSide(b2);
        assertEquals(1, o.getSides().size());
        o.removeSide(b1);
        assertEquals(0, o.getSides().size());
    }
    
    @Test
    public void testHasSide(){
        System.out.println("[OrderTest][testHasSide]");
        Order o = new Order();
        Beverage b1 = new Beverage("Pepsi", 2.0, 2.00);
        Beverage b2 = new Beverage("Coke", 2.0, 2.00);
        AssortedSide s1 = new AssortedSide("Breadsticks", 6, 2.50);
        AssortedSide s2 = new AssortedSide("Buffalo Wings", 6, 3.00);
        o.addSide(b1);
        o.addSide(b2);
        o.addSide(s1);
        o.addSide(s2);
        
        assertTrue(o.hasSide(b1));
        assertTrue(o.hasSide(b2));
        assertTrue(o.hasSide(s1));
        assertTrue(o.hasSide(s2));
    }
    
    @Test
    public void testCost(){
        System.out.println("[OrderTest][testCost]");
        double expectedCost = 0.0;
        Order o = new Order();
        
        o.addPizza(new Pizza(PizzaSize.Large, PizzaType.Italian));
        expectedCost += PizzaSize.Large.getCost() + PizzaType.Italian.getCost();
        assertEquals(expectedCost, o.getCost(), 0.01);
        
        
        Beverage b1 = new Beverage("Pepsi", 2.0, 2.00);
        Beverage b2 = new Beverage("Coke", 2.0, 2.00);
        o.addSide(b1);
        o.addSide(b2);
        expectedCost += b1.getCost() + b2.getCost();
        assertEquals(expectedCost, o.getCost(), 0.01);
        
        AssortedSide s1 = new AssortedSide("Breadsticks", 6, 2.50);
        AssortedSide s2 = new AssortedSide("Buffalo Wings", 6, 3.00);
        o.addSide(s1);
        o.addSide(s2);
        expectedCost += s1.getCost() + s2.getCost();
        assertEquals(expectedCost, o.getCost(), 0.01);
        
        o.removeSide(s2);
        o.removeSide(s1);
        expectedCost -= s1.getCost() + s2.getCost();
        assertEquals(expectedCost, o.getCost(), 0.01);
    }
    
}
