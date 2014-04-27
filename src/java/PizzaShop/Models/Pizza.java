package PizzaShop.Models;

import PizzaShop.Resources.GsonManager;
import java.util.ArrayList;


public class Pizza extends DBEntity implements IPriceableEntity, ISerializable<Pizza> {
    private String name;
    private PizzaSize size;
    private PizzaType type;
    private ArrayList<PizzaTopping> toppings;
    private int orderId;

    public Pizza()
    {
        toppings = new ArrayList<PizzaTopping>();
    }
    
    public Pizza(PizzaSize size, PizzaType type){
        this.size = size;
        this.type = type;
        toppings = new ArrayList<PizzaTopping>();
    }
    
    public PizzaSize getSize(){
        return size;
    }
    
    public void setSize(PizzaSize size){
        this.size = size;
    }
    
    public PizzaType getType(){
        return type;
    }
    
    public int getOrderId(){
        return orderId;
    }
    
    public void setOrderId(int orderId){
        this.orderId = orderId;
    }
    
    public void setType(PizzaType type){
        this.type = type;
    }
    
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

    /**
     * Method to serialize this object out to a Json string.
     * @return Json string representation of this particular Pizza object.
     */
    @Override
    public String toJson() {
        return GsonManager.GO.toJson(this);
    }
    
    /**
     * Method to deserialize a new Pizza object from a given Json string.
     * @param json the json string to deserialize an object from.
     * @return a new Pizza object, deserialized from the parameterized json.
     */
    public static Pizza fromJson(String json){
        return GsonManager.GO.fromJson(json, Pizza.class);
    }
    
    
}
