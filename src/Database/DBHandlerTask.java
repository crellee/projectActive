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
    public static void saveTask(TextField jobDescription, ComboBox location, TextField city, ComboBox requiredQualification, TextField salary,
                                DatePicker fromDate, DatePicker toDate, TextField numberOfHours, TextField cellNumber)
    {
        String jobDescriptionStr = jobDescription.getText();
        String locationStr = location.getValue().toString();
        String cityStr = city.getText();
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

            String sqlStrings = ("INSERT INTO Tasks(jobDescription, location, city, requiredQualification, salary, " +
                    "fromDate, toDate, numberOfHours, cellNumber) " +
                    "VALUES ('"+jobDescriptionStr+"', '"+locationStr+"', '"+cityStr+"', '"+requiredQualificationStr+"', '"+salaryStr+"', " +
                    "'"+fromDateStr+"', '"+toDateStr+"','"+numberOfHoursStr+"' , '"+cellNumberStr+"')");

            stmt.executeUpdate(sqlStrings);


        }
        catch (Exception e)
        {

        }

    }
}