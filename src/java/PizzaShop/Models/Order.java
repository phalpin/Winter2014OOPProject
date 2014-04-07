/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import PizzaShop.Resources.GsonManager;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import com.google.gson.*;

/**
 *
 * @author phalpin
 */
public class Order extends DBEntity implements IPriceableEntity, ISerializable{

    private ArrayList<Pizza> _pizzas;
    private ArrayList<Side> _sides;
    
    public Order(){
        _pizzas = new ArrayList<Pizza>();
        _sides = new ArrayList<Side>();
    }
    
    public void addPizza(Pizza p){
        _pizzas.add(p);
    }
    
    public void removePizza(Pizza p){
        _pizzas.remove(p);
    }
    
    public boolean hasPizza(Pizza p){
        return _pizzas.contains(p);
    }
    
    public ArrayList<Pizza> getPizzas(){
        return _pizzas;
    }
    
    public void addSide(Side s){
        _sides.add(s);
    }
    
    public void removeSide(Side s){
        _sides.remove(s);
    }
    
    public boolean hasSide(Side s){
        return _sides.contains(s);
    }
    
    public ArrayList<Side> getSides(){
        return _sides;
    }
    
    @Override
    public double getCost() {
        double total = 0.0;
        
        for(Pizza p : _pizzas){
            total += p.getCost();
        }
        
        for(Side s : _sides){
            total += s.getCost();
        }
        
        return total;
    }

    @Override
    public String toJson() {
        return GsonManager.GO.toJson(this);
    }

    public static Order fromJson(String json){
        return GsonManager.GO.fromJson(json, Order.class);
    }
    
}
