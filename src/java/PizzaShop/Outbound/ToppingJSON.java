package PizzaShop.Outbound;

import PizzaShop.Models.PizzaTopping;

/**
 * JSON Friendly Representation of the PizzaTopping enum.
 */
public class ToppingJSON {
    private final String name;
    private final double cost;
    private final int id;
    
    public ToppingJSON(PizzaTopping top){
        name = top.getName();
        cost = top.getCost();
        id = top.getValue();
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
