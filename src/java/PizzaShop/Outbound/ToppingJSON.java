/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Outbound;

import PizzaShop.Models.PizzaTopping;

/**
 *
 * @author phalpin
 */
public class ToppingJSON {
    private final String name;
    private final double cost;
    private int id;
    
    public ToppingJSON(PizzaTopping top){
        name = top.getName();
        cost = top.getCost();
        id = top.getValue();
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
