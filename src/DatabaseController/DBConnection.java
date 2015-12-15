package DatabaseController;

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
    final static String user = "sql499918";
    final static String pass = "issh1FmltI";
    final static String db = "sql499918";
    final static String url = "jdbc:mysql://sql4.freesqldatabase.com/";


    // This method connects to the DatabaseController using the attributes above.
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
