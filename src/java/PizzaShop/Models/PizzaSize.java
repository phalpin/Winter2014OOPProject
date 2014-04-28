package PizzaShop.Models;

import PizzaShop.Outbound.SizeJSON;
import java.util.ArrayList;

/**
 * PizzaSize enum - contains all information for available pizza sizes.
 */
public enum PizzaSize implements IDBEnum, IPriceableEntity {
    //Values
    Small (1, "Small", 5.00),
    Medium (2, "Medium", 7.50),
    Large (3, "Large", 10.00);

    /**
     * Retrieve the specific size of pizza from a database ID.
     * @param sizeId DB ID to read.
     * @return PizzaSize associated with that enum's id.
     */
    public static PizzaSize fromId(int sizeId) {
        return PizzaSize.values()[sizeId - 1];
    }
    
    /**
     * Enum Implementation.
     * @param val DB ID of this enum.
     * @param name String representation of this enum.
     * @param cost Cost associated with this enum.
     */
    PizzaSize(int val, String name, double cost){
        _value = val;
        _name = name;
        _cost = cost;
    }
    private final int _value;
    private final String _name;
    private final double _cost;

    /**
     * Method for retrieving the name (string representation) of this particular Pizza Size.
     * @return The string representation of the name of this particular pizza size.
     */
    @Override
    public String getName() {
        return _name;
    }

    /**
     * Method for retrieving the value (AKA, DB ID) for this particular Pizza Size.
     * @return the integer database ID for this particular Pizza Size.
     */
    @Override
    public int getValue() {
        return _value;
    }
    
    /**
     * Method for retrieving the cost for this particular Pizza Size.
     * @return double Cost.
     */
    @Override
    public double getCost(){
        return _cost;
    }
    
    /**
     * Returns all items for sending via JSON.
     * @return ArrayList of SizeJSON formatted items to send from a web service.
     */
    public static ArrayList<SizeJSON> getOptions(){
        ArrayList<SizeJSON> result = new ArrayList<SizeJSON>();
        result.add(new SizeJSON(Small));
        result.add(new SizeJSON(Medium));
        result.add(new SizeJSON(Large));
        return result;
    }
    
}
