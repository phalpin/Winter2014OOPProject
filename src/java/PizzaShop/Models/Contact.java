package PizzaShop.Models;

/**
 * The Contact Object
 */
public class Contact extends DBEntity {
    /**
     * Constructor - nothing to initialize.
     */
    public Contact(){}

    //<editor-fold desc="Getters and Setters because lolJava.">
    
    /**
     * Getter for name of contact
     * @return The name of the contact
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for the first name of the contact
     * @param firstName the first name to set for this contact
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for the middle name of this contact
     * @return The middle name of the contact.
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Setter for the middle name of this contact
     * @param middleName Middle name you want to set for this contact.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Getter for the last name of this contact.
     * @return The last name of this contact.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the last name of this contact
     * @param lastName last name you want to assign to this contact.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for the home number of this contact
     * @return The home number of the contact.
     */
    public String getHomeNumber() {
        return homeNumber;
    }

    /**
     * Setter for the home number of this contact
     * @param homeNumber The home number you want to set for this contact.
     */
    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    /**
     * Getter for the mobile number of this contact.
     * @return The mobile number of this contact.
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Setter for the mobile number of this contact.
     * @param mobileNumber The mobile number you want to set for this contact.
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    //</editor-fold>
    
    private String firstName;
    private String middleName;
    private String lastName;
    private String homeNumber;
    private String mobileNumber;    
}
