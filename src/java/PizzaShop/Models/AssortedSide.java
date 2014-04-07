/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import PizzaShop.Resources.GsonManager;

/**
 * Placeholder for assorted sides.
 * @author phalpin
 */
public class AssortedSide extends Side {
    private String _name;
    private int _count;
    
    public AssortedSide(String name, int count, double cost){
        super(cost);
        _name = name;
        _count = count;
    }
    
    public String getName(){
        return _name;
    }
    
    public void setName(String name){
        _name = name;
    }
    
    public int getCount(){
        return _count;
    }
    
    public void setCount(int count){
        _count = count;
    }
    
    public static AssortedSide fromJson(String json){
        return GsonManager.GO.fromJson(json, AssortedSide.class);
    }
}
