package GUI;

import Model.Buyer;
import Model.Location;
import DatabaseController.DBHandlerBuyer;
import DatabaseController.DBHandlerLocation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by christianhasselstrom on 03/12/2015.
 */
public class EditBuyerProfile
{
    public static void openWindow()
    {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(#42C0FB, #236B8E) ");
        Stage window = new Stage();
        Scene scene = new Scene(root, 600, 600);
        window.setScene(scene);

        //Header label
        Label headLine = new Label("Edit Account");
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        headLine.setEffect(r);
        headLine.setTextFill(Color.GHOSTWHITE);
        headLine.setFont(Font.font("Verdana", FontWeight.BOLD, 30));


        //Add headline
        VBox topVBox = new VBox();
        topVBox.getChildren().addAll(headLine);
        topVBox.setPadding(new Insets(20));
        topVBox.setSpacing(24);

        root.setTop(topVBox);

        //Label fields
        Label firstNameLabel = new Label("First Name");
        firstNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label lastNameLabel = new Label("Last Name");
        lastNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label businessNameLabel = new Label("Business Name");
        businessNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label businessEmailLabel = new Label("Business Email");
        businessEmailLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label enterPasswordLabel = new Label("Enter Password");
        enterPasswordLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label confirmPasswordLabel = new Label("Confirm Password");
        confirmPasswordLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label locationLabel = new Label("Postal code: ");
        locationLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label cityLabel = new Label("City");
        cityLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label cvrNoLabel = new Label("Enter CVR-Number");
        cvrNoLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        Label fillInformationerrorLabel = new Label("Fill all text fields before editing profile");
        fillInformationerrorLabel.setTextFill(Color.RED);
        Label passwordNotSame = new Label("Passwords must be the same before editing profile");
        passwordNotSame.setTextFill(Color.RED);
        Label fillAllFields = new Label("Please fill ALL fields before editing profile");
        fillAllFields.setTextFill(Color.RED);
        Label cvrMax8 = new Label("Cvr must max be 8 characters and only numbers");
        cvrMax8.setTextFill(Color.RED);

        //Input fields
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField businessNameField = new TextField();
        TextField businessEmailField = new TextField();
        businessEmailField.setEditable(false);
        PasswordField enterPasswordField = new PasswordField();
        PasswordField confirmPasswordField = new PasswordField();
        TextField cityField = new TextField();
        cityField.setEditable(false);
        TextField cvrNoField = new TextField();

        ComboBox locationCombo = new ComboBox();
        locationCombo.setPrefWidth(200);
        //ResultSet rs which has the values the getPostNumbers method returns.
        //Look up DBHandlerLocation class to see getPostNumbers definition.
        ResultSet rs = DBHandlerLocation.getPostNumbers();
        //Observable list data containing String.
        ObservableList<String> data = FXCollections.observableArrayList();
        //Loop through ResultSet. Create Location object, call setPostNo (in Location class)
        //to set postNo to the value in postNo column in ResultSet. Add value to observable list: data.
        try
        {
            while (rs.next())
            {
                Location location = new Location();
                location.setPostNo(rs.getString("postNo"));
                data.add(location.getPostNo());
            }
        }
        catch (Exception e)
        {

        }
        //Add observable list data to locationsCombo
        locationCombo.getItems().addAll(data);

        locationCombo.setOnAction(e ->
        {
            String no = locationCombo.getValue().toString();
            cityField.setText(DBHandlerLocation.setCity(no));
        });

        //Update button
        Button updateButton = new Button("Update account");
        updateButton.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        updateButton.setTextFill(Color.WHITE);
        updateButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)");
        updateButton.setOnMouseEntered(e -> updateButton.setStyle("-fx-background-color: linear-gradient(#240e10, #006600)"));
        updateButton.setOnMouseExited(event -> updateButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)"));
        updateButton.setPrefWidth(150);
        updateButton.setPrefHeight(50);
        updateButton.setOnAction(e ->
        {
            /*
            if(firstNameField.getText().equals("") || lastNameField.getText().equals("") ||
                    businessEmailField.getText().equals("") || enterPasswordField.getText().equals("") ||
                    confirmPasswordField.getText().equals("") || locationCombo.getValue().toString().equals("") ||
                    cityField.getText().equals("") || cvrNoField.getText().equals(""))
            {
                root.setBottom(fillInformationerrorLabel);
            }
            */
            if (!enterPasswordField.getText().equals(confirmPasswordField.getText()))
            {
                root.setBottom(passwordNotSame);
            }
            else if(cvrNoField.getLength() != 8)
            {
                root.setBottom(cvrMax8);

            }
            else
            {
                try
                {
                    DBHandlerBuyer.updateBuyerProfile(firstNameField, lastNameField, businessNameField, businessEmailField,
                            enterPasswordField, locationCombo, cvrNoField);
                    window.close();
                }
                catch(NullPointerException e1)
                {
                    root.setBottom(fillAllFields);
                }
            }

        });

        //Tilføjer til HBox VBox & BorderPane

        VBox labelVBox = new VBox();
        labelVBox.getChildren().addAll(firstNameLabel,lastNameLabel,businessNameLabel, businessEmailLabel, enterPasswordLabel,
                confirmPasswordLabel, locationLabel, cityLabel, cvrNoLabel);
        labelVBox.setSpacing(24);

        VBox inputVBox = new VBox();
        inputVBox.getChildren().addAll(firstNameField, lastNameField, businessNameField, businessEmailField,
                enterPasswordField, confirmPasswordField, locationCombo, cityField, cvrNoField, updateButton);
        inputVBox.setSpacing(15);

        HBox centerHBox = new HBox();
        centerHBox.getChildren().addAll(labelVBox, inputVBox);
        centerHBox.setSpacing(10);
        centerHBox.setPadding(new Insets(5,0,0,130));

        root.setCenter(centerHBox);

        ResultSet rs2 = DBHandlerBuyer.getUserInformationsForEdit();
        try {
            while (rs2.next()) {
                Buyer buyer = new Buyer();
                buyer.setFirstName(rs2.getString("firstName"));
                buyer.setLastName(rs2.getString("lastName"));
                buyer.setBusinessName(rs2.getString("businessName"));
                buyer.setBusinessEmail(rs2.getString("businessEmail"));
                buyer.setLocation(rs2.getString("location"));
                buyer.setCvr(rs2.getInt("cvr"));
                buyer.setPassword(rs2.getString("password"));
//                buyer.setRating(rs2.getDouble("rating"));


                firstNameField.setText(buyer.getFirstName());
                lastNameField.setText(buyer.getLastName());
                businessNameField.setText(buyer.getBusinessName());
                businessEmailField.setText(buyer.getBusinessEmail());
                locationCombo.setValue(buyer.getLocation());
                enterPasswordField.setText(buyer.getPassword());

                cityField.setText(DBHandlerLocation.setCity(locationCombo.getValue().toString()));
                cvrNoField.setText(Integer.toString(buyer.getCvr()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        window.show();
    }
}
