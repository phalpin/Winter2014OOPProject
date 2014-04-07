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
public enum PizzaSize implements IDBEnum, IPriceableEntity {
    //Values
    Small (1, "Small", 5.00),
    Medium (2, "Medium", 7.50),
    Large (3, "Large", 10.00);
    
    //Enum Implementation
    PizzaSize(int val, String name, double cost){
        _value = val;
        _name = name;
        _cost = cost;
    }
    private final int _value;
    private final String _name;
    private final double _cost;

    /**
     * Method for retrieving the name (string representation) of this particular Pizza Size.
     * @return The string representation of the name of this particular pizza size.
     */
    @Override
    public String getName() {
        return _name;
    }

    /**
     * Method for retrieving the value (AKA, DB ID) for this particular Pizza Size.
     * @return the integer database ID for this particular Pizza Size.
     */
    @Override
    public int getValue() {
        return _value;
    }
    
    /**
     * Method for retrieving the cost for this particular Pizza Size.
     * @return double Cost.
     */
    @Override
    public double getCost(){
        return _cost;
    }
    
}
