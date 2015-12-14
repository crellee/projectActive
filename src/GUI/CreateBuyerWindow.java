package GUI;

import Controller.Buyer;
import Controller.InputValidator;
import Controller.Location;
import Controller.Seller;
import Database.DBHandlerBuyer;
import Database.DBHandlerLocation;
import Database.DBHandlerSellerAndBuyer;
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
import java.util.ArrayList;

/**
 * Created by christianhasselstrom on 25/11/2015.
 */
public class CreateBuyerWindow
{
    public static void openWindow()
    {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(#42C0FB, #236B8E) ");
        Stage window = new Stage();
        Scene scene = new Scene(root, 600, 600);
        window.setScene(scene);

        //Header label
        Label headLine = new Label("Create Account (buyer)");
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        headLine.setEffect(r);
        headLine.setTextFill(Color.GHOSTWHITE);
        headLine.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        //Back button to previous window
        Button backBtn = new Button("Back");
        backBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        backBtn.setOnMouseExited(e -> backBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)"));
        backBtn.setOnMouseEntered(e ->backBtn.setStyle("-fx-background-color: linear-gradient(#279dc4, #a7d9f5)"));
        backBtn.setOnAction(e ->
        {
            window.close();
            Login.Login();
        });

        //Add headline and back button to top of window
        VBox topVBox = new VBox();
        topVBox.getChildren().addAll(headLine,backBtn);
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
        Label enterPasswordLabel = new Label("Password");
        enterPasswordLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label confirmPasswordLabel = new Label("Confirm Password");
        confirmPasswordLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label locationLabel = new Label("Postal code: ");
        locationLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label cityLabel = new Label("City");
        cityLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label cvrNoLabel = new Label("CVR-Number");
        cvrNoLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label fillInformationerrorLabel = new Label("Fill all text fields before creating profile");
            fillInformationerrorLabel.setTextFill(Color.RED);
        Label passwordNotSame = new Label("Passwords must be the same before creating profile");
            passwordNotSame.setTextFill(Color.RED);
        Label fillAllFields = new Label("Please fill ALL fields before creating profile");
            fillAllFields.setTextFill(Color.RED);
        Label cvrMax8 = new Label("Cvr must max be 8 characters and only numbers");
        cvrMax8.setTextFill(Color.RED);
        Label allReadyExists = new Label("Email allready exists in database, choose another please.");
        allReadyExists.setTextFill(Color.RED);

        //Input fields
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("Enter your first name");
        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Enter your last name");
        TextField businessNameField = new TextField();
        businessNameField.setPromptText("Enter name of your business");
        TextField businessEmailField = new TextField();
        businessEmailField.setPromptText("Enter business email");
        PasswordField enterPasswordField = new PasswordField();
        enterPasswordField.setPromptText("Enter your new password");
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Repeat password");
        TextField cityField = new TextField();
        cityField.setEditable(false);
        TextField cvrNoField = new TextField();
        cvrNoField.setPromptText("Enter business CVR number");

        ComboBox locationCombo = new ComboBox();
        locationCombo.setPromptText("Enter location");
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

        //Create Button
        Button createButton = new Button("Create account");
        createButton.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        createButton.setTextFill(Color.WHITE);
        createButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)");
        createButton.setOnMouseEntered(e -> createButton.setStyle("-fx-background-color: linear-gradient(#240e10, #006600)"));
        createButton.setOnMouseExited(event -> createButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)"));
        createButton.setPrefWidth(150);
        createButton.setPrefHeight(50);

        //creates Arraylists with buyers emails and sellers email

        ArrayList<Buyer> ls1 = new ArrayList<>();
        ArrayList<Seller> ls2 = new ArrayList<>();


        try {
            ResultSet rs2 = DBHandlerSellerAndBuyer.isUnique();

            while (rs2.next()) {

                Buyer buyer = new Buyer();
                Seller seller = new Seller();

                buyer.setBusinessEmail(rs2.getString("businessEmail"));

                seller.setEmail(rs2.getString("email"));

                ls1.add(buyer);
                ls2.add(seller);
            }
        }
        catch(Exception e1)
        {

        }

        createButton.setOnAction(e ->
        {
            // if when a new user is created the chosen email allready exists in the database either busiE or sellE will be 1
            int busiE = 0;
            int sellE = 0;

            for(int i = 0; i < ls1.size(); i++)
            {
                if(businessEmailField.getText().equals(ls1.get(i).getBusinessEmail()))
                {
                    busiE = 1;

                }
            }
            for(int i = 0; i < ls2.size(); i++)
            {
                if(businessEmailField.getText().equals(ls2.get(i).getEmail()))
                {
                    sellE = 1;

                }
            }

            if (!enterPasswordField.getText().equals(confirmPasswordField.getText()))
            {
                root.setBottom(passwordNotSame);
            }

            else if (InputValidator.checkLoginEmail(businessEmailField) == 1)
            {
                fillAllFields.setText("Please fill email field");
                root.setBottom(fillAllFields);
            } else if (InputValidator.checkLoginEmail(businessEmailField) == 2)
            {
                fillAllFields.setText("Email must contain '@' and '.'");
                root.setBottom(fillAllFields);
            }

            else if(busiE == 1)
            {
                root.setBottom(allReadyExists);
            }
            else if( sellE == 1)
            {
                root.setBottom(allReadyExists);
            }

            else if(cvrNoField.getLength() != 8)
            {
                root.setBottom(cvrMax8);

            }
            else
            {
                try
                {
                    DBHandlerBuyer.saveBuyer(firstNameField, lastNameField, businessNameField, businessEmailField,
                            enterPasswordField, locationCombo, cvrNoField);
                    Login.alertWindow();
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
                enterPasswordField, confirmPasswordField, locationCombo, cityField, cvrNoField, createButton);
        inputVBox.setSpacing(15);

        HBox centerHBox = new HBox();
        centerHBox.getChildren().addAll(labelVBox, inputVBox);
        centerHBox.setSpacing(10);
        centerHBox.setPadding(new Insets(5,0,0,130));


        root.setCenter(centerHBox);

        window.show();
    }
}
