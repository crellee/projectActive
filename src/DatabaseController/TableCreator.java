package DatabaseController;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/* This class is for creating all the tables which we have in our schema.
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
                    "email VARCHAR(40) NOT NULL," + //Variable lenght, max lenght 30. Range: 0-30
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
                    "numberOfRating INT(4) NOT NULL," +
                    "totalRating INT(6) NOT NULL," +
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
                        "businessEmail VARCHAR(40) NOT NULL," +
                        "password VARCHAR(30) NOT NULL," +
                        "location VARCHAR(4) NOT NULL," +
                        "cvr INT(8) NOT NULL," +
                        "rating DOUBLE(3,2) DEFAULT NULL," +
                        "numberOfRating INT(4) NOT NULL," +
                        "totalRating INT(6) NOT NULL, " +
                        "FOREIGN KEY (location) REFERENCES Cities(postNo)," +
                        "PRIMARY KEY (businessEmail))";


            stmt.executeUpdate(sqlString);
        }
        catch (Exception e)
        {

        }
    }

    public static void createTaskTable()
    {
        String sqlString;
        Statement stmt;

        try
        {
            Connection conn = DBConnection.getConnection();
            stmt = (Statement) conn.createStatement();


            sqlString = "CREATE TABLE IF NOT EXISTS Tasks" +
                    "(jobDescription VARCHAR(20) NOT NULL, " +
                    "location VARCHAR(4) NOT NULL," +
                    "requiredQualification VARCHAR(30) NOT NULL," +
                    "salary VARCHAR(30) NOT NULL," +
                    "fromDate VARCHAR(10) NOT NULL," +
                    "toDate VARCHAR(10) NOT NULL," +
                    "numOfDays INT(3) NOT NULL," +
                    "numberOfHours INT(5) NOT NULL," +
                    "cellNumber INT(8) NOT NULL," +
                    "businessEmail VARCHAR(40) NOT NULL," +
                    "sellerRequest VARCHAR(40) NOT NULL," +
                    "buyerAccept VARCHAR(40) NOT NULL," +
                    "sellerRated TINYINT(1) NOT NULL," +
                    "buyerRated TINYINT(1) NOT NULL," +
                    "isActive TINYINT(1) NOT NULL, " +
                    "PRIMARY KEY (jobDescription))";


            stmt.executeUpdate(sqlString);
        }
        catch (Exception e)
        {

        }

    }

    public static void createQualificationTable()
    {
        String sqlString;
        Statement stmt;

        try
        {
            Connection conn = DBConnection.getConnection();
            stmt = (Statement) conn.createStatement();


            sqlString = "CREATE TABLE IF NOT EXISTS Qualifications" +
                    "(qualificationId TINYINT(2) NOT NULL," +
                    "qualificationName VARCHAR(30)," +
                    "PRIMARY KEY (qualificationId))";


            stmt.executeUpdate(sqlString);

            DBHandlerQualification.fillQualificationTable();
        }
        catch (Exception e)
        {

        }

    }

    /*
    public static void createRequestAcceptTable()
    {
        String sqlString;
        Statement stmt;

        try
        {
            Connection conn = DBConnection.getConnection();
            stmt = (Statement) conn.createStatement();

            sqlString = "CREATE TABLE IF NOT EXISTS Requests " +
                    "(description VARCHAR(30) NOT NULL, " +
                    "sellerEmail VARCHAR(30) NOT NULL, " +
                    "buyerEmail VARCHAR(30),  " +
                    "PRIMARY KEY(description, sellerEmail)) ";


            stmt.executeUpdate(sqlString);

            DBHandlerQualification.fillQualificationTable();
        }
        catch (Exception e)
        {

        }

    }
    */



}
