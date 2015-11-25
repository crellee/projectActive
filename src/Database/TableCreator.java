package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.SQLException;

/**
 * Created by roije on 25/11/2015.
 */
public class TableCreator
{
    public static void createSeller()
    {
        String sqlString;
        Statement stmt;

        try
        {
            Connection conn = DBConnection.getConnection();
            stmt = (Statement) conn.createStatement();

            sqlString = "CREATE TABLE IF NOT EXISTS Sellers" +
                    "(firstName VARCHAR(20) NOT NULL, " + //Variable lenght, max lenght 20. Range: 0-20
                    "lastName VARCHAR(30) NOT NULL," +  //Variable lenght, max lenght 30. Range: 0-30
                    "birthday VARCHAR(10) NOT NULL," +
                    "age INT(2) NOT NULL," + //Range 0-99
                    "email VARCHAR(30) NOT NULL," + //Variable lenght, max lenght 30. Range: 0-30
                    "password VARCHAR(30) NOT NULL," +
                    "qualification VARCHAR(15) NOT NULL," + //Variable lenght, max lenght 30. Range: 0-30
                    "location VARCHAR(25) NOT NULL," +
                    "rating DOUBLE(3,2) DEFAULT NULL," +
                    "city VARCHAR(21) NOT NULL," +
                    "PRIMARY KEY (email))";

            stmt.executeUpdate(sqlString);

        }
        catch (Exception e)
        {

        }
    }

    public static void createBuyer()
    {
        String sqlString;
        Statement stmt;

        try
        {
            Connection conn = DBConnection.getConnection();
            stmt = (Statement) conn.createStatement();

            sqlString = "CREATE TABLE IF NOT EXISTS Buyers" +
                        "(firstName VARCHAR(20) NOT NULL, " +
                        "lastName VARCHAR(30) NOT NULL," +
                        "businessName VARCHAR(30) NOT NULL," +
                        "businessEmail VARCHAR(30) NOT NULL," +
                        "password VARCHAR(30) NOT NULL," +
                        "location VARCHAR(25) NOT NULL," +
                        "city VARCHAR(21) NOT NULL," +
                        "cvr VARCHAR(20) NOT NULL," +
                        "PRIMARY KEY (cvr))";

            stmt.executeUpdate(sqlString);
        }
        catch (Exception e)
        {

        }
    }

}
