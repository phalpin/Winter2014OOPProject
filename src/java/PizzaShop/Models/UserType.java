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
    Customer (1),
    VIP (2),
    User (3),
    Administrator (4);
    
    
    //Enum Implementation
    UserType(int val){
        _value = val;
    }
    private final int _value;
    
    //Implementations
    @Override
    public int getName(){
        return _value;
    }
}
