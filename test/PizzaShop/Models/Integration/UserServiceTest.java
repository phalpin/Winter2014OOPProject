/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models.Integration;

import PizzaShop.Models.User;
import PizzaShop.Models.UserType;
import PizzaShop.Resources.ActionResult;
import PizzaShop.Resources.ActionResultStatus;
import PizzaShop.Resources.GsonManager;
import PizzaShop.Resources.IActionResult;
import PizzaShop.Services.UserService;
import TestHelpers.UserTestHelper;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author phalpin
 */
public class UserServiceTest {
    
    private final UserService _svc = new UserService();
    
    public UserServiceTest() {
    }

    /**
     * Test of Create method, of class UserService.
     */
    @Test
    public void testCreate() {
        System.out.println("[UserServiceTest][testCreate]");
        User u = UserTestHelper.generateUser();
        IActionResult<User> result = _svc.Create(u);
        assertEquals(ActionResultStatus.SUCCESS, result.getStatus());
        
        System.out.println(GsonManager.GO.toJson(u));
    }

    /**
     * Test of Read method, of class UserService.
     */
    @Test
    public void testRead_int() {
        System.out.println("[UserServiceTest][testRead_int]");
        User expected = _svc.Create(UserTestHelper.generateUser()).getResult();
        User result = _svc.Read(expected.getId()).getResult();
        UserTestHelper.assertUser(expected, result);
    }

    /**
     * Test of Read method, of class UserService.
     */
    @Test
    public void testRead_User() {
        System.out.println("[UserServiceTest][testRead_User]");
        User expected = _svc.Create(UserTestHelper.generateUser()).getResult();
        User result = _svc.Read(expected).getResult();
        UserTestHelper.assertUser(expected, result);
    }

    /**
     * Test of Update method, of class UserService.
     */
    @Test
    public void testUpdate() {
        System.out.println("[UserServiceTest][testUpdate]");
        User start = _svc.Create(UserTestHelper.generateUser()).getResult();
        start.setFirstName("Updated");
        User expected = _svc.Update(start).getResult();
        User result = _svc.Read(expected).getResult();
        UserTestHelper.assertUser(expected, result);
    }

    /**
     * Test of Delete method, of class UserService.
     */
    @Test
    public void testDelete_User() {
        System.out.println("[UserServiceTest][testDelete_User]");
        User start = _svc.Create(UserTestHelper.generateUser()).getResult();
        assertTrue(_svc.Delete(start).getResult());
        assertEquals(ActionResultStatus.FAILURE, _svc.Read(start).getStatus());
    }

    /**
     * Test of Delete method, of class UserService.
     */
    @Test
    public void testDelete_int() {
        System.out.println("[UserServiceTest][testDelete_int]");
        User start = _svc.Create(UserTestHelper.generateUser()).getResult();
        assertTrue(_svc.Delete(start.getId()).getResult());
        assertEquals(ActionResultStatus.FAILURE, _svc.Read(start).getStatus());
    }
    
    @Test
    public void testReadByUsername(){
        System.out.println("[UserServiceTest][testReadByUsername]");
        IActionResult<User> userResult = _svc.ReadByUserName("phalpin");
        assertEquals(ActionResultStatus.SUCCESS, userResult.getStatus());
        User phalpin = userResult.getResult();
        
        assertEquals("phalpin", phalpin.getUsername());
        assertEquals("Phillip", phalpin.getFirstName());
        assertEquals("Daniel", phalpin.getMiddleName());
        assertEquals("Halpin", phalpin.getLastName());
    }
    
    @Test
    public void testCreatePassword(){
        User u = new User();
        u.setFirstName("Phillip");
        u.setMiddleName("Daniel");
        u.setLastName("Halpin");
        u.setMobileNumber("9548957704");
        u.setHomeNumber("9547539744");
        u.setPassword("casnoekal1");
        u.setUsername("phalpin");
        u.setType(UserType.VIP);
        _svc.Create(u);
    }
}
