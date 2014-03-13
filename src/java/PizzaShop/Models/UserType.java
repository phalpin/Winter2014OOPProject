/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

/**
 * User Types
 * @author phalpin
 */
public enum UserType implements IDBEnum {
    //Values
    Customer (1, "Customer"),
    VIP (2, "VIP"),
    User (3, "User"),
    Administrator (4, "Administrator");
    
    
    //Enum Implementation
    UserType(int val, String name){
        _value = val;
        _name = name;
    }
    private final int _value;
    private final String _name;
    
    //Implementations
    @Override
    public String getName(){
        return _name;
    }
    
    @Override
    public int getValue(){
        return _value;
    }
    
}
