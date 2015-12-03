package Database;

import Controller.LoginVerifier;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by christianhasselstrom on 25/11/2015.
 */
//DBHandlerBuyer contains methods which have to do with Controller.Buyer and the connection to the database
public class DBHandlerBuyer
{

    //This method takes parameters from the GUI and saves the information in a database.
    //The parameters are saved as Strings before inserted into the Buyers table.
    public static void saveBuyer(TextField firstName, TextField lastName, TextField businessName, TextField businessEmail,
                                 PasswordField password, ComboBox location, TextField cvr)
    {
        String firstNameStr = firstName.getText();
        String lastNameStr = lastName.getText();
        String businessNameStr = businessName.getText();
        String businessEmailStr = businessEmail.getText();
        String passwordStr = password.getText();
        String locationStr = location.getValue().toString();
        int cvrInt = Integer.parseInt(cvr.getText());
        double rating = 0.0;

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            String sqlStrings = ("INSERT INTO Buyers(firstName, lastName, businessName, businessEmail, password," +
                    "location, cvr, rating) " +
                    "VALUES ('"+firstNameStr+"', '"+lastNameStr+"', '"+businessNameStr+"', '"+businessEmailStr+"', " +
                    "'"+passwordStr+"', '"+locationStr+"','"+cvrInt+"', '"+rating+"' )");

            stmt.executeUpdate(sqlStrings);

        }
        catch (Exception e)
        {

        }

    }

    public static ResultSet getUserInformations()
    {
        String email = LoginVerifier.getEmail();
        ResultSet rs = null;
        try
        {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT firstName, lastName, businessName, businessEmail, location, cvr, rating" +
                    " FROM Buyers WHERE businessEmail = '"+email+"' ";
            rs = conn.createStatement().executeQuery(sqlString);
        }
        catch (Exception e)
        {

        }

        return rs;
    }
}
