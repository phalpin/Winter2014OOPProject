package PizzaShop.Models;

import flexjson.JSONSerializer;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * The Person Model
 * @author phalpin
 */
public class Person implements Serializable<Person>{
    
    /**
     * Default Constructor. Unused.
     */
    public Person(){}
    
    //Person's DB ID
    private int _id;
    public int getId(){ return this._id; }
    public void setId(int value){ this._id = value; }
    
    //Person's First Name
    private String _firstName;
    public String getFirstName() { return this._firstName; }
    public void setFirstName(String value) { this._firstName = value; }
    
    //Person's Middle Name
    private String _middleName;
    public String getMiddleName() { return this._middleName; }
    public void setMiddleName(String value) { this._middleName = value; }
    
    //Person's Last Name
    private String _lastName;
    public String getLastName() { return this._lastName; }
    public void setLastName(String value) { this._lastName = value; }
    
    //Person's Phone Number
    private String _phoneNumber;
    public String getPhoneNumber(){ return this._phoneNumber; }
    public void setPhoneNumber(String value) { this._phoneNumber = value; }
    
    //Person's Address
    private String _address;
    public String getAddress(){ return this._address; }
    public void setAddress(String value){ this._address = value; }

    @Override
    public String toJson() {
        JSONSerializer r = new JSONSerializer();
        return r.serialize(this);
    }

    @Override
    public void fromJson(String json) throws JSONException {
        JSONObject j = new JSONObject(json);
        this._firstName = j.getString("FirstName");
        this._middleName = j.getString("MiddleName");
        this._lastName = j.getString("LastName");
        this._phoneNumber = j.getString("PhoneNumber");
        this._address = j.getString("Address");
    }
}
