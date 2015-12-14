package Controller;

import javafx.scene.control.CheckBox;

/**
 * Created by BobLarsen on 24-11-2015.
 */
//this method sets value 0 or 1 if a checkbox is selected when a user(seller) creates a profile.
//The value gets inserted into the Sellers table in the database
public class Checker
{
    public static int checkSelected(CheckBox checkbox)
    {
        boolean selected;
        selected = checkbox.isSelected();
        if(selected == true)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
