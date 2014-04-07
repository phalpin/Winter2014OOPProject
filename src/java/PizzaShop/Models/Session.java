/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author phalpin
 */
public class Session extends DBEntity {
    private final String _token;
    private final Date _startedOn;
    private final int _userId;
    
    
    public Session(User u){
        _token = UUID.randomUUID().toString();
        _startedOn = new Date();
        _userId = u.getId();
    }
    
    public Session(int id, String token, Date startedOn, int userId){
        this.setId(id);
        _token = token;
        _startedOn = startedOn;
        _userId = userId;
    }
    
    public String getToken() {
        return _token;
    }

    public Date getStartedOn() {
        return _startedOn;
    }
    
    public int getUserId(){
        return _userId;
    }
    
}
