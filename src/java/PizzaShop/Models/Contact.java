/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import flexjson.JSONSerializer;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author phalpin
 */
public class Contact implements ISerializable {
    
    public Contact(int id){
        this.id = id;
    }

    //<editor-fold desc="Getters and Setters because lolJava.">
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    //</editor-fold>
    
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String homeNumber;
    private String mobileNumber;

    @Override
    public String toJson() {
        JSONSerializer r = new JSONSerializer();
        return r.serialize(this);
    }

    @Override
    public void fromJson(String json) throws JSONException {
        JSONObject j = new JSONObject(json);
        this.firstName = j.getString("FirstName");
        this.middleName = j.getString("MiddleName");
        this.lastName = j.getString("LastName");
        this.homeNumber = j.getString("HomeNumber");
        this.mobileNumber = j.getString("HomeNumber");
    }
    
    
}