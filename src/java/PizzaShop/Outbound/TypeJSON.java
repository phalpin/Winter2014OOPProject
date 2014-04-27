/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Outbound;

import PizzaShop.Models.PizzaType;

/**
 *
 * @author phalpin
 */
public class TypeJSON {
    private final String name;
    private final double cost;
    private int id;
    
    public TypeJSON(PizzaType type){
        name = type.getName();
        cost = type.getCost();
        id = type.getValue();
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
