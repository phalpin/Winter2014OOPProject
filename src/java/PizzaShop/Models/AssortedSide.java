package PizzaShop.Models;

import PizzaShop.Resources.GsonManager;

/**
 * Placeholder for Sides that don't fit into the beverage category.
 * @author phalpin
 */
public class AssortedSide extends Side {
    private String _name;
    private int _count;
    
    /**
     * Assorted Side constructor
     * @param name Name of the Side
     * @param count Count (qty) per unit
     * @param cost Price.
     */
    public AssortedSide(String name, int count, double cost){
        super(cost);
        _name = name;
        _count = count;
    }
    
    /**
     * Name of this side
     * @return the name of this side.
     */
    public String getName(){
        return _name;
    }
    
    /**
     * Set the name of this side.
     * @param name Name to rename with.
     */
    public void setName(String name){
        _name = name;
    }
    
    /**
     * Returns the count per unit of this side.
     * @return Count per Unit
     */
    public int getCount(){
        return _count;
    }
    
    /**
     * Set the amount of items per unit of this side.
     * @param count Items per Unit.
     */
    public void setCount(int count){
        _count = count;
    }
}
