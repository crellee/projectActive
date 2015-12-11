package Controller;

/**
 * Created by christianhasselstrom on 25/11/2015.
 */

/*
This class is used to create a user type of Buyer.
 */

public class Buyer extends Person
{
    private String businessName;
    private String businessEmail;
    private String password;
    private String location;
    private String city;
    private int cvr;
    private double rating;


    public Buyer()
    {

    }

    public Buyer(String firstName, String lastName, String businessName, String businessEmail, String password,
                  String location, String city, int cvr, double rating)
    {

        this.businessName = businessName;
        this.businessEmail = businessEmail;
        this.password = password;
        this.location = location;
        this.city = city;
        this.cvr = cvr;
        this.rating = rating;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
