package Diagrams;

import Model.Buyer;
import Model.TableViewCreator;
import DatabaseController.DBHandlerBuyer;
import DatabaseController.DBHandlerLocation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;

/**
 * Created by christianhasselstrom on 06/12/2015.
 */
public class BuyersTable implements TableViewCreator
{
   @Override
    public TableView getTable()
    {
        TableView<Buyer> buyersTable = new TableView();

        buyersTable.setPrefWidth(400);
        TableColumn buyerName = new TableColumn("Employee Name");
        TableColumn buyerLastName = new TableColumn("Employee Last Name");
        TableColumn businessName = new TableColumn("Business Name");
        TableColumn location = new TableColumn("Location");
        TableColumn city = new TableColumn("City");
        TableColumn rating = new TableColumn("Rating");
        TableColumn cvrNo = new TableColumn("CVR No");

        buyerName.setPrefWidth(150);
        buyerLastName.setPrefWidth(150);
        businessName.setPrefWidth(150);
        location.setPrefWidth(150);
        city.setPrefWidth(150);
        rating.setPrefWidth(50);
        cvrNo.setPrefWidth(100);

        buyersTable.getColumns().addAll(buyerName, buyerLastName, businessName, location, city, rating, cvrNo);

        buyerName.setCellValueFactory(new PropertyValueFactory<Buyer, String>("firstName"));
        buyerLastName.setCellValueFactory(new PropertyValueFactory<Buyer, String>("lastName"));
        businessName.setCellValueFactory(new PropertyValueFactory<Buyer, String>("businessName"));
        location.setCellValueFactory(new PropertyValueFactory<Buyer, String>("location"));
        city.setCellValueFactory(new PropertyValueFactory<Buyer, String>("city"));
        rating.setCellValueFactory(new PropertyValueFactory<Buyer, Double>("rating"));
        cvrNo.setCellValueFactory(new PropertyValueFactory<Buyer, Integer>("cvr"));

        ObservableList<Buyer> data = FXCollections.observableArrayList();

        try {
            ResultSet rs = DBHandlerBuyer.getUserInformationsForTable();

            while (rs.next()) {

                Buyer buyer = new Buyer();
                buyer.setFirstName(rs.getString("firstName"));
                buyer.setLastName(rs.getString("lastName"));
                buyer.setBusinessName(rs.getString("businessName"));
                buyer.setLocation(rs.getString("location"));
                buyer.setCity(DBHandlerLocation.setCity(rs.getString("location")));
                buyer.setRating(rs.getDouble("rating"));
                buyer.setCvr(rs.getInt("cvr"));
                data.add(buyer);
            }
            buyersTable.setItems(data);
        }
        catch (Exception e)
        {

        }
        return buyersTable;
    }
}
