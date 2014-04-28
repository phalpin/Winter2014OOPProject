package PizzaShop.Outbound;

import PizzaShop.Models.PizzaType;

/**
 * JSON Friendly Representation of the PizzaType enum.
 */
public class TypeJSON {
    private final String name;
    private final double cost;
    private final int id;
    
    public TypeJSON(PizzaType type){
        name = type.getName();
        cost = type.getCost();
        id = type.getValue();
    }
    
    public String getName(){
        return name;
    }
    
    public double getCost(){
        return cost;
    }
    
    public int getId(){
        return id;
    }
}
