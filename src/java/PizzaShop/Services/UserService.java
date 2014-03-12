/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Services;

import PizzaShop.Data.DatabaseFactory;
import PizzaShop.Models.User;
import PizzaShop.Resources.ActionResult;
import PizzaShop.Resources.IActionResult;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author phalpin
 * @param <User>
 */
public class UserService<User> implements IDataService<User> {
    
    private Connection con = null;
    
    public UserService(){
        try{
            con = DatabaseFactory.getInstance().getConnection();
        }
        catch(SQLException ex){
            //Do something.
        }
    }
    
    @Override
    public IActionResult<User> Create(Object obj) {
        ActionResult<User> result = new ActionResult<User>();

        //TODO: Do some stuff in the database.
        
        return result;
    }

    @Override
    public IActionResult<User> Read(int id) {
        ActionResult<User> result = new ActionResult<User>();
        
        //TODO: Do some stuff in the database.
        
        return result;
    }

    @Override
    public IActionResult<User> Read(Object obj) {
        ActionResult<User> result = new ActionResult<User>();
        
        //TODO: Do some stuff in the database.
        
        return result;
    }

    @Override
    public IActionResult<User> Update(Object obj) {
        ActionResult<User> result = new ActionResult<User>();
        
        //TODO: Do some stuff in the database.
        
        return result;
    }

    @Override
    public IActionResult<Boolean> Delete(Object obj) {
        ActionResult<Boolean> result = new ActionResult<Boolean>();
        
        //TODO: Do some stuff in the database.
        
        return result;
    }

    @Override
    public IActionResult<Boolean> Delete(int id) {
        ActionResult<Boolean> result = new ActionResult<Boolean>();
        
        //TODO: Do some stuff in the database.
        
        return result;
    }
    
}
