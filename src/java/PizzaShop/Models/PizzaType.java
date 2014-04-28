/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import PizzaShop.Outbound.TypeJSON;
import java.util.ArrayList;

/**
 * The Pizza Type enum. Contains all types (styles) of pizzas available from our app.
 */
public enum PizzaType implements IDBEnum, IPriceableEntity {
    NewYork(1, "New York",1.50),
    Chicago(2, "Chicago", 1.00),
    Italian(3, "Italian", 0.75);

    /**
     * Accessor to get the enum associated with a DB ID
     * @param typeId DB ID to retrieve an enum value for.
     * @return The PizzaType associated with the given DB ID.
     */
    public static PizzaType fromId(int typeId) {
        return PizzaType.values()[typeId - 1];
    }
    
    /**
     * Enum Implementation
     * @param val DB ID of this enum.
     * @param name String representation of this enum.
     * @param cost Cost associated with this enum.
     */
    PizzaType(int val, String name, double cost){
        _value = val;
        _name = name;
        _cost = cost;
    }
    
    /**
     * Accessor for getting a WebService friendly return value for sending via webservices.
     * @return ArrayList of TypeJSON.
     */
    public static ArrayList<TypeJSON> getOptions(){
        ArrayList<TypeJSON> result = new ArrayList<TypeJSON>();
        result.add(new TypeJSON(NewYork));
        result.add(new TypeJSON(Chicago));
        result.add(new TypeJSON(Italian));
        return result;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public int getValue() {
        return _value;
    }
    
    @Override
    public double getCost(){
        return _cost;
    }
    
    private final int _value;
    private final String _name;
    private final double _cost;
}
