package Database;

import Controller.LoginVerifier;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

/** This class contains methods to handle a Controller.Seller and the connection to the Sellers table in the database
 * Created by roije on 25/11/2015.
 */
public class DBHandlerSeller
{
    //This class takes parameters from the GUI in CreateSellerWindow class and inserts values into Sellers table
    //in the database
    public static void saveSeller(TextField firstName, TextField lastName, DatePicker birthdate, TextField email,
                                  PasswordField password, int carpenter, int janitor,
                                  int cleaner, int waiter, int chef,
                                  int bartender, int store, int retail,
                                  int peda, ComboBox location)
    {
        System.out.print("Entered function 1");
        String firstNameStr = firstName.getText();
        String lastNameStr = lastName.getText();
        String birthDateStr = birthdate.getValue().toString();
        String emailStr = email.getText();
        String passwordStr = password.getText();
        int carpenterInt = carpenter;
        int janitorInt = janitor;
        int cleanerInt = cleaner;
        int waiterInt = waiter;
        int chefInt = chef;
        int bartenderInt = bartender;
        int storeInt = store;
        int retailInt = retail;
        int pedaInt = peda;
        String locationStr = location.getValue().toString();
        int age = calcAge(birthDateStr);
        double rating = 0.0;

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            String sqlString = ("INSERT INTO Sellers(firstName, lastName, birthday, age, email, password, " +
                    "qualiCarpenter, qualiJanitor, qualiCleaner, qualiWaiter," +
                    "qualiChef, qualiBartender, qualiStore, qualiRetail, qualiPeda, location, rating) " +
                    "VALUES ('"+firstNameStr+"', '"+lastNameStr+"', '"+birthDateStr+"', '"+age+"', '"+emailStr+"', " +
                    "'"+passwordStr+"', '"+carpenterInt+"', '"+janitorInt+"', '"+cleanerInt+"', '"+waiterInt+"'," +
                    "'"+chefInt+"', '"+bartenderInt+"', '"+storeInt+"', '"+retailInt+"', '"+pedaInt+"'," +
                    "'"+locationStr+"', '"+rating+"')");

            stmt.executeUpdate(sqlString);
            System.out.print("Controller.Seller saved");
        }
        catch (Exception e)
        {

        }
    }

    //This method takes the birthdate String and calculates and returns the age
    public static int calcAge(String birthdate)
    {
        //We need to get the day, month and birthyear from the string and cast them to an int
        int birthday = Integer.parseInt(birthdate.substring(8,10));
        int birthmonth = Integer.parseInt(birthdate.substring(5,7));
        int birthyear = Integer.parseInt(birthdate.substring(0,4));

        Calendar birthinfo = new GregorianCalendar(birthyear, birthmonth, birthday);
        Calendar now = new GregorianCalendar();

        int age = now.get(Calendar.YEAR) - birthinfo.get(Calendar.YEAR);

        return age;
    }



    public static ResultSet getUserInformations()
    {
        String email = LoginVerifier.getEmail();
        ResultSet rs = null;
        try
        {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT firstName, lastName, age, birthday, email, rating, location, " +
                    "qualiCarpenter, qualiJanitor, qualiCleaner, qualiWaiter, qualiChef, " +
                    "qualiBartender, qualiStore, qualiRetail, qualiPeda FROM Sellers WHERE email = '"+email+"' ";
            rs = conn.createStatement().executeQuery(sqlString);
        }
        catch (Exception e)
        {

        }

        return rs;
    }


    public static ResultSet getUserInformationForTable()
    {
        ResultSet rs = null;
        try
        {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT firstName, lastName, email, birthday, age, location, qualiCarpenter, " +
                    "qualiJanitor, qualiCleaner, qualiWaiter, qualiChef," +
                    "qualiBartender, qualiStore, qualiRetail, qualiPeda, rating FROM Sellers";
            rs = conn.createStatement().executeQuery(sqlString);
        }
        catch (Exception e)
        {

        }
        return rs;
    }

}
