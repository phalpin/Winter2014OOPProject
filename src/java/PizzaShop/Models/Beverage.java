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
    
    public double getSize(){
        return _size;
    }
    
    public void setSize(double size){
        _size = size;
    }
}