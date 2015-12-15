package DatabaseController;

import DatabaseController.DBConnection;
import GUI.HomeScreenBuyer;
import GUI.HomeScreenSeller;
import com.mysql.jdbc.Connection;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by christianhasselstrom on 30/11/2015.
 * This class is creating a loginverifier, which is used to get the email from a user when he or she logs in.
 */
public class LoginVerifier
{

    static String email;

    public static void verifyUser (TextField mail, PasswordField pass)
    {

        String mailStr = mail.getText();
        String passStr = pass.getText();

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;

             if(mail != null && pass != null)
            {
                String sqlString = "SELECT * FROM Sellers WHERE email= '"+mailStr+"' AND password = '"+passStr+"' ";
                rs = stmt.executeQuery(sqlString);

                if(rs.next())
                {
                    HomeScreenSeller.homeScreenSeller();
                }
                else if(mail != null && pass != null)
                {
                    sqlString = "SELECT * FROM Buyers WHERE businessEmail= '"+mailStr+"' AND password = '"+passStr+"' ";
                    rs = stmt.executeQuery(sqlString);

                    if(rs.next())
                    {
                        HomeScreenBuyer.homeScreenBuyer();
                    }
                }

            }

        }
        catch(SQLException e)
        {

        }

    }

    //Set email variable to email in GUI TextField. Used when user is logging in to get the right user.
    public static void setEmail(TextField emailFromGui)
    {
        String emailStr = emailFromGui.getText();
        email = emailStr;
    }

    public static String getEmail()
    {
        return email;
    }

}
