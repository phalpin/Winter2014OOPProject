package PizzaShop.Models;

import java.util.ArrayList;

/**
 * The Pizza Object - What most of the app centers around outside of orders.
 */
public class Pizza extends DBEntity implements IPriceableEntity{
    private String name;
    private PizzaSize size;
    private PizzaType type;
    private ArrayList<PizzaTopping> toppings;
    private int orderId;

    /**
     * Default Constructor - Initializes the toppings collection.
     */
    public Pizza(){
        toppings = new ArrayList<PizzaTopping>();
    }
    
    /**
     * Pizza Constructor for initializing the pizza with a size and type.
     * @param size Size of the pizza (based on the PizzaSize enum.)
     * @param type Type of the pizza (based on the PizzaType enum.)
     */
    public Pizza(PizzaSize size, PizzaType type){
        this.size = size;
        this.type = type;
        toppings = new ArrayList<PizzaTopping>();
    }
    
    /**
     * Accessor for the size of this pizza.
     * @return The size of the pizza.
     */
    public PizzaSize getSize(){
        return size;
    }
    
    /**
     * Allows you to set the size of this pizza.
     * @param size Size of the pizza you want to set.
     */
    public void setSize(PizzaSize size){
        this.size = size;
    }
    
    /**
     * Accessor for the type of pizza this is.
     * @return Type of pizza.
     */
    public PizzaType getType(){
        return type;
    }
    
    /**
     * Accessor for getting the order this pizza is associated with.
     * @return Order number.
     */
    public int getOrderId(){
        return orderId;
    }
    
    /**
     * Allows you to set the order this pizza is associated with.
     * @param orderId Order ID to attach this pizza to.
     */
    public void setOrderId(int orderId){
        this.orderId = orderId;
    }
    
    /**
     * Sets the type of Pizza this is.
     * @param type Type of pizza you want to set to.
     */
    public void setType(PizzaType type){
        this.type = type;
    }
    
    /**
     * Adds a topping to the topping collection on this pizza.
     * @param topping Topping enum to add.
     */
    public void addTopping(PizzaTopping topping){
        toppings.add(topping);
    }
    
    /**
     * Method for removing a particular topping from this particular pizza.
     * @param topping Removes a given topping from this particular pizza.
     */
    public void removeTopping(PizzaTopping topping){
        toppings.remove(topping);
    }
    
    /**
     * Method for retrieving the list of toppings within this particular pizza.
     * @return A list of toppings for this particular pizza.
     */
    public ArrayList<PizzaTopping> getToppings(){
        return toppings;
    }
    
    /**
     * Method for determining whether this particular pizza has a topping.
     * @param t Topping to check for on this particular pizza.
     * @return true or false, based on 
     */
    public boolean hasTopping(PizzaTopping t){
        return toppings.contains(t);
    }
    
    @Override
    public double getCost() {
        double amount = 0.0;
        amount += size.getCost();
        amount += type.getCost();
        for(PizzaTopping pt : toppings){
            amount += pt.getCost();
        }
        return amount;
    }
}
