package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Created by roije on 25/11/2015.
 */
public class TableCreator
{
    public static void create()
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
                    "birthday DATE NOT NULL," +
                    "age TINYINT(2) NOT NULL," + //Range 0-99
                    "email VARCHAR(30) NOT NULL," + //Variable lenght, max lenght 30. Range: 0-30
                    "password VARCHAR(30) NOT NULL," + //Variable lenght, max lenght 30. Range: 0-30
                    "location VARCHAR(25) NOT NULL," +
                    "rating FLOAT(3,2) DEFAULT NULL," +
                    "PRIMARY KEY (email))";
            stmt.executeUpdate(sqlString);

            /*
            sqlString = "CREATE TABLE IF NOT EXISTS Dentists" +
                    "(dentistNo CHAR(5) NOT NULL, " +
                    "dentistName VARCHAR(35), " +
                    "isActive BIT(1) NOT NULL DEFAULT 1," +
                    "PRIMARY KEY (dentistNo))";
            stmt.executeUpdate(sqlString);
            */

        }
        catch (Exception e)
        {

        }
    }

}
