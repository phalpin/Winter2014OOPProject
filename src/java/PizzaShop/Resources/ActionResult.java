package PizzaShop.Resources;

/**
 * The Generic ActionResult Return Type.
 * @author phalpin
 * @param <T> Type of Result to check for.
 */
public class ActionResult<T> implements IActionResult<T> {
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
    
    @Override
    public void setMessage(String errorText, Exception ex) {
        _msg = errorText + ": " + ex.getMessage();
    }
    //</editor-fold>
    
    private T _result;
    private String _msg;
    private ActionResultStatus _status;
}