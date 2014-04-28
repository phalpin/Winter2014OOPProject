package PizzaShop.Models;

import PizzaShop.Outbound.ToppingJSON;
import java.util.ArrayList;

/**
 * The Pizza Topping enum - contains all pizza toppings available in our application.
 */
public enum PizzaTopping implements IDBEnum, IPriceableEntity {
    Pepperoni(1, "Pepperoni", 0.25),
    Sausage(2, "Sausage", 0.50),
    Jalapenos(3, "Jalapenos", 0.75),
    BlackOlives(4, "Black Olives", 0.50);
    
    /**
     * Enum Implementation
     * @param id Database ID of this enum.
     * @param name String Representation of this enum.
     * @param cost Cost associated with this enum.
     */
    PizzaTopping(int id, String name, double cost){
        _value = id;
        _cost = cost;
        _name = name;
    }

    /**
     * Accessor for getting a JSON friendly sending format for the enum.
     * @return ArrayList of ToppingJSON objects for sending via a webservice.
     */
    public static ArrayList<ToppingJSON> getOptions(){
        ArrayList<ToppingJSON> result = new ArrayList<ToppingJSON>();
        result.add(new ToppingJSON(Pepperoni));
        result.add(new ToppingJSON(Sausage));
        result.add(new ToppingJSON(Jalapenos));
        result.add(new ToppingJSON(BlackOlives));
        return result;
    }
    
    /**
     * Method for getting the enum from a DB ID
     * @param id ID to pull from.
     * @return PizzaTopping associated with that ID.
     */
    public static PizzaTopping fromId(int id){
        return PizzaTopping.values()[id-1];
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

    private final int _value;
    private final double _cost;
    private final String _name;
}

