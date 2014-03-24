/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import TestHelpers.UserTestHelper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author phalpin
 */
public class UserTest {
    
    public UserTest() {
    }
    
    /**
     * Tests password encryption feature of the user object.
     */
    @Test
    public void testPasswordEncryption(){
        User u = UserTestHelper.generateUser();
        String prePassword = u.getPassword();
        u.EncryptPassword();
        assertNotSame(prePassword, u.getPassword());
        assertTrue(u.CheckPassword(prePassword));
    }
}
