/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Resources;

/**
 * The Generic ActionResult Return Type.
 * @author phalpin
 * @param <T> Type of Result to check for.
 */
public class ActionResult<T> implements IActionResult<T> {

    private T _result;
    private String _msg;
    private ActionResultStatus _status;
    
    
    //<editor-fold desc="IActionResult Members">
    @Override
    public void setResult(T obj) {
        _result = obj;
    }

    @Override
    public T getResult() {
        return _result;
    }

    @Override
    public void setStatus(ActionResultStatus status) {
        _status = status;
    }

    @Override
    public ActionResultStatus getStatus() {
        return _status;
    }

    @Override
    public void setMessage(String msg) {
        _msg = msg;
    }

    @Override
    public String getMessage() {
        return _msg;
    }
    
    @Override
    public boolean isSuccess(){
        return _status == ActionResultStatus.SUCCESS;
    }
    //</editor-fold>

    public void setMessage(String an_error_occurred, Exception ex) {
        _msg = an_error_occurred + ": " + ex.getMessage();
    }
    
    
}