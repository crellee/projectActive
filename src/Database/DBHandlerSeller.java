package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.scene.control.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by roije on 25/11/2015.
 */
public class DBHandlerSeller
{
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
            System.out.print("Seller saved");
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
