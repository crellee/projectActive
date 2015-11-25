package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by roije on 25/11/2015.
 */
public class DBHandlerSeller
{
    public static void saveSeller(TextField firstName, TextField lastName, DatePicker birthdate, TextField email,
                                  PasswordField password, ComboBox qualifications, ComboBox location, TextField city)
    {
        String firstNameStr = firstName.getText();
        String lastNameStr = lastName.getText();
        String birthDateStr = birthdate.getValue().toString();
        String emailStr = email.getText();
        String passwordStr = password.getText();
        String qualificationStr = qualifications.getValue().toString();
        String locationStr = location.getValue().toString();
        String cityStr = city.getText();
        int age = calcAge(birthDateStr);
        double rating = 0.0;

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            String sqlString = ("INSERT INTO Sellers(firstName, lastName, birthday, age, email, password, " +
                    "qualification, location, rating, city) " +
                    "VALUES ('"+firstNameStr+"', '"+lastNameStr+"', '"+birthDateStr+"', '"+age+"'," +
                    " '"+emailStr+"', '"+passwordStr+"'," +
                    " '"+qualificationStr+"', '"+locationStr+"', '"+rating+"', '"+cityStr+"')");

            stmt.executeUpdate(sqlString);
        }
        catch (Exception e)
        {

        }
    }


    public static int calcAge(String birthdate)
    {
        int birthday = Integer.parseInt(birthdate.substring(8,10));
        int birthmonth = Integer.parseInt(birthdate.substring(5,7));
        int birthyear = Integer.parseInt(birthdate.substring(0,4));

        Calendar birthinfo = new GregorianCalendar(birthyear, birthmonth, birthday);
        Calendar now = new GregorianCalendar();

        int age = now.get(Calendar.YEAR) - birthinfo.get(Calendar.YEAR);

        return age;
    }
}
