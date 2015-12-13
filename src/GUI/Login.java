package GUI;

import Controller.InputValidator;
import Controller.LoginVerifier;
import Database.DBHandlerSeller;
import Database.DBHandlerTask;
import Database.SchemaCreator;
import Database.TableCreator;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
import sun.rmi.runtime.Log;

import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by christianhasselstrom on 25/11/2015.
 */
public class Login extends Application {
    BorderPane borderRoot;
    Stage window;
    HBox loginHBox;
    Button loginButton;
    TextField loginTextfield;
    PasswordField passwordField;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        SchemaCreator.create();
        TableCreator.createQualificationTable();
        TableCreator.createCitiesTable();
        TableCreator.createSellerTable();
        TableCreator.createBuyerTable();
        TableCreator.createTaskTable();
        window = primaryStage;
        Login();
    }

    public static void Login()
    {
        final BooleanProperty firstTime = new SimpleBooleanProperty(true);
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: linear-gradient(#42C0FB, #236B8E) ");

        VBox loginVBox = new VBox();
        loginVBox.setPrefWidth(300);
        loginVBox.setSpacing(10);
        root.setTop(loginVBox);

        HBox topHBox = new HBox();
        topHBox.setPrefWidth(300);
        topHBox.setSpacing(30);

        HBox loginHBox = new HBox();
        loginHBox.setPrefWidth(300);
        loginHBox.setSpacing(30);


        //Users HBox
        HBox usersHBox = new HBox();
        usersHBox.setPrefWidth(1280);
        usersHBox.setSpacing(10);

        //Users VBox
        VBox usersVBox = new VBox();
        usersVBox.setPrefWidth(1280);
        usersVBox.setSpacing(10);
        root.setCenter(usersVBox);
        usersVBox.setPadding(new Insets(150));

        Stage window = new Stage();
        Scene scene = new Scene(root, 550, 600);
        window.setScene(scene);
        window.setResizable(false);

        //user Label
        Label userLabel = new Label("Email");
        userLabel.setPrefWidth(200);
        userLabel.setFont(Font.font("Verdana", 15));

        //
        Label passLabel = new Label("Password");
        passLabel.setPrefWidth(200);
        passLabel.setPrefWidth(200);
        passLabel.setFont(Font.font("Verdana", 15));

        Label errorMessage = new Label();
        errorMessage.setFont(Font.font("Verdana", 15));
        errorMessage.setTextFill(Color.RED);
        HBox errorMessageBox = new HBox();
        errorMessageBox.getChildren().add(errorMessage);

        //login textfield
        TextField loginTextfield = new TextField();
        loginTextfield.setFont(Font.font("Verdana"));
        loginTextfield.setPromptText("example@example.com");
        loginTextfield.setOnMouseClicked(e -> errorMessage.setText(""));
        loginTextfield.setPrefWidth(200);
        loginTextfield.setPrefHeight(30);
        //http://stackoverflow.com/questions/29051225/remove-default-focus-from-textfield-javafx
        loginTextfield.focusedProperty().addListener((observable,  oldValue,  newValue) ->
        {
            if(newValue && firstTime.get()){
                root.requestFocus(); // Delegate the focus to container
                firstTime.setValue(false); // Variable value changed for future references
            }
        });


        //login passwordfield
        PasswordField passwordField = new PasswordField();
        passwordField.setOnMouseClicked(e -> errorMessage.setText(""));
        passwordField.setFont(Font.font("Verdana"));
        passwordField.setPromptText("You password");
        passwordField.setPrefWidth(200);
        passwordField.setPrefHeight(30);

        //login button
        Button loginButton = new Button("Login");
        loginButton.setFont(Font.font("Verdana"));
        loginButton.setDefaultButton(true);
        loginButton.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        loginButton.setOnMouseExited(e -> loginButton.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)"));
        loginButton.setOnMouseEntered(e ->loginButton.setStyle("-fx-background-color: linear-gradient(#279dc4, #a7d9f5)"));
        loginButton.setOnAction(e ->
        {
                if (InputValidator.checkLoginEmail(loginTextfield) == 1)
                {
                    errorMessage.setText("Email field is empty");
                } else if (InputValidator.checkLoginEmail(loginTextfield) == 2)
                {
                    errorMessage.setText("Email must contain '@' and '.'");
                } else if (InputValidator.checkLoginPassword(passwordField) == false)
                {
                    errorMessage.setText("Password field is empty");
                } else
                {
                    try
                    {
                        LoginVerifier.setEmail(loginTextfield);
                        LoginVerifier.verifyUser(loginTextfield, passwordField);
                    }
                    catch (SQLException sqlEx)
                    {
                        errorMessage.setText("sdf");
                    }

                }

        });

        //Create seller button
        Button createSellerButton = new Button("Create Seller");
        createSellerButton.setFont(Font.font("Verdana", 15));
        createSellerButton.setPrefWidth(250);
        createSellerButton.setPrefHeight(65);
        createSellerButton.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        createSellerButton.setOnMouseExited(e -> createSellerButton.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)"));
        createSellerButton.setOnMouseEntered(e ->createSellerButton.setStyle("-fx-background-color: linear-gradient(#279dc4, #a7d9f5)"));
        createSellerButton.setOnAction(e ->
        {
            window.close();
            CreateSellerWindow.openWindow();

        });

        //create buyer button
        Button createBuyerButton = new Button("Create Buyer");
        createBuyerButton.setFont(Font.font("Verdana", 15));
        createBuyerButton.setPrefWidth(250);
        createBuyerButton.setPrefHeight(65);
        createBuyerButton.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        createBuyerButton.setOnMouseExited(e -> createBuyerButton.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)"));
        createBuyerButton.setOnMouseEntered(e ->createBuyerButton.setStyle("-fx-background-color: linear-gradient(#279dc4, #a7d9f5)"));
        createBuyerButton.setOnAction(e ->
        {
            window.close();
            CreateBuyerWindow.openWindow();
        });

        //vicarius label
        Label vicarius = new Label("Vicarius");
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        vicarius.setEffect(r);
        vicarius.setTextFill(Color.GHOSTWHITE);
        vicarius.setFont(Font.font("Verdana", FontWeight.BOLD, 60));


        //getChildren()
        loginVBox.getChildren().addAll(vicarius, topHBox, loginHBox, errorMessageBox);
        topHBox.getChildren().addAll(userLabel, passLabel);
        loginHBox.getChildren().addAll(loginTextfield, passwordField, loginButton);
        //usersHBox.getChildren().addAll(createBuyerButton, createSellerButton);
        usersVBox.getChildren().addAll(createBuyerButton, createSellerButton);

        window.show();
    }
    public static void alertWindow()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("User Created");
        alert.setHeaderText("Now login with your new user");

        ButtonType buttonTypeOk = new ButtonType("OK");

        alert.getButtonTypes().setAll(buttonTypeOk);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOk)
        {
            Login();
        } else
        {

        }
    }

}
