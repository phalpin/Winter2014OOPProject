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
public class Order extends DBEntity implements IPriceableEntity{

    private ArrayList<Pizza> _pizzas;
    private ArrayList<Side> _sides;
    
    @Override
    public double getCost() {
        double total = 0.0;
        
        for(Pizza p : _pizzas){
            total += p.getCost();
        }
        
        for(Side s : _sides){
            total += s.getCost();
        }
        
        return total;
    }
    
}
