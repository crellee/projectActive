import java.util.ArrayList;

/**
 * Created by roije on 25/11/2015.
 */
public class Seller
{
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;
    private ArrayList<String> qualifications;
    private String location;
    private double rating;

    public Seller()
    {

    }

    public Seller(String firstName, String lastName, int age, String email, String password,
                  ArrayList<String> qualifications, String location, double rating)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.qualifications = qualifications;
        this.location = location;
        this.rating = rating;
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
}
