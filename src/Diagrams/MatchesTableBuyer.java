package Diagrams;

import Controller.LoginVerifier;
import Controller.Seller;
import Controller.Task;
import Database.DBHandlerLocation;
import Database.DBHandlerSeller;
import Database.DBHandlerTask;
import GUI.HomeScreenBuyer;
import GUI.HomeScreenSeller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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
        //TableColumn businessName = new TableColumn("Business Name");
        TableColumn emailCol = new TableColumn("Email");
        TableColumn ageCol = new TableColumn("Age");
        TableColumn locationCol = new TableColumn("Location");
        TableColumn cityCol = new TableColumn("City");
        TableColumn qualificationsCol = new TableColumn("Qualifications");
        TableColumn ratingCol = new TableColumn("Rating");
        TableColumn isRequested = new TableColumn("Requested");

        matchesTable.setRowFactory(tv -> {
            TableRow<Seller> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Seller rowData = row.getItem();
                    if(rowData.getSellerRequestStr().equals("Yes")) {
                        try {
                            HomeScreenBuyer.alertWindow(rowData.getJobDescription());

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }

                }
            });
            return row;
        });


        jobDescription.setPrefWidth(150);
        firstName.setPrefWidth(120);
        lastName.setPrefWidth(120);
        //businessName.setPrefWidth(150);
        emailCol.setPrefWidth(150);
        ageCol.setPrefWidth(50);
        locationCol.setPrefWidth(70);
        cityCol.setPrefWidth(80);
        qualificationsCol.setPrefWidth(150);
        ratingCol.setPrefWidth(50);
        isRequested.setPrefWidth(80);

        matchesTable.getColumns().addAll(jobDescription, firstName, lastName, emailCol, ageCol,
                locationCol, cityCol, qualificationsCol, ratingCol, isRequested);

        jobDescription.setCellValueFactory(new PropertyValueFactory<Seller, String>("jobDescription"));
        //businessName.setCellValueFactory(new PropertyValueFactory<Seller, String>("businessName"));
        firstName.setCellValueFactory(new PropertyValueFactory<Seller, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Seller, String>("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("email"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Seller, Integer>("age"));
        locationCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("location"));
        cityCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("city"));
        qualificationsCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("qualifications"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<Seller, Double>("rating"));
        isRequested.setCellValueFactory(new PropertyValueFactory<Seller, String>("sellerRequestStr"));

        ObservableList<Seller> data = FXCollections.observableArrayList();

        try {
            ResultSet rs = DBHandlerTask.getMatchesInfoForBuyer();


            while (rs.next()) {
                Seller seller = new Seller();
                Task task = new Task();

                seller.setJobDescription(rs.getString("jobDescription"));
                //seller.setBusinessName(rs.getString("businessName"));
                seller.setFirstName(rs.getString("firstName"));
                seller.setAge(rs.getInt("age"));
                seller.setLastName(rs.getString("lastName"));
                seller.setEmail(rs.getString("email"));
                seller.setLocation(rs.getString("location"));
                seller.setCity(DBHandlerLocation.setCity(rs.getString("location")));
                seller.setQualifications(rs.getString("requiredQualification"));
                seller.setRating(rs.getDouble("rating"));


                task.setGetSellerRequest(rs.getString("sellerRequest"));
                if(task.getGetSellerRequest().equals(seller.getEmail()))
                {
                    seller.setSellerRequestStr("Yes");
                }
                else
                {
                    seller.setSellerRequestStr("No");
                }


                if(seller.getSellerRequestStr().equals("Yes"))
                {

                }

                data.add(seller);
            }

            matchesTable.setItems(data);


        } catch (Exception e) {

        }

        return matchesTable;

    }
}
