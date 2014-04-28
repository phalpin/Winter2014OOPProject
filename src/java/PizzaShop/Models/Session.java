package PizzaShop.Models;

import java.util.Date;
import java.util.UUID;

/**
 * The Session Object - used to determine who's contacting us from the outside world.
 */
public class Session extends DBEntity {

    
    /**
     * Constructor
     * @param u User to create a session for.
     */
    public Session(User u){
        _token = UUID.randomUUID().toString();
        _startedOn = new Date();
        _userId = u.getId();
    }
    
    /**
     * Full Constructor
     * @param id DB ID of the session.
     * @param token token to assign for this session.
     * @param startedOn date the session started.
     * @param userId User this session is associated with.
     */
    public Session(int id, String token, Date startedOn, int userId){
        this.setId(id);
        _token = token;
        _startedOn = startedOn;
        _userId = userId;
    }
    
    /**
     * Accessor for the token associated with this session.
     * @return Session Token.
     */
    public String getToken() {
        return _token;
    }

    /**
     * Accessor for when this session started.
     * @return the date the session started.
     */
    public Date getStartedOn() {
        return _startedOn;
    }
    
    /**
     * Accessor for retrieving the user id this session is associated with.
     * @return The user id this session is associated with.
     */
    public int getUserId(){
        return _userId;
    }
    
    
    private final String _token;
    private final Date _startedOn;
    private final int _userId;    
}
