/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Resources;

/**
 *
 * @author phalpin
 */
public interface IActionResult<T> {
    public void setResult(T obj);
    public T getResult();
    
    public void setStatus(ActionResultStatus status);
    public ActionResultStatus getStatus();
    
    public void setMessage(String msg);
    public void setMessage(String msg, Exception ex);
    public String getMessage();
    
    public boolean isSuccess();
}
