package GUI;

import Database.SchemaCreator;
import Database.TableCreator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;
import sun.security.util.Password;

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
        TableCreator.createSeller();
        TableCreator.createBuyer();
        window = primaryStage;
        Login();
    }

    public static void Login() {
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
        Label userLabel = new Label("Login");
        userLabel.setPrefWidth(200);

        //
        Label passLabel = new Label("Password");
        passLabel.setPrefWidth(200);

        //login textfield
        TextField loginTextfield = new TextField();
        loginTextfield.setPrefWidth(200);
        loginTextfield.setPrefHeight(30);

        //login passwordfield
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefWidth(200);
        passwordField.setPrefHeight(30);

        //login button
        Button loginButton = new Button("Login");

        //Create seller button
        Button createSellerButton = new Button("Create Seller");
        createSellerButton.setPrefWidth(250);
        createSellerButton.setPrefHeight(65);
        createSellerButton.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        createSellerButton.setOnAction(e ->
        {
            window.close();
            CreateSellerWindow.openWindow();

        });

        //create buyer button
        Button createBuyerButton = new Button("Create Buyer");
        createBuyerButton.setPrefWidth(250);
        createBuyerButton.setPrefHeight(65);
        createBuyerButton.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
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
        vicarius.setTextFill(Color.LIGHTGRAY);
        vicarius.setFont(Font.font("Verdana", FontWeight.BOLD, 60));


        //getChildren()
        loginVBox.getChildren().addAll(vicarius, topHBox, loginHBox);
        topHBox.getChildren().addAll(userLabel, passLabel);
        loginHBox.getChildren().addAll(loginTextfield, passwordField, loginButton);
        //usersHBox.getChildren().addAll(createBuyerButton, createSellerButton);
        usersVBox.getChildren().addAll(createBuyerButton, createSellerButton);

        window.show();
    }
}
