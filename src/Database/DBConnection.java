package Database;

import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 * Created by roije on 23/11/2015.
 */
/*
 * This class has a getConnection which return a Connection method,
 * which we use everytime we want to connect to the database
 */


public class DBConnection
{

    // Username, password, schema name and path to database
    final static String user = "vicar";
    final static String pass = "123kaffe";
    final static String db = "vicarius";
    final static String url = "jdbc:mysql://db4free.net/";

    // This method connects to the Database using the attributes above.
    public static Connection getConnection()
    {
        Connection conn;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url + db, user, pass);
            return conn;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
