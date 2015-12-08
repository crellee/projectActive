package GUI;

import Controller.Seller;
import Database.DBHandlerLocation;
import Database.DBHandlerSeller;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by christianhasselstrom on 07/12/2015.
 */
public class MyProfileSeller
{
    public static BorderPane myProfileWindow() {

        //GUI Seller
        BorderPane rootMyProfileSeller = new BorderPane();
        rootMyProfileSeller.setStyle("-fx-background-color: #bfeef4");

        //VBox and HBox
        HBox profilHBox = new HBox(10);                 // Center BorderPane
        profilHBox.setPadding(new Insets(20, 10, 10, 20));
        VBox profilVBox = new VBox(20);                  //Left BorderPane
        profilVBox.setPadding(new Insets(50, 0, 10, 30));
        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();
        VBox vboxButton = new VBox();
        vboxButton.setPadding(new Insets(400, 0, 0, 0));
        VBox vBoxCheckBox = new VBox(10);
        vBoxCheckBox.setPadding(new Insets(30,30,30,100));

        // Separator
        Separator separator = new Separator();
        InnerShadow innerShadow = new InnerShadow();
        separator.setEffect(innerShadow);
        separator.setOrientation(Orientation.VERTICAL);
        separator.setMaxHeight(550);
        separator.setPadding(new Insets(20, 10, 20, 10));

        //Labels, Buttons
        Button buttonUpdate = new Button("Edit profile");
        buttonUpdate.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        buttonUpdate.setTextFill(Color.WHITE);
        buttonUpdate.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)");
        buttonUpdate.setPrefWidth(125);
        buttonUpdate.setPrefHeight(25);
        buttonUpdate.setOnAction(e ->
        {
            EditSellerProfile.openWindow();
        });

