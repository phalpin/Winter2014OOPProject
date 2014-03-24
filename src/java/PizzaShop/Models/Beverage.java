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
public class Beverage extends Side{
    private double _size;
    private String _name;
    
    public Beverage(String name, double size, double price){
        super(price);
        _size = size;
        _name = name;
    }
    
    
    public String getName(){
        return _name;
    }
    
    public void setName(String name){
        _name = name;
    }
    
    public double getSize(){
        return _size;
    }
    
    public void setSize(double size){
        _size = size;
    }
}
