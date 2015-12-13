package Diagrams;

import Controller.Seller;
import Controller.TableViewCreator;
import Database.DBHandlerLocation;
import Database.DBHandlerSeller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;

/**
 * Created by christianhasselstrom on 06/12/2015.
 */
public class SellersTable implements TableViewCreator
{

    public TableView getTable()
    {
        TableView<Seller> sellersTable = new TableView();
        sellersTable.setPrefWidth(400);
        TableColumn firstNameCol = new TableColumn("First name");
        TableColumn lastNameCol = new TableColumn("Last name");
        TableColumn birthdayCol = new TableColumn("Birthday");
        TableColumn emailCol = new TableColumn("Email");
        TableColumn ageCol = new TableColumn("Age");
        TableColumn locationCol = new TableColumn("Location");
        TableColumn cityCol = new TableColumn("City");
        TableColumn qualificationsCol = new TableColumn("Qualifications");
        TableColumn ratingCol = new TableColumn("Rating");

        firstNameCol.setPrefWidth(150);
        lastNameCol.setPrefWidth(150);
        birthdayCol.setPrefWidth(100);
        emailCol.setPrefWidth(170);
        ageCol.setPrefWidth(50);
        locationCol.setPrefWidth(90);
        cityCol.setPrefWidth(150);
        qualificationsCol.setPrefWidth(150);
        ratingCol.setPrefWidth(80);

        sellersTable.getColumns().addAll(firstNameCol, lastNameCol, emailCol,
                birthdayCol, ageCol, locationCol, cityCol, qualificationsCol, ratingCol);

        firstNameCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("lastName"));
        birthdayCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("birthday"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("email"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Seller, Integer>("age"));
        locationCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("location"));
        cityCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("city"));
        qualificationsCol.setCellValueFactory(new PropertyValueFactory<Seller, String>("qualifications"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<Seller, Double>("rating"));

        ObservableList<Seller> data = FXCollections.observableArrayList();
        try
        {
            ResultSet rs = DBHandlerSeller.getUserInformationForTable();

            while (rs.next())
            {
                Seller seller = new Seller();
                seller.setFirstName(rs.getString("firstName"));
                seller.setLastName(rs.getString("lastName"));
                seller.setEmail(rs.getString("email"));
                seller.setBirthday(rs.getString("birthday"));
                seller.setAge(rs.getInt("age"));
                seller.setLocation(rs.getString("location"));
                seller.setCity(DBHandlerLocation.setCity(rs.getString("location")));

                //Adding qualifications into an arraylist, and displaying list in a cell
                //ArrayList<String> qualificationsCellList = new ArrayList<>();
                seller.setQualiCarpenter(rs.getInt("qualiCarpenter"));
                if(seller.getQualiCarpenter() == 1)
                {
                    //qualificationsCellList.add("\nCarpenter");
                    seller.setQualifications("Carpenter");
                }
                seller.setQualiJanitor(rs.getInt("qualiJanitor"));
                if(seller.getQualiJanitor() == 1)
                {
                    //qualificationsCellList.add("\nJanitor");
                    seller.setQualifications("\nJanitor");
                }
                seller.setQualiCleaner(rs.getInt("qualiCleaner"));
                if(seller.getQualiCleaner() == 1)
                {
                    //qualificationsCellList.add("\nCleaner");
                    seller.setQualifications("\nCleaner");
                }
                seller.setQualiWaiter(rs.getInt("qualiWaiter"));
                if(seller.getQualiWaiter() == 1)
                {
                    //qualificationsCellList.add("\nWaiter");
                    seller.setQualifications("\nWaiter");
                }
                seller.setQualiChef(rs.getInt("qualiChef"));
                if(seller.getQualiChef() == 1)
                {
                    //qualificationsCellList.add("\nChef");
                    seller.setQualifications("\nChef");
                }
                seller.setQualiBartender(rs.getInt("qualiBartender"));
                if(seller.getQualiBartender() == 1)
                {
                    //qualificationsCellList.add("\nBartender");
                    seller.setQualifications("\nBartender");
                }

                seller.setQualiStore(rs.getInt("qualiStore"));
                if(seller.getQualiStore() == 1)
                {
                    //qualificationsCellList.add("\nStore employee");
                    seller.setQualifications("\nStore employee");
                }
                seller.setQualiRetail(rs.getInt("qualiRetail"));
                if(seller.getQualiRetail() == 1)
                {
                    //qualificationsCellList.add("\nRetail");
                    seller.setQualifications("\nRetail");
                }
                seller.setQualiPeda(rs.getInt("qualiPeda"));
                if(seller.getQualiPeda() == 1)
                {
                    //qualificationsCellList.add("\nPedagogue");
                    seller.setQualifications("\nPedagogue");
                }
                seller.setRating(rs.getDouble("rating"));


                data.add(seller);
            }
            sellersTable.setItems(data);
        }
        catch (Exception e)
        {

        }
        return sellersTable;
    }
}
