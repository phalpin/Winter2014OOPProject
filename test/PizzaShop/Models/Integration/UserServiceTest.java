/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models.Integration;

import PizzaShop.Models.User;
import PizzaShop.Models.UserTestHelper;
import PizzaShop.Resources.ActionResultStatus;
import PizzaShop.Resources.IActionResult;
import PizzaShop.Services.UserService;
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

    /**
     * Test of Create method, of class UserService.
     */
    @Test
    public void testCreate() {
        System.out.println("Create");
        User u = UserTestHelper.generateUser();
        IActionResult<User> result = _svc.Create(u);
        assertEquals(ActionResultStatus.SUCCESS, result.getStatus());
    }

    /**
     * Test of Read method, of class UserService.
     */
    @Test
    public void testRead_int() {
        System.out.println("Read");
        User expected = _svc.Create(UserTestHelper.generateUser()).getResult();
        User result = _svc.Read(expected.getId()).getResult();
        UserTestHelper.assertUser(expected, result);
    }

    /**
     * Test of Read method, of class UserService.
     */
    @Test
    public void testRead_User() {
        System.out.println("Read");
        User expected = _svc.Create(UserTestHelper.generateUser()).getResult();
        User result = _svc.Read(expected).getResult();
        UserTestHelper.assertUser(expected, result);
    }

    /**
     * Test of Update method, of class UserService.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
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
        System.out.println("Delete");
        User start = _svc.Create(UserTestHelper.generateUser()).getResult();
        assertTrue(_svc.Delete(start).getResult());
        assertEquals(ActionResultStatus.FAILURE, _svc.Read(start).getStatus());
    }

    /**
     * Test of Delete method, of class UserService.
     */
    /*
    @Test
    public void testDelete_int() {
        System.out.println("Delete");
        User start = _svc.Create(UserTestHelper.generateUser()).getResult();
        assertTrue(_svc.Delete(start.getId()).getResult());
        assertEquals(ActionResultStatus.FAILURE, _svc.Read(start).getStatus());
    }
    */
    
}
