/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

/**
 *
 * @author phalpin
 */
public class PizzaTopping extends DBEntity implements IPriceableEntity{

    private String _name;
    private double _cost;
    
    public PizzaTopping(String name, double cost)
    {
        _name = name;
        _cost = cost;
    }
    
    @Override
    public double getCost() {
        return _cost;
    }

    public void setCost(double cost) {
        _cost = cost;
    }
    
    public String getName(){
        return _name;
    }
    
    public void setName(String name){
        _name = name;
    }
    
}
