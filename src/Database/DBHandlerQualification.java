package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;

/* This class has a method which fills up the Qualifications table in the database
 * All values are inserted from start of program, because we want it to have some standard qualifications
 * Created by roije on 30/11/2015.
 */
public class DBHandlerQualification
{
    public static void  fillQualificationTable()
    {
        try
        {
            String sqlString;
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            sqlString = "INSERT INTO Qualifications(qualificationId, qualificationName) VALUES (1, 'Carpenter')";
            stmt.executeUpdate(sqlString);
            sqlString = "INSERT INTO Qualifications(qualificationId, qualificationName) VALUES (2, 'Pedagogue')";
            stmt.executeUpdate(sqlString);
            sqlString = "INSERT INTO Qualifications(qualificationId, qualificationName) VALUES (3, 'Store employee')";
            stmt.executeUpdate(sqlString);
            sqlString = "INSERT INTO Qualifications(qualificationId, qualificationName) VALUES (4, 'Janitor')";
            stmt.executeUpdate(sqlString);
            sqlString = "INSERT INTO Qualifications(qualificationId, qualificationName) VALUES (5, 'Chef')";
            stmt.executeUpdate(sqlString);
            sqlString = "INSERT INTO Qualifications(qualificationId, qualificationName) VALUES (6, 'Retail')";
            stmt.executeUpdate(sqlString);
            sqlString = "INSERT INTO Qualifications(qualificationId, qualificationName) VALUES (7, 'Cleaner')";
            stmt.executeUpdate(sqlString);
            sqlString = "INSERT INTO Qualifications(qualificationId, qualificationName) VALUES (8, 'Bartender')";
            stmt.executeUpdate(sqlString);
            sqlString = "INSERT INTO Qualifications(qualificationId, qualificationName) VALUES (9, 'Waiter')";
            stmt.executeUpdate(sqlString);

        } catch (Exception e)
        {

        }
    }

    /*
    This method returns a ResultSet consisting of Qualifications names in the database
    It is in CreateTaskWindow class, when a Buyer creates a task.
    The resultset is being used for populating a ComboBox
     */
    public static ResultSet getQualificationName()
    {
        ResultSet rs = null;
        try
        {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT qualificationName FROM Qualifications";
            rs = conn.createStatement().executeQuery(sqlString);
        }
        catch (Exception e)
        {

        }

        return rs;
    }
}
