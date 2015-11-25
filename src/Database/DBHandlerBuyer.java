package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

/**
 * Created by christianhasselstrom on 25/11/2015.
 */
public class DBHandlerBuyer
{
    public static void saveBuyer(TextField firstName, TextField lastName, TextField businessName, TextField businessEmail,
                                 PasswordField password, ComboBox location, TextField city, TextField cvr)
    {
        String firstNameStr = firstName.getText();
        String lastNameStr = lastName.getText();
        String businessNameStr = businessName.getText();
        String businessEmailStr = businessEmail.getText();
        String passwordStr = password.getText();
        String locationStr = location.getValue().toString();
        String cityStr = city.getText();
        String cvrStr = cvr.getText();

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            String sqlStrings = ("INSERT INTO Buyers(firstName, lastName, businessName, businessEmail, password," +
                    "location, city, cvr) " +
                    "VALUES ('"+firstNameStr+"', '"+lastNameStr+"', '"+businessNameStr+"', '"+businessEmailStr+"', " +
                    "'"+passwordStr+"', '"+locationStr+"', '"+cityStr+"', '"+cvrStr+"')");

            stmt.executeUpdate(sqlStrings);

        }
        catch (Exception e)
        {

        }

    }
}
