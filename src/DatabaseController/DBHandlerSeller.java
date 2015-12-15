package DatabaseController;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/** This class contains methods to handle a Model.Seller and the connection to the Sellers table in the database
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
        int numberOfRating = 0;
        double totalRating = 0.0;

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            String sqlString = ("INSERT INTO Sellers(firstName, lastName, birthday, age, email, password, " +
                    "qualiCarpenter, qualiJanitor, qualiCleaner, qualiWaiter," +
                    "qualiChef, qualiBartender, qualiStore, qualiRetail, qualiPeda, location, rating, numberOfRating, " +
                    "totalRating) " +
                    "VALUES ('"+firstNameStr+"', '"+lastNameStr+"', '"+birthDateStr+"', '"+age+"', '"+emailStr+"', " +
                    "'"+passwordStr+"', '"+carpenterInt+"', '"+janitorInt+"', '"+cleanerInt+"', '"+waiterInt+"'," +
                    "'"+chefInt+"', '"+bartenderInt+"', '"+storeInt+"', '"+retailInt+"', '"+pedaInt+"'," +
                    "'"+locationStr+"', '"+rating+"', '"+numberOfRating+"', '"+totalRating+"' )");

            stmt.executeUpdate(sqlString);
        }
        catch (Exception e)
        {

        }
    }

    public static void updateSellerProfile(TextField email, TextField firstName, TextField lastName, DatePicker birthdate,
                                  PasswordField password, ComboBox location,int carpenter, int janitor,
                                  int cleaner, int waiter, int chef,
                                  int bartender, int store, int retail,
                                  int peda)
    {
        String emailStr = email.getText();
        String firstNameStr = firstName.getText();
        String lastNameStr = lastName.getText();
        String birthDateStr = birthdate.getValue().toString();
        String passwordStr = password.getText();
        String locationStr = location.getValue().toString();
        System.out.print(locationStr);
        int age = calcAge(birthDateStr);
        System.out.print(age);

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            String sqlString = "UPDATE Sellers SET firstName='"+firstNameStr+"', lastName='"+lastNameStr+"'," +
                    "birthday='"+birthDateStr+"', age = '"+age+"', password='"+passwordStr+"'," +
                    "qualiCarpenter='"+carpenter+"', qualiJanitor='"+janitor+"'," +
                    "qualiCleaner='"+cleaner+"', qualiWaiter='"+waiter+"'," +
                    "qualiChef='"+chef+"', qualiBartender='"+bartender+"'," +
                    "qualiStore='"+store+"', qualiRetail='"+retail+"'," +
                    "qualiPeda='"+peda+"', location = '"+locationStr+"' WHERE email = '"+emailStr+"'";

            stmt.executeUpdate(sqlString);
        }
        catch(SQLException e)
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

    /*
    This method is used for getting the necessary information for the user logging in.
    By using his email, which we get from LoginVerifier.getEmail(), we can use a WHERE statement to find
    the user in the database. This method is being galled in myProfileWindow() method in MyProfileSeller class
    */
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

    /*
    This method returns a ResultSet, which is used in BuyersTable class -> getBuyersTable() to populate
    a TableView
    */
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

    /*
    This method is used when editing a user of type Seller.
    It is used in openWindow() method in EditSellerClass.
     */
    public static ResultSet getUserInformationForEdit()
    {
        String email = LoginVerifier.getEmail();
        ResultSet rs = null;
        try
        {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT firstName, lastName, birthday, email, location, password,  " +
                    "qualiCarpenter, qualiJanitor, qualiCleaner, qualiWaiter, qualiChef, " +
                    "qualiBartender, qualiStore, qualiRetail, qualiPeda FROM Sellers WHERE email = '"+email+"'";
            rs = conn.createStatement().executeQuery(sqlString);
        }
        catch (Exception e)
        {

        }
        return rs;
    }

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
