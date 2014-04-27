/*
 * To change this license header, choose License Headers in Project Properties.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import PizzaShop.Outbound.ToppingJSON;
import java.util.ArrayList;


public enum PizzaTopping implements IDBEnum, IPriceableEntity {
    //Values
    Pepperoni(1, "Pepperoni", 0.25),
    Sausage(2, "Sausage", 0.50),
    Jalapenos(3, "Jalapenos", 0.75),
    BlackOlives(4, "Black Olives", 0.50);
    
    
    PizzaTopping(int id, String name, double cost){
        _value = id;
        _cost = cost;
        _name = name;
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
    public double getCost() {
        return _cost;
    }
    
    public static ArrayList<ToppingJSON> getOptions(){
        ArrayList<ToppingJSON> result = new ArrayList<ToppingJSON>();
        result.add(new ToppingJSON(Pepperoni));
        result.add(new ToppingJSON(Sausage));
        result.add(new ToppingJSON(Jalapenos));
        result.add(new ToppingJSON(BlackOlives));
        return result;
    }
    
    public static PizzaTopping fromId(int id){
        return PizzaTopping.values()[id-1];
    }

    private final int _value;
    private final double _cost;
    private final String _name;


}

