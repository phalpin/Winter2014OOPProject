/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import PizzaShop.Outbound.TypeJSON;
import java.util.ArrayList;

/**
 *
 * @author phalpin
 */
public enum PizzaType implements IDBEnum, IPriceableEntity {
    //Values
    NewYork(1, "New York",1.50),
    Chicago(2, "Chicago", 1.00),
    Italian(3, "Italian", 0.75);

    public static PizzaType fromId(int typeId) {
        return PizzaType.values()[typeId - 1];
    }
    
    //Enum Implementation
    PizzaType(int val, String name, double cost){
        _value = val;
        _name = name;
        _cost = cost;
    }
    private final int _value;
    private final String _name;
    private final double _cost;

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
    
    public static ArrayList<TypeJSON> getOptions(){
        ArrayList<TypeJSON> result = new ArrayList<TypeJSON>();
        result.add(new TypeJSON(NewYork));
        result.add(new TypeJSON(Chicago));
        result.add(new TypeJSON(Italian));
        return result;
    }
}
