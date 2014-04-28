package PizzaShop.Models;

/**
 * The Beverage Side Object
 */
public class Beverage extends Side{
    private double _size;
    private String _name;
    
    /**
     * Beverage Constructor
     * @param name Name of the Beverage
     * @param size Fl. Oz per unit
     * @param price Price of the item.
     */
    public Beverage(String name, double size, double price){
        super(price);
        _size = size;
        _name = name;
    }
    
    /**
     * Returns the name of this beverage.
     * @return Name of Beverage.
     */
    public String getName(){
        return _name;
    }
    
    /**
     * Sets the name of this beverage.
     * @param name Name to set to.
     */
    public void setName(String name){
        _name = name;
    }
    
    /**
     * Gets the size of this beverage per unit
     * @return Oz per unit of this side.
     */
    public double getSize(){
        return _size;
    }
    
    /**
     * Sets the size of this beverage per unit.
     * @param size 
     */
    public void setSize(double size){
        _size = size;
    }
}
