package PizzaShop.Outbound;

import PizzaShop.Models.PizzaSize;

/**
 * JSON Friendly Representation of the PizzaSize Enum.
 */
public class SizeJSON {
    private final String name;
    private final double cost;
    private int id;
    
    public SizeJSON(PizzaSize size){
        name = size.getName();
        cost = size.getCost();
        id = size.getValue();
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
