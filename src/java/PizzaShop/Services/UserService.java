/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Services;

import PizzaShop.Data.DatabaseFactory;
import PizzaShop.Models.User;
import PizzaShop.Resources.ActionResult;
import PizzaShop.Resources.ActionResultStatus;
import PizzaShop.Resources.IActionResult;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phalpin
 * @param <User>
 */
public class UserService implements IDataService<User> {
    
    private Connection con = null;
    
    public UserService(){
        try{
            con = DatabaseFactory.getInstance().getConnection();
        }
        catch(SQLException ex){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public IActionResult<User> Create(User u) {
        ActionResult<User> result = new ActionResult<User>();
        try {
            //TODO: Do some stuff in the database.
            CallableStatement cstmt = con.prepareCall("{call User_Create(?,?,?,?,?,?,?,?,?)}");
            cstmt.setString("p_firstName", u.getFirstName());
            cstmt.setString("p_middleName", u.getMiddleName());
            cstmt.setString("p_lastName", u.getLastName());
            cstmt.setString("p_homeNumber", u.getHomeNumber());
            cstmt.setString("p_mobileNumber", u.getMobileNumber());
            cstmt.setString("p_userName", u.getUsername());
            cstmt.setString("p_passWord", u.getPassword());
            cstmt.setString("p_salt", u.getSalt());
            cstmt.setInt("p_userType", u.getType().getValue());
            
            ResultSet rs = cstmt.executeQuery();
            if(rs.next()){
                u.setId(rs.getInt("UserId"));
                u.setContactId(rs.getInt("ContactId"));
                result.setResult(u);
                result.setStatus(ActionResultStatus.SUCCESS);
                result.setMessage("Successfully created the user in the database.");                
            }

        }
        catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* //For Reference.
        IN p_firstName VARCHAR(50),
        IN p_middleName VARCHAR(50),
        IN p_lastName VARCHAR(50),
        IN p_homeNumber VARCHAR(50),
        IN p_mobileNumber VARCHAR(50),
        IN p_userName VARCHAR(25),
        IN p_passWord VARCHAR(100),
        IN p_salt VARCHAR(45),
        IN p_userType INT
        */
        return result;
    }

    @Override
    public IActionResult<User> Read(int id) {
        ActionResult<User> result = new ActionResult<User>();
        
        //TODO: Do some stuff in the database.
        
        return result;
    }

    @Override
    public IActionResult<User> Read(User u) {
        ActionResult<User> result = new ActionResult<User>();
        
        //TODO: Do some stuff in the database.
        
        return result;
    }

    @Override
    public IActionResult<User> Update(User u) {
        ActionResult<User> result = new ActionResult<User>();
        
        //TODO: Do some stuff in the database.
        
        return result;
    }

    @Override
    public IActionResult<Boolean> Delete(User u) {
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
