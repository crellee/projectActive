package Controller;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by roije on 11/12/2015.
 */
public class InputValidator
{
    /*
    This method is called in Login class -> login(); and used to validate the email TextField.
    It takes a TextField as paramater. It returns an integer. In the GUI, the integers represent different
    error messages.
    */
    public static int checkLoginEmail(TextField emailField)
    {
        String email = emailField.getText();
        if(email.equals(""))
        {
            return 1;
        }

        if(!email.contains(".") || !email.contains("@"))
        {
            return 2;
        }
        return 0;
    }

    //This method
    public static boolean checkLoginPassword(PasswordField passwordField)
    {
        String password = passwordField.getText();
        if(password.equals(""))
        {
            return false;
        }
        return true;
    }
}