        Label firstName = new Label();
        firstName.setFont(Font.font("Calibri", FontWeight.BOLD, 35));
        firstName.setPadding(new Insets(20, 0, 0, 0));
        Label lastName = new Label();
        lastName.setFont(Font.font("Calibri", FontWeight.BOLD, 35));
        lastName.setPadding(new Insets(20, 0, 0, 0));
        Label rating = new Label("");
        rating.setFont(Font.font("Calibri", FontWeight.BOLD, 35));
        rating.setPadding(new Insets(20, 0, 0, 0));
        Label ratingLabel = new Label("              RATING:   ");
        ratingLabel.setPadding(new Insets(27, 0, 0, 0));
        ratingLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 25));
        ratingLabel.setAlignment(Pos.CENTER);
        Label checkBoxLabel = new Label("My qualifications:");
        checkBoxLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 20));
        Label ageLabel = new Label();
        ageLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label ageLabelLabel = new Label("Age:");
        ageLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label birthLabel = new Label();
        birthLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label birthLabelLabel = new Label("Birthday:");
        birthLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label mailLabel = new Label();
        mailLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label mailLabelLabel = new Label("Email:");
        mailLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label cityLabel = new Label();
        cityLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label cityLabelLabel = new Label("City:");
        cityLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label locationLabel = new Label();
        locationLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label locationLabelLabel = new Label("Post No:");
        locationLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));

        //Picture
        Image img = new Image("http://www.fscspatriots.org/wp-content/uploads/2014/12/no_photo_available-male.jpg");
        ImageView imageview = new ImageView(img);
        imageview.setFitHeight(232.6);
        imageview.setFitWidth(172.5);

        //CheckBox
        CheckBox carpenterCheck = new CheckBox("Carpenter");
        carpenterCheck.setDisable(true);
        carpenterCheck.setStyle("-fx-opacity: 1");
        CheckBox janitorCheck = new CheckBox("Janitor");
        janitorCheck.setDisable(true);
        janitorCheck.setStyle("-fx-opacity: 1");
        CheckBox cleanerCheck = new CheckBox("Cleaner");
        cleanerCheck.setDisable(true);
        cleanerCheck.setStyle("-fx-opacity: 1");
        CheckBox waiterCheck = new CheckBox("Waiter");
        waiterCheck.setDisable(true);
        waiterCheck.setStyle("-fx-opacity: 1");
        CheckBox chefCheck = new CheckBox("Chef");
        chefCheck.setDisable(true);
        chefCheck.setStyle("-fx-opacity: 1");
        CheckBox bartenderCheck = new CheckBox("Bartender");
        bartenderCheck.setDisable(true);
        bartenderCheck.setStyle("-fx-opacity: 1");
        CheckBox storeCheck = new CheckBox("Store employee");
        storeCheck.setDisable(true);
        storeCheck.setStyle("-fx-opacity: 1");
        CheckBox retailCheck = new CheckBox("Retail");
        retailCheck.setDisable(true);
        retailCheck.setStyle("-fx-opacity: 1");
        CheckBox pedagogueCheck = new CheckBox("Pedagogue");
        pedagogueCheck.setDisable(true);
        pedagogueCheck.setStyle("-fx-opacity: 1");

        //Tilføjelser til HBox, VBox og Borderpane
        ///////////////////////////////////////////
        vBox1.getChildren().addAll(firstName, mailLabelLabel, ageLabelLabel, birthLabelLabel, cityLabelLabel,
                locationLabelLabel);
        vBox2.getChildren().addAll(lastName, mailLabel, ageLabel, birthLabel, cityLabel, locationLabel);
        vBoxCheckBox.getChildren().addAll(checkBoxLabel,carpenterCheck,janitorCheck, cleanerCheck,waiterCheck,chefCheck,
                bartenderCheck, storeCheck,retailCheck,pedagogueCheck);
        profilVBox.getChildren().addAll(imageview, buttonUpdate);
        profilHBox.getChildren().addAll(separator, vBox1, vBox2, ratingLabel, rating, vBoxCheckBox);

        rootMyProfileSeller.setCenter(profilHBox);
        rootMyProfileSeller.setLeft(profilVBox);

        ResultSet rs = DBHandlerSeller.getUserInformations();
        try {
            while (rs.next()) {
                Seller seller = new Seller();
                seller.setFirstName(rs.getString("firstName"));
                seller.setLastName(rs.getString("lastName"));
                seller.setAge(rs.getInt("age"));
                seller.setBirthday(rs.getString("birthday"));
                seller.setEmail(rs.getString("email"));
                seller.setRating(rs.getDouble("rating"));
                seller.setLocation(rs.getString("location"));
                seller.setQualiCarpenter(rs.getInt("qualiCarpenter"));
                seller.setQualiJanitor(rs.getInt("qualiJanitor"));
                seller.setQualiCleaner(rs.getInt("qualiCleaner"));
                seller.setQualiWaiter(rs.getInt("qualiWaiter"));
                seller.setQualiChef(rs.getInt("qualiChef"));
                seller.setQualiBartender(rs.getInt("qualiBartender"));
                seller.setQualiStore(rs.getInt("qualiStore"));
                seller.setQualiRetail(rs.getInt("qualiRetail"));
                seller.setQualiPeda(rs.getInt("qualiPeda"));

                firstName.setText(seller.getFirstName());
                lastName.setText(seller.getLastName());
                ageLabel.setText(Integer.toString(seller.getAge()));
                birthLabel.setText(seller.getBirthday());
                mailLabel.setText(seller.getEmail());
                rating.setText(Double.toString(seller.getRating()));
                cityLabel.setText(seller.getCity());
                locationLabel.setText(seller.getLocation());
                cityLabel.setText(DBHandlerLocation.setCity(locationLabel.getText()));

                if(seller.getQualiCarpenter() == 1)
                {
                    carpenterCheck.setSelected(true);
                }

                if(seller.getQualiJanitor() == 1)
                {
                    janitorCheck.setSelected(true);
                }

                if(seller.getQualiCleaner() == 1)
                {
                    cleanerCheck.setSelected(true);
                }

                if(seller.getQualiWaiter() == 1)
                {
                    waiterCheck.setSelected(true);
                }

                if(seller.getQualiChef() == 1)
                {
                    chefCheck.setSelected(true);
                }

                if(seller.getQualiBartender() == 1)
                {
                    bartenderCheck.setSelected(true);
                }

                if(seller.getQualiStore() == 1)
                {
                    storeCheck.setSelected(true);
                }

                if(seller.getQualiRetail() == 1)
                {
                    retailCheck.setSelected(true);
                }

                if(seller.getQualiPeda() == 1)
                {
                    pedagogueCheck.setSelected(true);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rootMyProfileSeller;
    }
}