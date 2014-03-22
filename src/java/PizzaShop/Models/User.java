/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package PizzaShop.Models;

import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author phalpin
 */
public class User extends Contact {

    public User(){}
    
    //<editor-fold desc="Getters and Setters because lolJava">
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    public void setIsEncrypted(boolean encrypted){
        this.isEncrypted = encrypted;
    }
    
    public boolean getIsEncrypted(){
        return isEncrypted;
    }
    //</editor-fold>
    
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
    private UserType type;
    private String sessionId;
    private String username;
    private String password;
    private String salt;
    private boolean isEncrypted;
    
}
