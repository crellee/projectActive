package Database;

import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 * Created by roije on 23/11/2015.
 */
/*
 * Opretter forbindelse til DB.
 */


public class DBConnection
{

    // Username, password, schema name and path to database
    final static String user = "sql497759";
    final static String pass = "cctwBdpC32";
    final static String db = "sql497759";
    final static String url = "jdbc:mysql://sql4.freemysqlhosting.net/";

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
