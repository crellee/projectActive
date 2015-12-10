package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;

/* This class has a method which fills up the Locations table in the database
 * All values are inserted from start of program, because we want it to have some standard locations
 * Created by roije on 27/11/2015.
 */
public class DBHandlerLocation
{

    public static void fillLocationTable()
    {
        try
        {
            String sqlString;
            System.out.println("Entered");
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            sqlString = ("INSERT INTO Cities(postNo, city)" +
                    "VALUES ('2300', 'København S')");
            stmt.executeUpdate(sqlString);
            sqlString = ("INSERT INTO Cities(postNo, city)" +
                    "VALUES ('2000', 'Frederiksberg')");
            stmt.executeUpdate(sqlString);
            sqlString = ("INSERT INTO Cities(postNo, city)" +
                    "VALUES ('2100', 'København Ø')");
            stmt.executeUpdate(sqlString);
            sqlString = ("INSERT INTO Cities(postNo, city)" +
                    "VALUES ('2500', 'Valby')");
            stmt.executeUpdate(sqlString);
            sqlString = ("INSERT INTO Cities(postNo, city)" +
                    "VALUES ('2450', 'København SV')");
            stmt.executeUpdate(sqlString);
            sqlString = ("INSERT INTO Cities(postNo, city)" +
                    "VALUES ('2400', 'København NV')");
            stmt.executeUpdate(sqlString);
            sqlString = ("INSERT INTO Cities(postNo, city)" +
                    "VALUES ('2200', 'København N')");
            stmt.executeUpdate(sqlString);
            sqlString = ("INSERT INTO Cities(postNo, city)" +
                    "VALUES ('5000', 'Odense C')");
            stmt.executeUpdate(sqlString);
            sqlString = ("INSERT INTO Cities(postNo, city)" +
                    "VALUES ('8000', 'Århus C')");
            stmt.executeUpdate(sqlString);
            sqlString = ("INSERT INTO Cities(postNo, city)" +
                    "VALUES ('9000', 'Aalborg')");
            stmt.executeUpdate(sqlString);
            sqlString = ("INSERT INTO Cities(postNo, city)" +
                    "VALUES ('9020', 'Eidi')");
            stmt.executeUpdate(sqlString);
            sqlString = ("INSERT INTO Cities(postNo, city)" +
                    "VALUES ('9109', 'Bevery Hills')");
            stmt.executeUpdate(sqlString);
        }
        catch (Exception e)
        {

        }
    }

    /*
    Selects all postNo from Cities. The method used for filling ComboBoxes when creating users, tasks and updating users
    Used in CreateBuyerWindow , CreateSellerWindow, CreateTaskWindow, EditbuyerProfile and EditSellerProfile classes.
     */
    public static ResultSet getPostNumbers()
    {
        ResultSet rs = null;
        try
        {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT postNo FROM Cities";
            rs = conn.createStatement().executeQuery(sqlString);
        }
        catch (Exception e)
        {

        }

        return rs;
    }

    /*
    This method takes a String as parameter, which is the value in a ComboBox field for postNumbers
    to set a textfield to the corresponding city in the database.
    */
    public static String setCity(String postNumber)
    {
        String city = null;
        ResultSet rs1;
        try
        {
            Connection conn1 = DBConnection.getConnection();
            String sqlString1 = "SELECT city FROM Cities WHERE postNo = '"+postNumber+"'";
            rs1 = conn1.createStatement().executeQuery(sqlString1);
            while (rs1.next())
            {
                city = rs1.getString("city");
            }
        }
        catch (Exception e)
        {

        }
        return city;
    }
}
