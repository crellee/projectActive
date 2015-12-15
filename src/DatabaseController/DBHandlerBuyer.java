package DatabaseController;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.ResultSet;

/**
 * Created by christianhasselstrom on 25/11/2015.
 */
//DBHandlerBuyer contains methods which have to do with Buyer and the connection to the database
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
        int numberOfRating = 1;
        double totalRating = 0.0;

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            String sqlStrings = ("INSERT INTO Buyers(firstName, lastName, businessName, businessEmail, password," +
                    "location, cvr, rating, numberOfRating, totalRating) " +
                    "VALUES ('"+firstNameStr+"', '"+lastNameStr+"', '"+businessNameStr+"', '"+businessEmailStr+"', " +
                    "'"+passwordStr+"', '"+locationStr+"','"+cvrInt+"', '"+rating+"', '"+numberOfRating+"', '"+totalRating+"' )");

            stmt.executeUpdate(sqlStrings);

        }
        catch (Exception e)
        {

        }

    }

    /*
    This method is user for updating a user of type Buyer. The methods takes parameters from the GUI
   and uses them to update in the DatabaseController
     */
    public static void updateBuyerProfile(TextField firstName, TextField lastName, TextField businessName, TextField businessEmail,
                                          PasswordField password, ComboBox location, TextField cvr)
    {
        String firstNameStr = firstName.getText();
        String lastNameStr = lastName.getText();
        String businessNameStr = businessName.getText();
        String businessEmailStr = businessEmail.getText();
        String passwordStr = password.getText();
        String locationStr = location.getValue().toString();
        int cvrInt = Integer.parseInt(cvr.getText());

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            String sqlString = "UPDATE Buyers SET firstName='"+firstNameStr+"', lastName='"+lastNameStr+"'," +
                    "businessName='"+businessNameStr+"', password='"+passwordStr+"', location='"+locationStr+"'," +
                    "cvr='"+cvrInt+"' WHERE businessEmail = '"+businessEmailStr+"'";

            stmt.executeUpdate(sqlString);
        }
        catch(Exception e1)
        {

        }
    }

    /*
    This method is used for getting the necessary information for the user logging in.
    By using his email, which we get from LoginVerifier.getEmail(), we can use a WHERE statement to find
    the user in the database. This method is being galled in myProfileWindow() method in MyProfileBuyer class
    */
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

    /*
    This method is used when editing a user of type Buyer.
    It is used in openWindow() method in EditBuyerClass.
     */
    public static ResultSet getUserInformationsForEdit()
    {
        String email = LoginVerifier.getEmail();
        ResultSet rs = null;
        try
        {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT firstName, lastName, businessName, businessEmail, location, cvr, password" +
                    " FROM Buyers WHERE businessEmail = '"+email+"' ";
            rs = conn.createStatement().executeQuery(sqlString);
        }
        catch (Exception e)
        {

        }

        return rs;
    }

    /*
    This method returns a ResultSet, which is used in BuyersTable class -> getBuyersTable() to populate
    a TableView
     */
    public static ResultSet getUserInformationsForTable()
    {
        ResultSet rs = null;
        try
        {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT firstName, lastName, businessName, businessEmail, location, cvr, rating" +
                    " FROM Buyers ";
            rs = conn.createStatement().executeQuery(sqlString);
        }
        catch (Exception e)
        {

        }

        return rs;
    }

}
