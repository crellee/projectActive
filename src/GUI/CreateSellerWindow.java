package GUI;

import Database.DBHandlerSeller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
 * Created by roije on 25/11/2015.
 */
//This is the GUI class for creating a new account as a seller
public class CreateSellerWindow
{
    public static void openWindow()
    {

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(#42C0FB, #236B8E) ");
        Stage window = new Stage();
        Scene scene = new Scene(root, 600, 600);
        window.setScene(scene);

        //Header label
        Label headLine = new Label("Create Account (seller)");
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

        //Labels fields
        Label firstNameLabel = new Label("First name:");
        firstNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label lastNameLabel = new Label("Last name:");
        lastNameLabel.setFont(Font.font("Verdana",FontWeight.BOLD, 15));
        Label birthdateLabel = new Label("Birthday:");
        birthdateLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label emailLabel = new Label("Email:");
        emailLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label enterPasswordLabel = new Label("Enter password:");
        enterPasswordLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label confirmPasswordLabel = new Label("Confirm password:");
        confirmPasswordLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label qualificationsLabel = new Label("Qualifications:");
        qualificationsLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label locationLabel = new Label("Postal code: ");
        locationLabel.setPadding(new Insets(51,0,0,0));
        locationLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label cityLabel = new Label("City:");
        cityLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        //Input fields
        TextField firstNameText = new TextField();
        TextField lastNameText = new TextField();
        DatePicker birthdateField = new DatePicker();
        birthdateField.setPrefWidth(200);
        TextField emailText = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField confirmPasswordField = new PasswordField();
        CheckBox carpenterCheck = new CheckBox("Carpenter");
        CheckBox carpenterCheck1 = new CheckBox("Carpenter");
        CheckBox carpenterCheck2 = new CheckBox("Carpenter");
        CheckBox carpenterCheck3 = new CheckBox("Carpenter");
        CheckBox carpenterCheck4 = new CheckBox("Carpenter");
        CheckBox carpenterCheck5 = new CheckBox("enter");
        CheckBox carpenterCheck6 = new CheckBox("Carpenter");
        CheckBox carpenterCheck7 = new CheckBox("Carpenter");
        CheckBox carpenterCheck8 = new CheckBox("Carpenter");

        HBox checkRow1Box = new HBox();
        checkRow1Box.getChildren().addAll(carpenterCheck,carpenterCheck1,carpenterCheck2);

        HBox checkRow2Box = new HBox();
        checkRow2Box.getChildren().addAll(carpenterCheck5,carpenterCheck6,carpenterCheck7);

        HBox checkRow3Box = new HBox();
        checkRow3Box.getChildren().addAll(carpenterCheck3,carpenterCheck4,carpenterCheck8);

        ComboBox locationCombo = new ComboBox<>();
        locationCombo.setPrefWidth(220);
        TextField cityField = new TextField();
        cityField.setPrefWidth(160);

        Button createButton = new Button("Create account");
        createButton.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        createButton.setTextFill(Color.WHITE);
        createButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)");
        createButton.setPrefWidth(150);
        createButton.setPrefHeight(50);
        createButton.setOnAction(e ->
        {
            //Call a method which saves information in TextFields etc. in a database table
            /*
            DBHandlerSeller.saveSeller(firstNameText, lastNameText, birthdateField, emailText, passwordField,
                    qualificationsCombo, locationCombo, cityField);
                    */
            HomeScreen.homeScreen();
            window.close();
        });

        //VBox with all information labels.
        VBox labelVBox = new VBox();
        labelVBox.getChildren().addAll(firstNameLabel,lastNameLabel,birthdateLabel, emailLabel, enterPasswordLabel,
                confirmPasswordLabel, qualificationsLabel, locationLabel, cityLabel);
        labelVBox.setSpacing(24);

        //VBox with all input fields
        VBox inputVBox = new VBox();
        inputVBox.getChildren().addAll(firstNameText, lastNameText, birthdateField, emailText, passwordField,
                confirmPasswordField, checkRow1Box, checkRow2Box, checkRow3Box, locationCombo, cityField, createButton);
        inputVBox.setSpacing(15);

        //Label VBox and Input VBOX placed inside a HBox which is set to center of BorderPane
        HBox centerHBox = new HBox();
        centerHBox.getChildren().addAll(labelVBox, inputVBox);
        centerHBox.setSpacing(10);
        centerHBox.setPadding(new Insets(5,0,0,130));


        root.setCenter(centerHBox);

        window.show();


    }
}
