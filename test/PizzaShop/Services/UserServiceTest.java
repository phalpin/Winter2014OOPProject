/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Services;

import PizzaShop.Models.User;
import PizzaShop.Models.UserType;
import PizzaShop.Resources.ActionResultStatus;
import PizzaShop.Resources.IActionResult;
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
public class UserServiceTest {
    
    private final UserService _svc;
    
    public UserServiceTest() {
        _svc = new UserService();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Create method, of class UserService.
     */
    @Test
    public void testCreate() {
        System.out.println("Create");
        User u = generateUser();
        IActionResult<User> result = _svc.Create(u);
        assertEquals(ActionResultStatus.SUCCESS, result.getStatus());
    }

    /**
     * Test of Read method, of class UserService.
     */
    @Test
    public void testRead_int() {
        System.out.println("Read");
        User expected = _svc.Create(generateUser()).getResult();
        User result = _svc.Read(expected.getId()).getResult();
        assertUser(expected, result);
    }

    /**
     * Test of Read method, of class UserService.
     */
    @Test
    public void testRead_User() {
        System.out.println("Read");
        User expected = _svc.Create(generateUser()).getResult();
        User result = _svc.Read(expected).getResult();
        assertUser(expected, result);
    }

    /**
     * Test of Update method, of class UserService.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
        //TODO: Implement
    }

    /**
     * Test of Delete method, of class UserService.
     */
    @Test
    public void testDelete_User() {
        System.out.println("Delete");
        //TODO: Implement.
    }

    /**
     * Test of Delete method, of class UserService.
     */
    @Test
    public void testDelete_int() {
        System.out.println("Delete");
        //TODO: Implement.
    }
    
    /**
     * Generates a user to store to DB
     * @return A populated user.
     */
    private User generateUser(){
        User u = new User();
        u.setFirstName("Test");
        u.setMiddleName("Ing");
        u.setLastName("Users");
        u.setMobileNumber("9545551234");
        u.setHomeNumber("9545554321");
        u.setPassword("ImaginaryPassword");
        u.setSalt("ImaginarySalt");
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
