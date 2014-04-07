/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import PizzaShop.Resources.GsonManager;
import java.util.ArrayList;

/**
 *
 * @author phalpin
 */
public class Pizza extends DBEntity implements IPriceableEntity, ISerializable<Pizza> {
    private String _name;
    private PizzaSize _size;
    private PizzaType _type;
    private ArrayList<PizzaTopping> _toppings;

    public Pizza(PizzaSize size, PizzaType type){
        _size = size;
        _type = type;
        _toppings = new ArrayList<PizzaTopping>();
    }
    
    public PizzaSize getSize(){
        return _size;
    }
    
    public void setSize(PizzaSize size){
        _size = size;
    }
    
    public PizzaType getType(){
        return _type;
    }
    
    public void setType(PizzaType type){
        _type = type;
    }
    
    public void addTopping(PizzaTopping topping){
        _toppings.add(topping);
    }
    
    /**
     * Method for removing a particular topping from this particular pizza.
     * @param topping Removes a given topping from this particular pizza.
     */
    public void removeTopping(PizzaTopping topping){
        _toppings.remove(topping);
    }
    
    /**
     * Method for retrieving the list of toppings within this particular pizza.
     * @return A list of toppings for this particular pizza.
     */
    public ArrayList<PizzaTopping> getToppings(){
        return _toppings;
    }
    
    /**
     * Method for determining whether this particular pizza has a topping.
     * @param t Topping to check for on this particular pizza.
     * @return true or false, based on 
     */
    public boolean hasTopping(PizzaTopping t){
        return _toppings.contains(t);
    }
    
    @Override
    public double getCost() {
        double amount = 0.0;
        amount += _size.getCost();
        amount += _type.getCost();
        for(PizzaTopping pt : _toppings){
            amount += pt.getCost();
        }
        return amount;
    }

    /**
     * Method to serialize this object out to a Json string.
     * @return Json string representation of this particular Pizza object.
     */
    @Override
    public String toJson() {
        return GsonManager.GO.toJson(this);
    }
    
    /**
     * Method to deserialize a new Pizza object from a given Json string.
     * @param json the json string to deserialize an object from.
     * @return a new Pizza object, deserialized from the parameterized json.
     */
    public static Pizza fromJson(String json){
        return GsonManager.GO.fromJson(json, Pizza.class);
    }
    
    
}
