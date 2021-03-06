package GUI;

import DatabaseController.InputValidator;
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
        window.setResizable(false);
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

        Label errorMessage = new Label();
        errorMessage.setFont(Font.font("Verdana", 13));
        errorMessage.setTextFill(Color.RED);

        //Input fields
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("Enter your first name");
        firstNameField.setOnMouseClicked(e -> errorMessage.setText(""));
        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Enter your last name");
        lastNameField.setOnMouseClicked(e -> errorMessage.setText(""));
        TextField businessNameField = new TextField();
        businessNameField.setPromptText("Enter name of your business");
        businessNameField.setOnMouseClicked(e -> errorMessage.setText(""));
        TextField businessEmailField = new TextField();
        businessEmailField.setPromptText("Enter business email");
        businessEmailField.setOnMouseClicked(e -> errorMessage.setText(""));
        PasswordField enterPasswordField = new PasswordField();
        enterPasswordField.setPromptText("Enter your new password");
        enterPasswordField.setOnMouseClicked(e -> errorMessage.setText(""));
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Repeat password");
        confirmPasswordField.setOnMouseClicked(e -> errorMessage.setText(""));
        TextField cityField = new TextField();
        cityField.setEditable(false);
        TextField cvrNoField = new TextField();
        cvrNoField.setPromptText("Enter business CVR number");
        cvrNoField.setOnMouseClicked(e -> errorMessage.setText(""));

        ComboBox locationCombo = new ComboBox();
        locationCombo.setPromptText("Enter location");
        locationCombo.setOnMouseClicked(e -> errorMessage.setText(""));
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

        createButton.setOnAction(e ->
        {

            if(firstNameField.getText().equals("") || lastNameField.getText().equals("") ||
                    businessNameField.getText().equals("") || businessEmailField.getText().equals("") ||
                    enterPasswordField.getText().equals("") || confirmPasswordField.getText().equals(""))
            {
                errorMessage.setText("Please fill all fields");
            }
            else if (!enterPasswordField.getText().equals(confirmPasswordField.getText()))
            {
                errorMessage.setText("Passwords don't match.");
            }

            else if(InputValidator.userExists(businessEmailField) == true)
            {
                errorMessage.setText("Email already exists. Choose another.");
            }

            else if (InputValidator.checkLoginEmail(businessEmailField) == 2)
            {
                errorMessage.setText("Email must contain '@' and '.'");
            }

            else if(cvrNoField.getLength() != 8)
            {
                errorMessage.setText("CVR must be 8 numbers");

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
                    errorMessage.setText("Please fill all fields");
                }
                catch (NumberFormatException e2)
                {
                    errorMessage.setText("CVR must be numbers");
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
                enterPasswordField, confirmPasswordField, locationCombo, cityField, cvrNoField, createButton, errorMessage);
        inputVBox.setSpacing(15);
        inputVBox.setPrefWidth(280);

        HBox centerHBox = new HBox();
        centerHBox.getChildren().addAll(labelVBox, inputVBox);
        centerHBox.setSpacing(10);
        centerHBox.setPadding(new Insets(5,0,0,130));

        root.setCenter(centerHBox);

        window.show();
    }
}
