/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

/**
 *
 * @author phalpin
 */
public enum PizzaType implements IDBEnum, IPriceableEntity {
    //Values
    NewYork(1, "New York", 0.00),
    Chicago(2, "Chicago", 0.50),
    Italian(3, "Italian", 1.00);
    
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
    
}
