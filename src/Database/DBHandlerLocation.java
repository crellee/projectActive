package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;

/**
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
}
