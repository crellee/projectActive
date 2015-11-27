package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * Created by christianhasselstrom on 27/11/2015.
 */
public class DBHandlerTask
{
    public static void saveTask(TextField jobDescription, ComboBox location, ComboBox requiredQualification, TextField salary,
                                DatePicker fromDate, DatePicker toDate, TextField numberOfHours, TextField cellNumber)
    {
        String jobDescriptionStr = jobDescription.getText();
        String locationStr = location.getValue().toString();
        String requiredQualificationStr = requiredQualification.getValue().toString();
        String salaryStr = salary.getText();
        String fromDateStr = fromDate.getValue().toString();
        String toDateStr = toDate.getValue().toString();
        String numberOfHoursStr = numberOfHours.getText();
        String cellNumberStr = cellNumber.getText();

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            String sqlStrings = ("INSERT INTO Tasks(jobDescription, location, requiredQuali, salary, " +
                    "fromDate, toDate, numberOfHours, cellNumber) " +
                    "VALUES ('"+jobDescriptionStr+"', '"+locationStr+"', '"+requiredQualificationStr+"', '"+salaryStr+"', " +
                    "'"+fromDateStr+"', '"+toDateStr+"','"+numberOfHoursStr+"' , '"+cellNumberStr+"')");

            stmt.executeUpdate(sqlStrings);

            /*

                        sqlString = "CREATE TABLE IF NOT EXISTS Tasks" +
                    "(jobDescription VARCHAR(20) NOT NULL, " +
                    "location VARCHAR(30) NOT NULL," +
                    "requiredQuali VARCHAR(30) NOT NULL," +
                    "salary VARCHAR(30) NOT NULL," +
                    "fromDate VARCHAR(30) NOT NULL," +
                    "toDate VARCHAR(4) NOT NULL," +
                    "numberOfHours VARCHAR(20) NOT NULL," +
                    "cellNumber VARCHAR(20) NOT NULL," +
                    "PRIMARY KEY (jobDescription))";

             */

        }
        catch (Exception e)
        {

        }

    }
}
