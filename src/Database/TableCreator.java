package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.SQLException;

/**
 * Created by roije on 25/11/2015.
 */
public class TableCreator
{

    public static void createCitiesTable()
    {
        String sqlString;
        Statement stmt;

        try
        {
            Connection conn = DBConnection.getConnection();
            stmt = (Statement) conn.createStatement();


            sqlString = "DROP TABLE IF EXISTS Cities ";
            stmt.executeUpdate(sqlString);

            sqlString = "CREATE TABLE IF NOT EXISTS Cities" +
                    "(postNo VARCHAR(4) NOT NULL," +
                    "city VARCHAR(20) NOT NULL," +
                    "PRIMARY KEY (postNo))";

            stmt.executeUpdate(sqlString);

            DBHandlerLocation.fillLocationTable();
        }
        catch (Exception e)
        {

        }
    }

    public static void createSellerTable()
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
                    "qualiCarpenter TINYINT(1) NOT NULL," +
                    "qualiJanitor TINYINT(1) NOT NULL," +
                    "qualiCleaner TINYINT(1) NOT NULL," +
                    "qualiWaiter TINYINT(1) NOT NULL," +
                    "qualiChef TINYINT(1) NOT NULL," +
                    "qualiBartender TINYINT(1) NOT NULL," +
                    "qualiStore TINYINT(1) NOT NULL," +
                    "qualiRetail TINYINT(1) NOT NULL," +
                    "qualiPeda TINYINT(1) NOT NULL," + //Variable lenght, max lenght 30. Range: 0-30
                    "location VARCHAR(4) NOT NULL," +
                    "rating DOUBLE(3,2) DEFAULT NULL," +
                    "FOREIGN KEY (location) REFERENCES Cities(postNo)," +
                    "PRIMARY KEY (email))";

            stmt.executeUpdate(sqlString);

        }
        catch (Exception e)
        {

        }
    }


    public static void createBuyerTable()
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
                        "location VARCHAR(4) NOT NULL," +
                        "cvr VARCHAR(20) NOT NULL," +
                        "FOREIGN KEY (location) REFERENCES Cities(postNo)," +
                        "PRIMARY KEY (businessEmail))";

            stmt.executeUpdate(sqlString);
        }
        catch (Exception e)
        {

        }
    }



}
