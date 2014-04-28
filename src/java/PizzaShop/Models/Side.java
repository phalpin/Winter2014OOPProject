package PizzaShop.Models;

/**
 * Side - exists as an abstract class to determine side objects that you can order along with your pizza!
 */
public abstract class Side extends DBEntity implements IPriceableEntity {
    private double _cost;
    
    /**
     * Constructor
     * @param cost Cost of this side. 
     */
    public Side(double cost){
        _cost = cost;
    }
    
    /**
     * Setter for the cost of this side.
     * @param cost Cost to assign for this side.
     */
    public void setCost(double cost){
        _cost = cost;
    }
    
    @Override
    public double getCost(){
        return _cost;
    }
}
