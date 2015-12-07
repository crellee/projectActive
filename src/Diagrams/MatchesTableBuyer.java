package Diagrams;

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
 * Created by christianhasselstrom on 07/12/2015.
 */
public class MatchesTableBuyer {
    public static TableView matchesTable() {
        TableView matchesTable = new TableView();

        matchesTable.setPrefWidth(400);
        TableColumn jobDescription = new TableColumn("Job Description");
        TableColumn firstName = new TableColumn("First Name");
        TableColumn lastName = new TableColumn("Last Name");
        TableColumn businessName = new TableColumn("Business Name");
        TableColumn emailCol = new TableColumn("Email");
        TableColumn ageCol = new TableColumn("Age");
        TableColumn locationCol = new TableColumn("Location");
        TableColumn cityCol = new TableColumn("City");
        TableColumn qualificationsCol = new TableColumn("Qualifications");
        TableColumn ratingCol = new TableColumn("Rating");

        jobDescription.setPrefWidth(150);
        firstName.setPrefWidth(120);
        lastName.setPrefWidth(120);
        businessName.setPrefWidth(150);
        emailCol.setPrefWidth(150);
        ageCol.setPrefWidth(50);
        locationCol.setPrefWidth(70);
        cityCol.setPrefWidth(80);
        qualificationsCol.setPrefWidth(150);
        ratingCol.setPrefWidth(50);

        matchesTable.getColumns().addAll(jobDescription, businessName, firstName, lastName, emailCol, ageCol,
                locationCol, cityCol, qualificationsCol, ratingCol);

        jobDescription.setCellValueFactory(new PropertyValueFactory<Task, String>("jobDescription"));
        businessName.setCellValueFactory(new PropertyValueFactory<Task, String>("businessName"));
        firstName.setCellValueFactory(new PropertyValueFactory<Seller, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Seller, String>("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("email"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Seller, Integer>("age"));
        locationCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("location"));
        cityCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("city"));
        qualificationsCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("qualifications"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<Seller, Double>("rating"));

        ObservableList<Seller> data = FXCollections.observableArrayList();
        try {
            ResultSet rs = DBHandlerTask.getMatchesInfoForBuyer();

            while (rs.next()) {
                Seller seller = new Seller();
                Task task = new Task();

                task.setJobDescription(rs.getString("jobDescription"));
                //task.setBusinessName(rs.getString("businessName"));
            }


        } catch (Exception e) {

        }
        return matchesTable;

    }
}
