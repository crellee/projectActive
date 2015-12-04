package Database;

import Controller.LoginVerifier;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.ResultSet;

/* This class contains methods which have to do with a Task and the connection to the Tasks table in the database
 * Created by christianhasselstrom on 27/11/2015.
 */
public class DBHandlerTask
{
    //This method takes paramameters from the GUI in the CreateTaskWindow and inserts into Tasks table in the database
    public static void saveTask(TextField jobDescription, ComboBox location, TextField city, ComboBox requiredQualification, TextField salary,
                                DatePicker fromDate, DatePicker toDate, TextField numOfDays, TextField numberOfHours, TextField cellNumber)
    {
        String jobDescriptionStr = jobDescription.getText();
        String locationStr = location.getValue().toString();
        String cityStr = city.getText();
        String requiredQualificationStr = requiredQualification.getValue().toString();
        String salaryStr = salary.getText();
        String fromDateStr = fromDate.getValue().toString();
        String toDateStr = toDate.getValue().toString();
        String numberOfHoursStr = numberOfHours.getText();
        int numberOfHoursInt = Integer.parseInt(numberOfHoursStr);
        String cellNumberStr = cellNumber.getText();
        int cellNumberInt = Integer.parseInt(cellNumberStr);
        String numOfDaysStr = numOfDays.getText();
        int numOfDaysInt = Integer.parseInt(numOfDaysStr);
        String email = LoginVerifier.getEmail();

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            String sqlStrings = ("INSERT INTO Tasks(jobDescription, location, city, requiredQualification, salary, " +
                    "fromDate, toDate, numOfDays, numberOfHours, cellNumber, businessEmail) " +
                    "VALUES ('"+jobDescriptionStr+"', '"+locationStr+"', '"+cityStr+"', '"+requiredQualificationStr+"', '"+salaryStr+"', " +
                    "'"+fromDateStr+"', '"+toDateStr+"', '"+numOfDaysInt+"', '"+numberOfHoursInt+"' , '"+cellNumberInt+"', '"+email+"')");

            stmt.executeUpdate(sqlStrings);


        }
        catch (Exception e)
        {

        }
    }

    public static ResultSet getTaskInformationsForTable()
    {
        ResultSet rs = null;
        try
        {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT jobDescription, location, city, requiredQualification, salary, fromDate," +
                    " toDate, numOfDays, numberOfHours, cellNumber FROM Tasks ";
            rs = conn.createStatement().executeQuery(sqlString);
        }
        catch (Exception e)
        {

        }

        return rs;
    }

}
