package PizzaShop.Models;

import java.util.ArrayList;

/**
 * The Order Object - the main focal point of the application. Contains User Id, Pizzas on the order, sides on the order, etc.
 */
public class Order extends DBEntity implements IPriceableEntity{

    private final ArrayList<Pizza> pizzas;
    private final ArrayList<Side> sides;
    private int userId;
    
    /**
     * Default Constructor. Initializes the pizza and side collections.
     */
    public Order(){
        pizzas = new ArrayList<Pizza>();
        sides = new ArrayList<Side>();
    }
    
    /**
     * Adds a pizza to this order.
     * @param p Pizza to add to the order.
     */
    public void addPizza(Pizza p){
        pizzas.add(p);
    }
    
    /**
     * Removes a pizza from this order.
     * @param p Pizza to remove from the order.
     */
    public void removePizza(Pizza p){
        pizzas.remove(p);
    }
    
    /**
     * Accessor for determining whether this order has a pizza or not.
     * @param p Pizza to check for.
     * @return boolean representing whether the requested pizza is in the order collection.
     */
    public boolean hasPizza(Pizza p){
        return pizzas.contains(p);
    }
    
    /**
     * Accessor for the pizzas on this order.
     * @return ArrayList of pizzas on this order.
     */
    public ArrayList<Pizza> getPizzas(){
        return pizzas;
    }
    
    /**
     * Adds a side to the order
     * @param s Side you want to add to the order.
     */
    public void addSide(Side s){
        sides.add(s);
    }
    
    /**
     * Removes a side from the order.
     * @param s Side to remove from the order.
     */
    public void removeSide(Side s){
        sides.remove(s);
    }
    
    /**
     * Accessor for determining whether this order has a side or not.
     * @param s Side to check for.
     * @return boolean.
     */
    public boolean hasSide(Side s){
        return sides.contains(s);
    }
    
    /**
     * Accessor for the sides on this order.
     * @return ArrayList of Sides.
     */
    public ArrayList<Side> getSides(){
        return sides;
    }
    
    @Override
    public double getCost() {
        double total = 0.0;
        
        for(Pizza p : pizzas){
            total += p.getCost();
        }
        
        for(Side s : sides){
            total += s.getCost();
        }
        
        return total;
    }
    
    /**
     * Accessor to get the user id this order belongs to.
     * @return the userId associated with this order.
     */
    public int getUserId(){
        return this.userId;
    }
    
    /**
     * Setter to set the user id associated with this order. (SERVICE LAYER ONLY)
     * @param userId User Id you want to associate with this order.
     */
    public void setUserId(int userId){
        this.userId = userId;
    }
    
}
