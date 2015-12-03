package Controller;

/**
 * Created by christianhasselstrom on 25/11/2015.
 */
public class Buyer
{
    private String firstName;
    private String lastName;
    private String businessName;
    private String businessEmail;
    private String password;
    private String location;
    private String city;
    private int cvr;



    public Buyer(String firstName, String lastName, String businessName, String businessEmail, String password,
                  String location, String city, int cvr)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.businessName = businessName;
        this.businessEmail = businessEmail;
        this.password = password;
        this.location = location;
        this.city = city;
        this.cvr = cvr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }
}
