/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author phalpin
 */
public class UserTestHelper {
        
    /**
     * Generates a user to store to DB
     * @return A populated user.
     */
    public static User generateUser(){
        User u = new User();
        u.setFirstName("Test");
        u.setMiddleName("Ing");
        u.setLastName("Users");
        u.setMobileNumber("9545551234");
        u.setHomeNumber("9545554321");
        u.setPassword("ImaginaryPassword");
        u.setUsername("TestUser");
        u.setType(UserType.VIP);
        return u;
    }
    
    public static void assertUser(User expected, User actual){
        assertEquals(expected.getContactId(), actual.getContactId());
        assertEquals(expected.getType(), actual.getType());
        assertEquals(expected.getSessionId(), actual.getSessionId());
        assertEquals(expected.getUsername(), actual.getUsername());
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(expected.getSalt(), actual.getSalt());
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getMiddleName(), actual.getMiddleName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getHomeNumber(), actual.getHomeNumber());
        assertEquals(expected.getMobileNumber(), actual.getMobileNumber());
    }
}
