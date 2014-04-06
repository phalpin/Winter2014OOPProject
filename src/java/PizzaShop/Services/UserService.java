/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Services;

import PizzaShop.Data.DatabaseFactory;
import PizzaShop.Data.SqlConsts;
import PizzaShop.Models.User;
import PizzaShop.Models.UserType;
import PizzaShop.Resources.ActionResult;
import PizzaShop.Resources.ActionResultStatus;
import PizzaShop.Resources.IActionResult;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            u.EncryptPassword();
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
        return result;
    }

    @Override
    public IActionResult<User> Read(int id) {
        ActionResult<User> result = new ActionResult<User>();
        
        try {
            //TODO: Do some stuff in the database.
            CallableStatement cstmt = con.prepareCall("{call User_Read(?)}");
            cstmt.setInt("p_userId", id);
            
            ResultSet rs = cstmt.executeQuery();
            if(rs.next()){
                User u = new User();
                this.PopulateUser(rs, u);
                result.setResult(u);
                result.setStatus(ActionResultStatus.SUCCESS);
                result.setMessage("Successfully created the user in the database.");                
            }
            else{
               result.setStatus(ActionResultStatus.FAILURE);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            result.setStatus(ActionResultStatus.FAILURE);
            result.setMessage(ex.getMessage());
        }        
        
        return result;
    }

    @Override
    public IActionResult<User> Read(User u) {
        return Read(u.getId());
    }

    @Override
    public IActionResult<User> Update(User u) {
        ActionResult<User> result = new ActionResult<User>();
        
        try{
            CallableStatement cstmt = con.prepareCall("{call User_Update(?,?,?,?,?,?,?,?,?,?)}");
            cstmt.setInt("p_userId", u.getId());
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
            result.setResult(u);
        }
        catch(SQLException ex){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    @Override
    public IActionResult<Boolean> Delete(User u) {
        return Delete(u.getId());
    }

    @Override
    public IActionResult<Boolean> Delete(int id) {
        ActionResult<Boolean> result = new ActionResult<Boolean>();
        
        try{
            CallableStatement cstmt = con.prepareCall("{call User_Delete(?)}");
            cstmt.setInt("p_userId", id);
            ResultSet rs = cstmt.executeQuery();
            result.setResult(true);
            int deletedContactId = 0;
            if(rs.next()){
                deletedContactId = rs.getInt("Deleted");
            }
            
            Object r = new Object();
        }
        catch(SQLException ex){
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }
    
    public IActionResult<User> ReadByUserName(String username){
        ActionResult<User> result = new ActionResult<User>();
        
        try{
            CallableStatement cstmt = con.prepareCall("{call User_ReadByUserName(?)}");
            cstmt.setString("p_userName", username);
            ResultSet rs = cstmt.executeQuery();
            if(rs.next()){
                User u = new User();
                this.PopulateUser(rs, u);
                result.setStatus(ActionResultStatus.SUCCESS);
                result.setResult(u);
            }
            else{
                result.setStatus(ActionResultStatus.FAILURE);
                result.setMessage("Unable to find a user by username");
            }
            
        }
        catch(SQLException ex){
            result.setStatus(ActionResultStatus.FAILURE);
            result.setMessage("Failed to retrieve user" + ex.getMessage());
        }
        return result;
    }
    
    /**
     * Populates a user for the various methods to do something with.
     * @param rs Reader to populate from.
     * @param u User object to populate.
     * @return Populated user object.
     * @throws SQLException If the reader blows up.
     */
    private User PopulateUser(ResultSet rs, User u) throws SQLException{
        u.setId(rs.getInt(SqlConsts.userId));
        u.setContactId(rs.getInt(SqlConsts.contactId));
        u.setFirstName(rs.getString(SqlConsts.firstName));
        u.setMiddleName(rs.getString(SqlConsts.middleName));
        u.setLastName(rs.getString(SqlConsts.lastName));
        u.setHomeNumber(rs.getString(SqlConsts.homeNumber));
        u.setMobileNumber(rs.getString(SqlConsts.mobileNumber));
        u.setUsername(rs.getString(SqlConsts.userName));
        u.setPassword(rs.getString(SqlConsts.passWord));
        u.setType(UserType.values()[rs.getInt(SqlConsts.userType)-1]);
        u.setSalt(rs.getString(SqlConsts.salt));
        u.setSessionId(rs.getString(SqlConsts.sessionId));
        return u;
    }

    @Override
    public IActionResult<ArrayList<User>> ReadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
