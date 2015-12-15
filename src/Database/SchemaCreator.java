
package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;

/* Class for creating a schema.
 * Created by roije on 25/11/2015.
 */

public class SchemaCreator
{
    //Database URL
    final static String DB_URL = "jdbc:mysql://sql4.freesqldatabase.com/";

    //  Database credentials
    final static String USER = "sql499918";
    final static String PASS = "issh1FmltI";

    public static void create()
    {
        Connection conn;
        Statement stmt;
        try
        {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating database...");
            stmt = (Statement) conn.createStatement();

            String sql = "CREATE DATABASE IF NOT EXISTS sql499918";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
            }
            catch (Exception se)
            {

            }
        }
}

