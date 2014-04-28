package PizzaShop.Resources;

/**
 * ActionResult Definition.
 * @param <T> Any class. Who cares.
 */
public interface IActionResult<T> {
    /**
     * Set the result of a requested action.
     * @param obj Object to set.
     */
    public void setResult(T obj);
    
    /**
     * Retrieve the result of a requested action.
     * @return Object requested.
     */
    public T getResult();
    
    /**
     * Sets the status of this action attempt.
     * @param status ActionResultStatus - success or failure.
     */
    public void setStatus(ActionResultStatus status);

    /**
     * Accessor for the status of a given attempt.
     * @return ActionResultStauts - success or failure.
     */
    public ActionResultStatus getStatus();
    
    /**
     * Sets the message for a given ActionResult.
     * @param msg Message to pass along.
     */
    public void setMessage(String msg);
    
    /**
     * Sets the message for a given ActionResult with an exception message included.
     * @param msg Message to send.
     * @param ex Exception to grab the second part of the message from.
     */
    public void setMessage(String msg, Exception ex);
    
    /**
     * Accessor for the message sent along with the action attempt.
     * @return Message associated with the action attempt.
     */
    public String getMessage();
    
    /**
     * Returns whether or not the action result was a success (defined by both having a result and actionresultstatus.success)
     * @return boolean.
     */
    public boolean isSuccess();
}
