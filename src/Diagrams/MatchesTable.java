package Diagrams;

import Controller.Buyer;
import Controller.LoginVerifier;
import Controller.Seller;
import Controller.Task;
import Database.DBHandlerSeller;
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
public class MatchesTable {

    public static TableView matchesTable() {
        TableView matchesTable = new TableView();

        matchesTable.setPrefWidth(400);
        TableColumn jobDescription = new TableColumn("Job description");
        TableColumn buyerDescription = new TableColumn("Controller.Buyer description");
        TableColumn location = new TableColumn("Location");
        TableColumn qualifications = new TableColumn("Qualification(s)");
        TableColumn rating = new TableColumn("Rating");
        TableColumn salary = new TableColumn("Salary");

        jobDescription.setPrefWidth(300);
        buyerDescription.setPrefWidth(200);
        location.setPrefWidth(150);
        qualifications.setPrefWidth(150);
        rating.setPrefWidth(50);
        salary.setPrefWidth(80);

        matchesTable.getColumns().addAll(jobDescription, buyerDescription, location, qualifications, rating, salary);

        qualifications.setCellValueFactory(new PropertyValueFactory<Task, String>("requiredQualification"));
        jobDescription.setCellValueFactory(new PropertyValueFactory<Task, String>("jobDescription"));
        rating.setCellValueFactory(new PropertyValueFactory<Task, Double>("rating"));


        ObservableList<Task> data = FXCollections.observableArrayList();
        try {
            ResultSet rs = DBHandlerTask.getMatchesInfoForSeller();

            while (rs.next()) {
                Task task = new Task();
                Seller seller = new Seller();

                //seller.setQualiChef(rs.getInt("qualiChef"));

                task.setRequiredQualification(rs.getString("requiredQualification"));
                task.setJobDescription(rs.getString("jobDescription"));
                task.setRating(rs.getDouble("rating"));



                data.add(task);
            }
            matchesTable.setItems(data);
        }
        catch (Exception e)
        {

        }
        return matchesTable;
    }
}
