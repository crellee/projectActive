package Database;

import Controller.LoginVerifier;
import Controller.Task;
import Diagrams.MatchesTableSeller;
import GUI.Login;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.text.DecimalFormat;

/* This class contains methods which have to do with a Task and the connection to the Tasks table in the database
 * Created by christianhasselstrom on 27/11/2015.
 */
public class DBHandlerTask {
    //This method takes paramameters from the GUI in the CreateTaskWindow and inserts into Tasks table in the database
    public static void saveTask(TextField jobDescription, ComboBox location, TextField city, ComboBox requiredQualification, TextField salary,
                                DatePicker fromDate, DatePicker toDate, TextField numOfDays, TextField numberOfHours, TextField cellNumber) {
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
        String sellerRequestStr = " ";
        String buyerAcceptStr = " ";

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            String sqlStrings = ("INSERT INTO Tasks(jobDescription, location, requiredQualification, salary, " +
                    "fromDate, toDate, numOfDays, numberOfHours, cellNumber, businessEmail, sellerRequest, buyerAccept) " +
                    "VALUES ('" + jobDescriptionStr + "', '" + locationStr + "', '" + requiredQualificationStr + "', '" + salaryStr + "', " +
                    "'" + fromDateStr + "', '" + toDateStr + "', '" + numOfDaysInt + "', '" + numberOfHoursInt + "' , '" + cellNumberInt + "', '" + email + "', '" + sellerRequestStr + "', '" + buyerAcceptStr + "'  )");

            stmt.executeUpdate(sqlStrings);


        } catch (Exception e) {

        }
    }

    public static ResultSet getTaskInformationsForTable() {
        ResultSet rs = null;
        try {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT jobDescription, businessEmail, location, city, requiredQualification, salary, fromDate," +
                    " toDate, numOfDays, numberOfHours, cellNumber FROM Tasks ";
            rs = conn.createStatement().executeQuery(sqlString);
        } catch (Exception e) {

        }

        return rs;
    }

    public static ResultSet getAllTaskInfoForTable() {
        ResultSet rs = null;
        try {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT t1.* , b1.rating, b1.businessName FROM vicarius.Tasks AS t1 INNER JOIN vicarius.Buyers as b1 " +
                    "ON t1.businessEmail = b1.businessEmail ";
            rs = conn.createStatement().executeQuery(sqlString);

        } catch (Exception e) {

        }
        return rs;
    }

    public static ResultSet getMatchesInfoForSeller() {
        ResultSet rs = null;
        String email = LoginVerifier.getEmail();
        try {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT t1.* , b1.rating, b1.businessName FROM vicarius.Tasks AS t1 INNER JOIN vicarius.Sellers as s1 INNER JOIN vicarius.Buyers as b1 " +
                    "ON s1.email = '" + email + "' " +
                    "AND t1.businessEmail = b1.businessEmail " +
                    "WHERE t1.requiredQualification = 'Chef' AND s1.qualiChef = 1 " +
                    "OR t1.requiredQualification = 'Carpenter' AND s1.qualiCarpenter = 1 " +
                    "OR t1.requiredQualification = 'Janitor' AND s1.qualiJanitor = 1 " +
                    "OR t1.requiredQualification = 'Store employee' AND s1.qualiStore = 1 " +
                    "OR t1.requiredQualification = 'Pedagogue' AND s1.qualiPeda = 1 " +
                    "OR t1.requiredQualification = 'Retail' AND s1.qualiRetail = 1 " +
                    "OR t1.requiredQualification = 'Bartender' AND s1.qualiBartender = 1 " +
                    "OR t1.requiredQualification = 'Cleaner' AND s1.qualiCleaner = 1 " +
                    "OR t1.requiredQualification = 'Waiter' AND s1.qualiWaiter = 1 ";
            rs = conn.createStatement().executeQuery(sqlString);

        } catch (Exception e) {

        }
        return rs;
    }

    public static ResultSet getMatchesInfoForBuyer() {
        ResultSet rs = null;
        String email = LoginVerifier.getEmail();
        try {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT s1.*, t1.jobDescription, b1.businessName, t1.requiredQualification, t1.sellerRequest FROM vicarius.Sellers AS s1 INNER JOIN vicarius.Tasks AS t1 INNER JOIN vicarius.Buyers AS b1 " +
                    "ON b1.businessEmail = '" + email + "' " +
                    "AND t1.businessEmail = b1.businessEmail " +
                    "WHERE t1.requiredQualification = 'Chef' AND s1.qualiChef = 1 " +
                    "OR t1.requiredQualification = 'Carpenter' AND s1.qualiCarpenter = 1 " +
                    "OR t1.requiredQualification = 'Janitor' AND s1.qualiJanitor = 1 " +
                    "OR t1.requiredQualification = 'Store employee' AND s1.qualiStore = 1 " +
                    "OR t1.requiredQualification = 'Pedagogue' AND s1.qualiPeda = 1 " +
                    "OR t1.requiredQualification = 'Retail' AND s1.qualiRetail = 1 " +
                    "OR t1.requiredQualification = 'Bartender' AND s1.qualiBartender = 1 " +
                    "OR t1.requiredQualification = 'Cleaner' AND s1.qualiCleaner = 1 " +
                    "OR t1.requiredQualification = 'Waiter' AND s1.qualiWaiter = 1 " +
                    "ORDER BY t1.jobDescription";
            rs = conn.createStatement().executeQuery(sqlString);
        } catch (Exception e) {

        }

        return rs;
    }

    public static void updateSetRequest(String description) {
        String email = LoginVerifier.getEmail();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();
            String sqlString = "UPDATE vicarius.Tasks t1 JOIN vicarius.Sellers s1 SET sellerRequest = '"+email+"' " +
                    "WHERE t1.jobDescription = '"+description+"' ";
            stmt.executeUpdate(sqlString);

        } catch (Exception e) {

        }

    }

    public static void updateSetAccept(String description) {
        String email = LoginVerifier.getEmail();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();
            String sqlString = "UPDATE vicarius.Tasks t1 JOIN vicarius.Buyers b1 SET buyerAccept = '"+email+"' " +
                    "WHERE t1.jobDescription = '"+description+"' ";
            stmt.executeUpdate(sqlString);

        } catch (Exception e) {

        }

    }

    public static void setNewBuyerRating(String businessName, ComboBox newRating)
    {
        double newRatingDouble = Double.parseDouble(newRating.getValue().toString());

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = (Statement) conn.createStatement();
            String sqlString = "UPDATE Buyers SET rating = (rating + '"+newRatingDouble+"') / numberOfRating, numberOfRating = numberOfRating + 1 " +
                    "WHERE businessName = '" + businessName + "' ";
            System.out.print("About to ex");
            stmt.executeUpdate(sqlString);
            System.out.print("Executed");
        } catch (Exception e) {

        }
    }


}