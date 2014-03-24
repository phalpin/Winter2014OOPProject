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
    private String _token;
    private Date _startedOn;
    
    
    public Session(){
        _token = UUID.randomUUID().toString();
        _startedOn = new Date();
    }
    
    public String getToken() {
        return _token;
    }

    public Date getStartedOn() {
        return _startedOn;
    }
    
}
