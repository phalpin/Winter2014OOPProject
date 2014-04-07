/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

/**
 * Side - exists as an abstract class to determine side objects that you can order along with your pizza!
 * @author phalpin
 */
public abstract class Side extends DBEntity implements IPriceableEntity {
    private double _cost;
    
    public Side(double cost){
        _cost = cost;
    }
    
    
    /**
     * 
     * @return 
     */
    @Override
    public double getCost(){
        return _cost;
    }
    
    public void setCost(double cost){
        _cost = cost;
    }
}
