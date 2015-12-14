package GUI;

import Controller.*;
import Database.DBHandlerLocation;
import Database.DBHandlerSeller;
import Database.DBHandlerSellerAndBuyer;
import Database.DBHandlerTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
 * Created by roije on 25/11/2015.
 */
//this is a window

//This is the GUI class for creating a new account as a seller
public class CreateSellerWindow
{
    public static void openWindow()
    {

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(#42C0FB, #236B8E) ");
        Stage window = new Stage();
        Scene scene = new Scene(root, 650, 650);
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

        //Labels fields
        Label firstNameLabel = new Label("First name:");
        firstNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label lastNameLabel = new Label("Last name:");
        lastNameLabel.setFont(Font.font("Verdana",FontWeight.BOLD, 15));
        Label birthdateLabel = new Label("Birthday:");
        birthdateLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label emailLabel = new Label("Email:");
        emailLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label enterPasswordLabel = new Label("Password:");
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
        Label passwordNotSame = new Label("Passwords must be the same before creating profile");
        passwordNotSame.setTextFill(Color.RED);
        Label fillAllFields = new Label("Please fill ALL fields before creating profile");
        fillAllFields.setTextFill(Color.RED);
        Label allReadyExists = new Label("Email allready exists in database, choose another please.");
        allReadyExists.setTextFill(Color.RED);

        //Input fields
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("Enter your first name");
        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Enter your last name");
        DatePicker birthdateField = new DatePicker();
        birthdateField.setPromptText("Enter your birthday");
        birthdateField.setPrefWidth(312);
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your new password");
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Repeat password");

        CheckBox carpenterCheck = new CheckBox("Carpenter");
        carpenterCheck.setOnMouseEntered(e -> carpenterCheck.setUnderline(true));
        carpenterCheck.setOnMouseExited(e -> carpenterCheck.setUnderline(false));
        CheckBox janitorCheck = new CheckBox("Janitor");
        janitorCheck.setOnMouseEntered(e -> janitorCheck.setUnderline(true));
        janitorCheck.setOnMouseExited(e -> janitorCheck.setUnderline(false));
        CheckBox cleanerCheck = new CheckBox("Cleaner");
        cleanerCheck.setOnMouseEntered(e -> cleanerCheck.setUnderline(true));
        cleanerCheck.setOnMouseExited(e -> cleanerCheck.setUnderline(false));
        CheckBox waiterCheck = new CheckBox("Waiter");
        waiterCheck.setOnMouseEntered(e -> waiterCheck.setUnderline(true));
        waiterCheck.setOnMouseExited(e -> waiterCheck.setUnderline(false));
        CheckBox chefCheck = new CheckBox("Chef");
        chefCheck.setOnMouseEntered(e -> chefCheck.setUnderline(true));
        chefCheck.setOnMouseExited(e -> chefCheck.setUnderline(false));
        CheckBox bartenderCheck = new CheckBox("Bartender");
        bartenderCheck.setOnMouseEntered(e -> bartenderCheck.setUnderline(true));
        bartenderCheck.setOnMouseExited(e -> bartenderCheck.setUnderline(false));
        CheckBox storeCheck = new CheckBox("Store employee");
        storeCheck.setOnMouseEntered(e -> storeCheck.setUnderline(true));
        storeCheck.setOnMouseExited(e -> storeCheck.setUnderline(false));
        CheckBox retailCheck = new CheckBox("Retail");
        retailCheck.setOnMouseEntered(e -> retailCheck.setUnderline(true));
        retailCheck.setOnMouseExited(e -> retailCheck.setUnderline(false));
        CheckBox pedagogueCheck = new CheckBox("Pedagogue");
        pedagogueCheck.setOnMouseEntered(e -> pedagogueCheck.setUnderline(true));
        pedagogueCheck.setOnMouseExited(e -> pedagogueCheck.setUnderline(false));


        VBox checkRow1Box = new VBox();
        checkRow1Box.getChildren().addAll(carpenterCheck, janitorCheck,cleanerCheck);
        checkRow1Box.setSpacing(5);

        VBox checkRow2Box = new VBox();
        checkRow2Box.getChildren().addAll(pedagogueCheck,chefCheck,bartenderCheck);
        checkRow2Box.setSpacing(5);

        VBox checkRow3Box = new VBox();
        checkRow3Box.getChildren().addAll(storeCheck,retailCheck, waiterCheck);
        checkRow3Box.setSpacing(5);

        HBox allCheckRows = new HBox();
        allCheckRows.getChildren().addAll(checkRow1Box,checkRow2Box,checkRow3Box);
        allCheckRows.setSpacing(5);

        ComboBox locationCombo = new ComboBox();
        locationCombo.setPromptText("Enter location");

        ResultSet rs = DBHandlerLocation.getPostNumbers();
        ObservableList<String> data = FXCollections.observableArrayList();
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
        locationCombo.getItems().addAll(data);
        locationCombo.setPrefWidth(312);

        TextField cityField = new TextField();
        cityField.setEditable(false);
        cityField.setPrefWidth(160);
        locationCombo.setOnAction(e ->
        {
            String no = locationCombo.getValue().toString();
            cityField.setText(DBHandlerLocation.setCity(no));
        });


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
                if(emailField.getText().equals(ls1.get(i).getBusinessEmail()))
                {
                    busiE = 1;

                }
            }
            for(int i = 0; i < ls2.size(); i++)
            {
                if(emailField.getText().equals(ls2.get(i).getEmail()))
                {
                    sellE = 1;

                }
            }

            if (!passwordField.getText().equals(confirmPasswordField.getText()))
            {
                root.setBottom(passwordNotSame);
            }
            else if (InputValidator.checkLoginEmail(emailField) == 1)
            {
                fillAllFields.setText("Please fill email field");
                root.setBottom(fillAllFields);
            } else if (InputValidator.checkLoginEmail(emailField) == 2)
            {
                fillAllFields.setText("Email must contain '@' and '.'");
                root.setBottom(fillAllFields);
            }

            else if(busiE == 1)
            {
                root.setBottom(allReadyExists);
            }
            else if(sellE == 1)
            {
                root.setBottom(allReadyExists);
            }

            else
            {
                try {
                    //Call a method which saves information in TextFields etc. in a database table
                    int carpenterInt = Checker.checkSelected(carpenterCheck);
                    int janitorInt = Checker.checkSelected(janitorCheck);
                    int cleanerInt = Checker.checkSelected(cleanerCheck);
                    int waiterInt = Checker.checkSelected(waiterCheck);
                    int chefInt = Checker.checkSelected(chefCheck);
                    int bartenderInt = Checker.checkSelected(bartenderCheck);
                    int storeInt = Checker.checkSelected(storeCheck);
                    int retailInt = Checker.checkSelected(retailCheck);
                    int pedaInt = Checker.checkSelected(pedagogueCheck);

                    DBHandlerSeller.saveSeller(firstNameField, lastNameField, birthdateField, emailField, passwordField,
                            carpenterInt, janitorInt, cleanerInt, waiterInt, chefInt,
                            bartenderInt, storeInt, retailInt, pedaInt, locationCombo);
                    Login.alertWindow();
                    window.close();
                }
                catch (NullPointerException e1)
                {
                    root.setBottom(fillAllFields);
                }
            }
        });

        //VBox with all information labels.
        VBox labelVBox = new VBox();
        labelVBox.getChildren().addAll(firstNameLabel,lastNameLabel,birthdateLabel, emailLabel, enterPasswordLabel,
                confirmPasswordLabel, qualificationsLabel, locationLabel, cityLabel);
        labelVBox.setSpacing(22.3);

        //VBox with all input fields
        VBox inputVBox = new VBox();
        inputVBox.getChildren().addAll(firstNameField, lastNameField, birthdateField, emailField, passwordField,
                confirmPasswordField, allCheckRows, locationCombo, cityField, createButton);
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