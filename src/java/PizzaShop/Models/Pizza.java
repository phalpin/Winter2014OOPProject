/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import java.util.ArrayList;

/**
 *
 * @author phalpin
 */
public class Pizza extends DBEntity implements IPriceableEntity {
    private String _name;
    private PizzaSize _size;
    private PizzaType _type;
    private ArrayList<PizzaTopping> _toppings;

    public Pizza(PizzaSize size, PizzaType type){
        _size = size;
        _type = type;
    }
    
    public PizzaSize getSize(){
        return _size;
    }
    
    public void setSize(PizzaSize size){
        _size = size;
    }
    
    public PizzaType getType(){
        return _type;
    }
    
    public void setType(PizzaType type){
        _type = type;
    }
    
    @Override
    public double getCost() {
        double amount = 0.0;
        amount += _size.getCost();
        amount += _type.getCost();
        for(PizzaTopping pt : _toppings){
            amount += pt.getCost();
        }
        return amount;
    }
}
