package GUI;

import Database.DBHandlerBuyer;
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
        Label fillInformationerrorLabel = new Label("Fill all text fields before creating profile");
            fillInformationerrorLabel.setTextFill(Color.RED);
        Label passwordNotSame = new Label("Passwords must be the same before creating profile");
            passwordNotSame.setTextFill(Color.RED);

        //Input fields
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField businessNameField = new TextField();
        TextField businessEmailField = new TextField();
        PasswordField enterPasswordField = new PasswordField();
        PasswordField confirmPasswordField = new PasswordField();
        ComboBox locationCombo = new ComboBox<>();
            locationCombo.getItems().addAll("2100", "2200", "2300", "2400", "2450", "2500");
            locationCombo.setPrefWidth(200);
        TextField cityField = new TextField();
        TextField cvrNoField = new TextField();

        //Create Button
        Button createButton = new Button("Create account");
        createButton.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        createButton.setTextFill(Color.WHITE);
        createButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)");
        createButton.setPrefWidth(150);
        createButton.setPrefHeight(50);
        createButton.setOnAction(e ->
        {
            if(firstNameField.getText().equals("") || lastNameField.getText().equals("") ||
                    businessEmailField.getText().equals("") || enterPasswordField.getText().equals("") ||
                    confirmPasswordField.getText().equals("") || locationCombo.getValue().toString().equals("") ||
                    cityField.getText().equals("") || cvrNoField.getText().equals(""))
            {
                root.setBottom(fillInformationerrorLabel);
            }
            else if (!enterPasswordField.getText().equals(confirmPasswordField.getText()))
            {
                root.setBottom(passwordNotSame);
            }

            else
            {
                DBHandlerBuyer.saveBuyer(firstNameField, lastNameField, businessNameField, businessEmailField,
                        enterPasswordField, locationCombo, cityField, cvrNoField);
                window.close();
                HomeScreen.homeScreen();
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
