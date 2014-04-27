/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Outbound;

import PizzaShop.Models.PizzaSize;

/**
 *
 * @author phalpin
 */
public class SizeJSON {
    private final String name;
    private final double cost;
    private int id;
    
    public SizeJSON(PizzaSize size){
        name = size.getName();
        cost = size.getCost();
        id = size.getValue();
    }
    
    public String getName(){
        return name;
    }
    
    public double getCost(){
        return cost;
    }
    
    public int getId(){
        return id;
    }
}
