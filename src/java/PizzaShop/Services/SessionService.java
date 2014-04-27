package PizzaShop.Services;

import PizzaShop.Data.DatabaseFactory;
import PizzaShop.Models.Session;
import PizzaShop.Models.User;
import PizzaShop.Resources.ActionResult;
import PizzaShop.Resources.ActionResultStatus;
import PizzaShop.Resources.IActionResult;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phalpin
 */
public class SessionService implements IDataService<Session> {

    private Connection con = null;
    
    private HashMap<String, User> _sessions = new HashMap<String, User>();
    private HashMap<User, Session> _usersSessions = new HashMap<User, Session>();
    
    public SessionService(){
        try{
            con = DatabaseFactory.getInstance().getConnection();
        }
        catch(SQLException ex){
            Logger.getLogger(SessionService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public IActionResult<Session> Create(Session obj) {
        ActionResult<Session> result = new ActionResult<Session>();
        try {
            java.sql.Date tempDate = new java.sql.Date(obj.getStartedOn().getTime());
            CallableStatement cstmt = con.prepareCall("{call Session_Create(?,?,?)}");
            cstmt.setString("p_token", obj.getToken());
            cstmt.setDate("p_startedOn", tempDate);
            cstmt.setInt("p_userId", obj.getUserId());
            
            ResultSet rs = cstmt.executeQuery();
            if(rs.next()){
                obj.setId(rs.getInt("sessionId"));
                result.setResult(obj);
                result.setStatus(ActionResultStatus.SUCCESS);
                result.setMessage("Successfully created the session in the database.");
                
            }
            else{
                result.setMessage("Failed to create the session - check your user id");
            }

        }
        catch (SQLException ex) {
            Logger.getLogger(SessionService.class.getName()).log(Level.SEVERE, null, ex);
            result.setMessage("Failed to create a session for the user");
        }
        return result;
    }

    @Override
    public IActionResult<Session> Read(int id) {
        ActionResult<Session> result = new ActionResult<Session>();
        
        try{
            CallableStatement cstmt = con.prepareCall("{call Session_Read(?)}");
            cstmt.setInt("p_id", id);
            ResultSet rs = cstmt.executeQuery();
            
            //The session object populated.
            Session s = new Session(
                    rs.getInt("id"),
                    rs.getString("token"),
                    new java.util.Date(rs.getDate("startedOn").getTime()),
                    rs.getInt("userId")
            );
            result.setStatus(ActionResultStatus.SUCCESS);
            result.setResult(s);
        }
        catch(Exception ex){
            result.setStatus(ActionResultStatus.FAILURE);
            result.setMessage("Failed to read the requested session", ex);
        }
        
        return result;
    }

    @Override
    public IActionResult<Session> Read(Session obj) {
        return Read(obj.getId());
    }

    @Override
    public IActionResult<Session> Update(Session obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<Boolean> Delete(Session obj) {
        ActionResult<Boolean> result = new ActionResult<Boolean>();
        
        if(SessionCached(obj.getToken())){
            RemoveSessionFromCache(obj);
        }
        
        try{
            CallableStatement cstmt = con.prepareCall("{call Session_Delete(?)}");
            cstmt.setInt("p_id", obj.getId());
            cstmt.executeQuery();
            result.setStatus(ActionResultStatus.SUCCESS);
            result.setResult(Boolean.TRUE);
            result.setMessage("Successfully removed the session from both the cache and the database.");
            con.close();
        }
        catch(Exception ex){
            result.setStatus(ActionResultStatus.FAILURE);
            result.setMessage("An error occurred removing the session from the database", ex);
        }
        
        return result;
    }

    @Override
    public IActionResult<Boolean> Delete(int id) {
        IActionResult<Boolean> result = new ActionResult<Boolean>();
        try{
            IActionResult<Session> readResult = Read(id);
            if(readResult.isSuccess()){
                result = Delete(readResult.getResult());
            }
            else{
                result.setStatus(readResult.getStatus());
                result.setMessage(readResult.getMessage());
            }
        }
        catch(Exception ex){
            result.setStatus(ActionResultStatus.FAILURE);
            result.setMessage("Failed to read/delete the item from the database.", ex);
        }
        return result;
    }
    
    public IActionResult<Session> ReadByToken(String token){
        ActionResult<Session> result = new ActionResult<Session>();
        if(SessionCached(token)){
            result.setStatus(ActionResultStatus.SUCCESS);
            result.setResult(GetSessionFromToken(token));
            return result;
        }
        else{
            try {
                CallableStatement cstmt = con.prepareCall("{call Session_ReadByToken(?)}");
                cstmt.setString("p_sessionToken", token);

                ResultSet rs = cstmt.executeQuery();
                if(rs.next()){
                    int id = rs.getInt("id");
                    Date startedOn = rs.getDate("startedOn");
                    int userId = rs.getInt("userId");
                    Session obj = new Session(id, token, startedOn, userId);
                    result.setResult(obj);
                    result.setStatus(ActionResultStatus.SUCCESS);
                }
                else{
                    result.setMessage("Failed to read the session - check your session id");
                }

            }
            catch (SQLException ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
                result.setMessage("Failed to create a session for the user");
            }
            return result;        
        }
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="Cache Management">
    public boolean SessionCached(Session sess){
        return _sessions.containsKey(sess.getToken());
    }
    
    public boolean SessionCached(String token){
        return _sessions.containsKey(token);
    }
    
    public boolean UserHasSession(User u){
        return _usersSessions.containsKey(u);
    }
    
    public User GetUserFromSession(Session sess){
        return GetUserFromSession(sess.getToken());
    }
    
    public User GetUserFromSession(String token){
        if(_sessions.containsKey(token)){
            return _sessions.get(token);
        }
        return null;        
    }
    
    private Session GetSessionFromUser(User u){
        if(_usersSessions.containsKey(u)){
            return _usersSessions.get(u);
        }
        return null;
    }
    
    private Session GetSessionFromToken(String token){
        if(_sessions.containsKey(token)){
            return GetSessionFromUser(_sessions.get(token));
        }
        else{
            return null;
        }
    }
    
    public void AddSessionToCache(Session sess, User u){
        _sessions.put(sess.getToken(), u);
        _usersSessions.put(u, sess);
    }
        
    public void RemoveSessionFromCache(Session sess){
        if(_sessions.containsKey(sess.getToken())){
            User removed = _sessions.remove(sess.getToken());
            _usersSessions.remove(removed);
        }
    }
    
    public void RemoveSessionFromCache(User u){
        if(_usersSessions.containsKey(u)){
            Session removed = _usersSessions.remove(u);
            _sessions.remove(removed.getToken());
        }
    }
    //</editor-fold>
    
}
