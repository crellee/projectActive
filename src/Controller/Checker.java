package Controller;

import javafx.scene.control.CheckBox;

/**
 * Created by BobLarsen on 24-11-2015.
 */
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
