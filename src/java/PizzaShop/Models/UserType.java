package PizzaShop.Models;

/**
 * User Types
 */
public enum UserType implements IDBEnum {
    Customer (1, "Customer"),
    VIP (2, "VIP"),
    User (3, "User"),
    Administrator (4, "Administrator");
    
    
    /**
     * Enum Implementation
     * @param val the DB ID of this enum
     * @param name The string representation of this enum.
     */
    UserType(int val, String name){
        _value = val;
        _name = name;
    }

    @Override
    public String getName(){
        return _name;
    }
    
    @Override
    public int getValue(){
        return _value;
    }
    
    private final int _value;
    private final String _name;
}
