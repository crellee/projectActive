package DatabaseController;

import Model.Buyer;
import Model.Seller;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public static boolean userExists(TextField email)
    {
        //creates Arraylists with buyers emails and sellers email
        ArrayList<Buyer> ls1 = new ArrayList<>();
        ArrayList<Seller> ls2 = new ArrayList<>();
        try
        {
            ResultSet rs = DBHandlerSellerAndBuyer.isUnique();

            while (rs.next()) {

                Buyer buyer = new Buyer();
                Seller seller = new Seller();

                buyer.setBusinessEmail(rs.getString("businessEmail"));

                seller.setEmail(rs.getString("email"));

                ls1.add(buyer);
                ls2.add(seller);
            }
        }
        catch(Exception e1)
        {

        }
        // if when a new user is created the chosen email allready exists in the database either busiE or sellE will be 1
        for(int i = 0; i < ls1.size(); i++)
        {
            if(email.getText().equals(ls1.get(i).getBusinessEmail()))
            {
                return true;

            }
        }
        for(int i = 0; i < ls2.size(); i++)
        {
            if(email.getText().equals(ls2.get(i).getEmail()))
            {
                return true;

            }
        }
        return false;
    }

    public static boolean validDates(DatePicker startDate, DatePicker endDate)
    {
        if(startDate.getValue().isBefore(endDate.getValue()) || startDate.getValue().isEqual(endDate.getValue()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
