package Diagrams;

import Model.Seller;
import Model.Task;
import DatabaseController.DBHandlerLocation;
import DatabaseController.DBHandlerTask;
import GUI.HomeScreenBuyer;
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
        TableColumn emailCol = new TableColumn("Email");
        TableColumn ageCol = new TableColumn("Age");
        TableColumn locationCol = new TableColumn("Location");
        TableColumn cityCol = new TableColumn("City");
        TableColumn qualificationsCol = new TableColumn("Qualifications");
        TableColumn ratingCol = new TableColumn("Rating");
        TableColumn isRequested = new TableColumn("Requested");

        //Get the selected item in tableview
        matchesTable.setRowFactory(tv -> {
            TableRow<Seller> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Seller rowData = row.getItem();

                    try
                    {
                        if(rowData.getSellerRequestStr().equals("Yes"))
                        {
                            HomeScreenBuyer.alertWindow(rowData.getJobDescription());

                        }
                        else if(rowData.getSellerRequestStr().equals("Rate seller now"))
                        {
                            HomeScreenBuyer.ratingWindow(rowData.getEmail(), rowData.getJobDescription());
                        }


                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }

                }
            });
            return row;
        });


        jobDescription.setPrefWidth(150);
        firstName.setPrefWidth(120);
        lastName.setPrefWidth(120);
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
                seller.setFirstName(rs.getString("firstName"));
                seller.setAge(rs.getInt("age"));
                seller.setLastName(rs.getString("lastName"));
                seller.setEmail(rs.getString("email"));
                seller.setLocation(rs.getString("location"));
                seller.setCity(DBHandlerLocation.setCity(rs.getString("location")));
                seller.setQualifications(rs.getString("requiredQualification"));
                seller.setRating(rs.getDouble("rating"));

                task.setSellerRated(rs.getInt("sellerRated"));
                task.setBuyerRated(rs.getInt("buyerRated"));
                task.setGetSellerRequest(rs.getString("sellerRequest"));
                if(task.getGetSellerRequest().equals(seller.getEmail()) && task.getBuyerRated() == 0 && task.getSellerRated() == 0 )
                {
                    seller.setSellerRequestStr("Yes");
                }
                else if(task.getGetSellerRequest().equals(seller.getEmail()) && task.getBuyerRated() == 1 && task.getSellerRated() == 1)
                {
                    seller.setSellerRequestStr("Rated");
                }
                else if(task.getGetSellerRequest().equals(seller.getEmail()) && task.getSellerRated() == 1)
                {
                    seller.setSellerRequestStr("Rate seller now");
                }
                else
                {
                    seller.setSellerRequestStr("No");
                }

                data.add(seller);
            }

            matchesTable.setItems(data);


        } catch (Exception e) {

        }

        return matchesTable;

    }
}
