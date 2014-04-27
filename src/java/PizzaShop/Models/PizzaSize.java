/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import static PizzaShop.Models.PizzaTopping.BlackOlives;
import static PizzaShop.Models.PizzaTopping.Jalapenos;
import static PizzaShop.Models.PizzaTopping.Pepperoni;
import static PizzaShop.Models.PizzaTopping.Sausage;
import PizzaShop.Outbound.SizeJSON;
import PizzaShop.Outbound.ToppingJSON;
import java.util.ArrayList;

/**
 *
 * @author phalpin
 */
public enum PizzaSize implements IDBEnum, IPriceableEntity {
    //Values
    Small (1, "Small", 5.00),
    Medium (2, "Medium", 7.50),
    Large (3, "Large", 10.00);

    public static PizzaSize fromId(int sizeId) {
        return PizzaSize.values()[sizeId - 1];
    }
    
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
    
    
    public static ArrayList<SizeJSON> getOptions(){
        ArrayList<SizeJSON> result = new ArrayList<SizeJSON>();
        result.add(new SizeJSON(Small));
        result.add(new SizeJSON(Medium));
        result.add(new SizeJSON(Large));
        return result;
    }
    
}
