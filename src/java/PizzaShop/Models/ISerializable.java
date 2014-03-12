/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import org.codehaus.jettison.json.JSONException;

/**
 * Interface - announces to the world that that individual class is serializable!
 * @author phalpin
 * @param <T> Type to make serializable.
 */
public interface ISerializable<T> {
    public String toJson();
    public void fromJson(String json) throws JSONException;
    
}
