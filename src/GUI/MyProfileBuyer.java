package GUI;

import Controller.Buyer;
import Database.DBHandlerBuyer;
import Database.DBHandlerLocation;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
public class MyProfileBuyer
{
    public static BorderPane myProfileWindow() {

        //GUI Seller
        BorderPane rootMyProfileBuyer = new BorderPane();
        rootMyProfileBuyer.setStyle("-fx-background-color: #bfeef4");

        //VBox and HBox
        HBox profilHBox = new HBox(10);                 // Center BorderPane
        profilHBox.setPadding(new Insets(20, 10, 10, 20));
        VBox profilVBox = new VBox(20);                  //Left BorderPane
        profilVBox.setPadding(new Insets(50, 0, 10, 30));
        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();
        VBox vboxButton = new VBox();
        vboxButton.setPadding(new Insets(400, 0, 0, 0));

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
            EditBuyerProfile.openWindow();
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
        Label businessNameLabel = new Label();
        businessNameLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label businessNameLabelLabel = new Label("Business Name:");
        businessNameLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label businessEmailLabel = new Label();
        businessEmailLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label businessEmailLabelLabel = new Label("Business Email:");
        businessEmailLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label postNoLabel = new Label();
        postNoLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label postNoLabelLabel = new Label("Post No:");
        postNoLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label cityLabel = new Label();
        cityLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label cityLabelLabel = new Label("City:");
        cityLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label cvrLabel = new Label();
        cvrLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label cvrLabelLabel = new Label("CVR No:");
        cvrLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));

        //Picture
        Image img = new Image("http://www.fscspatriots.org/wp-content/uploads/2014/12/no_photo_available-male.jpg");
        ImageView imageview = new ImageView(img);
        imageview.setFitHeight(232.6);
        imageview.setFitWidth(172.5);

        //Tilføjelser til HBox, VBox og Borderpane
        ///////////////////////////////////////////
        vBox1.getChildren().addAll(firstName, businessNameLabelLabel, businessEmailLabelLabel, postNoLabelLabel, cityLabelLabel,
                cvrLabelLabel);
        vBox2.getChildren().addAll(lastName, businessNameLabel, businessEmailLabel, postNoLabel, cityLabel, cvrLabel);
        //vboxButton.getChildren().add(null);
        profilVBox.getChildren().addAll(imageview, buttonUpdate);
        profilHBox.getChildren().addAll(separator, vBox1, vBox2, ratingLabel, rating, vboxButton);

        rootMyProfileBuyer.setCenter(profilHBox);
        rootMyProfileBuyer.setLeft(profilVBox);

        ResultSet rs = DBHandlerBuyer.getUserInformations();
        try {
            while (rs.next()) {
                Buyer buyer = new Buyer();

                buyer.setFirstName(rs.getString("firstName"));
                buyer.setLastName(rs.getString("lastName"));
                buyer.setBusinessName(rs.getString("businessName"));
                buyer.setBusinessEmail(rs.getString("businessEmail"));
                buyer.setLocation(rs.getString("location"));
                buyer.setCvr(rs.getInt("cvr"));
                buyer.setRating(rs.getDouble("rating"));

                firstName.setText(buyer.getFirstName());
                lastName.setText(buyer.getLastName());
                businessNameLabel.setText(buyer.getBusinessName());
                businessEmailLabel.setText(buyer.getBusinessEmail());
                postNoLabel.setText(buyer.getLocation());
                cityLabel.setText(DBHandlerLocation.setCity(postNoLabel.getText()));
                cvrLabel.setText(Integer.toString(buyer.getCvr()));
                rating.setText(Double.toString(buyer.getRating()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rootMyProfileBuyer;
    }
}
