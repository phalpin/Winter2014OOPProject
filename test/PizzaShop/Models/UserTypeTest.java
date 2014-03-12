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
public class UserTypeTest {
    
    public UserTypeTest() {
    }

    /**
     * Test of values method, of class UserType.
     */
    @Test
    public void testValues() {
        System.out.println("[UserTypeTest][testValues]");
        UserType[] expResult = {UserType.Customer, UserType.VIP, UserType.User, UserType.Administrator};
        UserType[] result = UserType.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class UserType.
     */
    @Test
    public void testValueOf() {
        System.out.println("[UserTypeTest][testValueOf]");
        String[] names = {"Customer", "VIP","User","Administrator"};
        UserType expResult = null;
        UserType result = null;
        
        for(int i=0;i<names.length;i++){
            expResult = UserType.values()[i];
            result = UserType.valueOf(names[i]);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of getValue method, of class UserType.
     */
    @Test
    public void testGetValue() {
        System.out.println("[UserTypeTest][testGetValue]");
        UserType instance = UserType.Customer;
        int expResult = 1;
        int result = instance.getName();
        assertEquals(expResult, result);
    }
    
}
