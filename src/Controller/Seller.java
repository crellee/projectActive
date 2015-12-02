package Controller;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by roije on 25/11/2015.
 */
public class Seller
{
    private String firstName;
    private String lastName;
    private String birthday;
    private int age;
    private String email;
    private String password;
    private ArrayList<String> qualifications;
    private String location;
    private double rating = 0.0;
    private String city;
    private int qualiCarpenter;
    private int qualiJanitor;
    private int qualiCleaner;
    private int qualiWaiter;
    private int qualiChef;
    private int qualiBartender;
    private int qualiStore;
    private int qualiRetail;
    private int qualiPeda;


    //qualiCarpenter, qualiJanitor, qualiCleaner, qualiWaiter," +
    //"qualiChef, qualiBartender, qualiStore, qualiRetail, qualiPeda

    public Seller()
    {

    }

    public Seller(String firstName, String lastName, String birthday, String email, String password,
                  ArrayList<String> qualifications, String location, double rating, String city, int qualiCarpenter,
                  int qualiJanitor, int qualiCleaner, int qualiWaiter, int qualiChef, int qualiBartender, int qualiStore,
                  int qualiRetail, int qualiPeda)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.qualifications = qualifications;
        this.location = location;
        this.rating = rating;
        this.city = city;
        this.qualiCarpenter = qualiCarpenter;
        this.qualiJanitor = qualiJanitor;
        this.qualiCleaner = qualiCleaner;
        this.qualiWaiter = qualiWaiter;
        this.qualiChef = qualiChef;
        this.qualiBartender = qualiBartender;
        this.qualiStore = qualiStore;
        this.qualiRetail = qualiRetail;
        qualiPeda = qualiPeda;
    }

    public int getQualiCarpenter() {
        return qualiCarpenter;
    }

    public void setQualiCarpenter(int qualiCarpenter) {
        this.qualiCarpenter = qualiCarpenter;
    }

    public int getQualiJanitor() {
        return qualiJanitor;
    }

    public void setQualiJanitor(int qualiJanitor) {
        this.qualiJanitor = qualiJanitor;
    }

    public int getQualiCleaner() {
        return qualiCleaner;
    }

    public void setQualiCleaner(int qualiCleaner) {
        this.qualiCleaner = qualiCleaner;
    }

    public int getQualiWaiter() {
        return qualiWaiter;
    }

    public void setQualiWaiter(int qualiWaiter) {
        this.qualiWaiter = qualiWaiter;
    }

    public int getQualiBartender() {
        return qualiBartender;
    }

    public void setQualiBartender(int qualiBartender) {
        this.qualiBartender = qualiBartender;
    }

    public int getQualiStore() {
        return qualiStore;
    }

    public void setQualiStore(int qualiStore) {
        this.qualiStore = qualiStore;
    }

    public int getQualiRetail() {
        return qualiRetail;
    }

    public void setQualiRetail(int qualiRetail) {
        this.qualiRetail = qualiRetail;
    }

    public int getQualiPeda() {
        return qualiPeda;
    }

    public void setQualiPeda(int qualiPeda) {
        this.qualiPeda = qualiPeda;
    }

    public int getQualiChef() {
        return qualiChef;
    }

    public void setQualiChef(int qualiChef) {
        this.qualiChef = qualiChef;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public ArrayList<String> getQualifications()
    {
        return qualifications;
    }

    public void setQualifications(ArrayList<String> qualifications)
    {
        this.qualifications = qualifications;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public double getRating()
    {
        return rating;
    }

    public void setRating(double rating)
    {
        this.rating = rating;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }
}
