package PizzaShop.Models;

import java.util.ArrayList;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 * The User Object.
 */
public class User extends Contact {

    /**
     * Constructor - initializes the order collection.
     */
    public User(){
        orders = new ArrayList<Order>();
    }
    
    //<editor-fold desc="Getters and Setters because lolJava">
    
    /**
     * Accessor to retrieve the DB ID of the Contact for this user
     * @return The DB ID of the contact for this user.
     */
    public int getContactId() {
        return contactId;
    }

    /**
     * Allows for the creation of a user-> contact relationship.
     * @param contactId Contact ID to associate with this user.
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    /**
     * Accessor for retrieving the type of user this is.
     * @return Type of user - Admin, User, etc.
     */
    public UserType getType() {
        return type;
    }

    /**
     * Setter for what type of user this is.
     * @param type Type you want to assign to this user.
     */
    public void setType(UserType type) {
        this.type = type;
    }

    /**
     * Accessor for retrieving this user's username.
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for the username.
     * @param username Username you want to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Method for retrieving password from this user.
     * @return Password - check getIsEncrypted for whether or not we're looking at cleartext.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for this user. Cleartext.
     * @param password Password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the salt used to generate this user's password.
     * @return The salt for this user's password.
     */
    public String getSalt() {
        return salt;
    }

    /**
     * Sets the salt used to generate this user's password.
     * @param salt Salt to use.
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    /**
     * Defines whether or not the password for this user has been encrypted yet.
     * @param encrypted boolean - whether we're encrypted or not.
     */
    public void setIsEncrypted(boolean encrypted){
        this.isEncrypted = encrypted;
    }
    
    /**
     * Accessor for retrieving whether this user's password has been encrypted yet.
     * @return Whether or not the password is encrypted.
     */
    public boolean getIsEncrypted(){
        return isEncrypted;
    }
    
    /**
     * Accessor for retrieving this user's session.
     * @return Session belonging to this user.
     */
    public Session getSession() {
        return session;
    }

    /**
     * Allows you to set the session associated with this user.
     * @param session Session to associate with this user.
     */
    public void setSession(Session session) {
        this.session = session;
    }
    
    /**
     * Method for getting all orders associated with this user.
     * @return The orders associated with this user.
     */
    public ArrayList<Order> getOrders(){
        return orders;
    }
    
    /**
     * Allows you to set all orders associated with this user.
     * @param orders Orders to assign.
     */
    public void setOrders(ArrayList<Order> orders){
        this.orders = orders;
    }
    
    /**
     * Retrieves the DB ID of the session associated with this user.
     * @return DB ID of associated session.
     */
    public int getSessionId(){
        return sessionId;
    }
    
    /**
     * Sets the DB ID of the session associated with this user.
     * @param sessionId ID to associated with this user.
     */
    public void setSessionId(int sessionId){
        this.sessionId = sessionId;
    }
    //</editor-fold>
    
    /**
     * Adds an order to this user's collection.
     * @param order Order to add.
     */
    public void addOrder(Order order){
        orders.add(order);
    }
    
    /**
     * Removes an order from this user's collection.
     * @param order Order to remove.
     * @return whether or not we were able to remove the order.
     */
    public boolean removeOrder(Order order){
        return orders.remove(order);
    }
    
    /**
     * Provides the methodology for encrypting the password before saving it to the database.
     */
    public void EncryptPassword(){
        if(!isEncrypted){
            StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
            password = spe.encryptPassword(password);
            salt = String.valueOf(spe.hashCode());
            isEncrypted = true;
        }
    }
    
    /**
     * Checks a password against this user's password to see if it is valid
     * @param password Password (cleartext to check against this user's encrypted password)
     * @return Whether or not it's a successful match.
     */
    public boolean CheckPassword(String password){
        StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
        return spe.checkPassword(password, this.password);
    }
    
    private int contactId;
    private int sessionId;
    private UserType type;
    private String username;
    private String password;
    private String salt;
    private boolean isEncrypted;
    private Session session;
    private ArrayList<Order> orders;
}
