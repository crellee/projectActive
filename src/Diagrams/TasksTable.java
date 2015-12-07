package Diagrams;

import Controller.Task;
import Database.DBHandlerLocation;
import Database.DBHandlerTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;

/**
 * Created by christianhasselstrom on 06/12/2015.
 */
public class TasksTable {

    public static TableView getTasksTable() {
        TableView tasksTable = new TableView();

        tasksTable.setPrefWidth(400);
        TableColumn jobDescription = new TableColumn("Job Description");
        TableColumn businessName = new TableColumn("Business Name");
        TableColumn location = new TableColumn("Location");
        TableColumn city = new TableColumn("City");
        TableColumn requiredQualification = new TableColumn("Qualification");
        TableColumn fromDate = new TableColumn("From Date");
        TableColumn toDate = new TableColumn("To Date");
        TableColumn numofDays = new TableColumn("Days");
        TableColumn numberOfHours = new TableColumn("Hours Total");
        TableColumn cellNumber = new TableColumn("Cell number");
        TableColumn rating = new TableColumn("Rating");
        TableColumn salary = new TableColumn("Salary");

        jobDescription.setPrefWidth(150);
        businessName.setPrefWidth(150);
        location.setPrefWidth(100);
        city.setPrefWidth(100);
        requiredQualification.setPrefWidth(100);
        fromDate.setPrefWidth(100);
        toDate.setPrefWidth(100);
        numofDays.setPrefWidth(50);
        numberOfHours.setPrefWidth(100);
        cellNumber.setPrefWidth(100);
        rating.setPrefWidth(50);
        salary.setPrefWidth(100);

        tasksTable.getColumns().addAll(jobDescription, businessName, location, city, requiredQualification,
                fromDate, toDate, numofDays, numberOfHours, cellNumber, rating, salary);

        jobDescription.setCellValueFactory(new PropertyValueFactory<Task, String>("jobDescription"));
        businessName.setCellValueFactory(new PropertyValueFactory<Task, String>("businessName"));
        location.setCellValueFactory(new PropertyValueFactory<Task, String>("location"));
        city.setCellValueFactory(new PropertyValueFactory<Task, String>("city"));
        requiredQualification.setCellValueFactory(new PropertyValueFactory<Task, String>("requiredQualification"));
        fromDate.setCellValueFactory(new PropertyValueFactory<Task, String>("fromDate"));
        toDate.setCellValueFactory(new PropertyValueFactory<Task, String>("toDate"));
        numofDays.setCellValueFactory(new PropertyValueFactory<Task, Integer>("numOfDays"));
        numberOfHours.setCellValueFactory(new PropertyValueFactory<Task, Integer>("numberOfHours"));
        cellNumber.setCellValueFactory(new PropertyValueFactory<Task, Integer>("cellNumber"));
        rating.setCellValueFactory(new PropertyValueFactory<Task, Double>("rating"));
        salary.setCellValueFactory(new PropertyValueFactory<Task, Integer>("salary"));


        ObservableList<Task> data2 = FXCollections.observableArrayList();
        try {
            ResultSet rs = DBHandlerTask.getAllTaskInfoForTable();
            while (rs.next())
            {

                Task task = new Task();

                task.setJobDescription(rs.getString("jobDescription"));
                task.setLocation(rs.getString("location"));
                task.setCity(DBHandlerLocation.setCity(rs.getString("location")));
                task.setRequiredQualification(rs.getString("requiredQualification"));
                task.setFromDate(rs.getString("fromDate"));
                task.setToDate(rs.getString("toDate"));
                task.setNumOfDays(rs.getInt("numOfDays"));
                task.setNumberOfHours(rs.getInt("numberOfHours"));
                task.setCellNumber(rs.getInt("cellNumber"));
                task.setSalary(rs.getString("salary"));
                task.setBusinessName(rs.getString("businessName"));
                task.setRating(rs.getDouble("rating"));

                data2.add(task);
            }
            tasksTable.setItems(data2);
        }

        catch(Exception e)
        {

        }


        return tasksTable;
    }
}
