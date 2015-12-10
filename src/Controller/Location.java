package Controller;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by roije on 27/11/2015.
 */
/*
This class is creating a Location object. Used when filling ComboBoxes with standard locations from the database
 */
public class Location
{
    private String postNo;
    private String city;

    public Location()
    {

    }

    public Location(String postNo, String city)
    {
        this.postNo = postNo;
        this.city =  city;
    }

    public String getPostNo()
    {
        return postNo;
    }

    public void setPostNo(String postNo)
    {
        this.postNo = postNo;
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
