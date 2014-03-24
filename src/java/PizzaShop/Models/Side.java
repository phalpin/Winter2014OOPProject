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
public abstract class Side extends DBEntity implements IPriceableEntity {
    private double _cost;
    
    public Side(double cost){
        _cost = cost;
    }
    
    @Override
    public double getCost(){
        return _cost;
    }
    
    public void setCost(double cost){
        _cost = cost;
    }
}
