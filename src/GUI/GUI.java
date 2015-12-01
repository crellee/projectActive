package GUI;

import Database.SchemaCreator;
import Database.TableCreator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;

/**
 * Created by christianhasselstrom on 16/11/2015.
 */
/*
public class GUI extends Application {

    BorderPane root, borderRoot;
    GridPane gridRoot;
    Stage window;
    ToggleGroup tGroup;
    ToggleButton myProfileBtn, sellersBtn, buyersBtn, matchesBtn, tasksBtn,  signOutBtn;
    Button loginButton, createSellerButton, createBuyerButton;
    Label headLine, passLabel, userLabel, vicarius, invisibleLabel;
    VBox topVBox, loginVBox, usersVBox;
    HBox buttonBox, loginHBox, topHBox, usersHBox;
    TextField loginTextfield;
    PasswordField passwordField;


    public void GUI()
    {
        //BorderPane


    }

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        SchemaCreator.create();
        TableCreator.create();
        window = primaryStage;

    }

    public void Login()
    {
        root = new BorderPane();
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: linear-gradient(#42C0FB, #236B8E) ");

        loginVBox = new VBox();
        loginVBox.setPrefWidth(300);
        loginVBox.setSpacing(10);
        root.setTop(loginVBox);

        topHBox = new HBox();
        topHBox.setPrefWidth(300);
        topHBox.setSpacing(30);

        loginHBox = new HBox();
        loginHBox.setPrefWidth(300);
        loginHBox.setSpacing(30);

        //Users HBox
        usersHBox = new HBox();
        usersHBox.setPrefWidth(1280);
        usersHBox.setSpacing(10);

        //Users VBox
        usersVBox = new VBox();
        usersVBox.setPrefWidth(1280);
        usersVBox.setSpacing(10);
        invisibleLabel = new Label();
        root.setCenter(usersVBox);
        usersVBox.setPadding(new Insets(150));


        window.show();
        Scene scene = new Scene(root, 550, 600);
        window.setScene(scene);
        window.setResizable(false);

        //user Label
        userLabel = new Label("Login");
        userLabel.setPrefWidth(200);

        //
        passLabel = new Label("Password");
        passLabel.setPrefWidth(200);

        //login textfield
        loginTextfield = new TextField();
        loginTextfield.setPrefWidth(200);
        loginTextfield.setPrefHeight(30);

        //login passwordfield
        passwordField = new PasswordField();
        passwordField.setPrefWidth(200);
        passwordField.setPrefHeight(30);

        //login button
        loginButton = new Button("Login");

        //Create seller button
        createSellerButton = new Button("Create Controller.Seller");
        createSellerButton.setPrefWidth(250);
        createSellerButton.setPrefHeight(65);
        createSellerButton.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        createSellerButton.setOnAction(e ->
        {

        });

        //create buyer button
        createBuyerButton = new Button("Create Buyer");
        createBuyerButton.setPrefWidth(250);
        createBuyerButton.setPrefHeight(65);
        createBuyerButton.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");

        //vicarius label
        vicarius = new Label("Vicarius");
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


    }

   /* public void homeScreen()
    {
        root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(#42C0FB, #236B8E) ");
        root.setPadding(new Insets(15));
        topVBox = new VBox();
        topVBox.setPrefWidth(1280);
        topVBox.setSpacing(70);
        root.setTop(topVBox);
        buttonBox = new HBox();
        buttonBox.setPrefWidth(1280);
        buttonBox.setSpacing(5);
        window.show();

        //Create scene
        Scene scene = new Scene(root, 1280, 700);
        window.setScene(scene);
        window.setResizable(false);





        //Label
        headLine = new Label("Vicarius");
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        headLine.setEffect(r);
        headLine.setTextFill(Color.GHOSTWHITE);
        headLine.setFont(Font.font("Verdana", FontWeight.BOLD, 60));

        //sellersBtn
        sellersBtn = new ToggleButton("Sellers");
        sellersBtn.setPrefHeight(20);
        sellersBtn.setPrefWidth(100);
        sellersBtn.setFont(Font.font("Verdana"));
        sellersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        buttonBox.getChildren().add(sellersBtn);
        sellersBtn.setOnAction(e ->
        {
            root.setCenter(sellersTable());
        });

        //buyersBtn
        buyersBtn = new ToggleButton("Buyers");
        buyersBtn.setPrefHeight(20);
        buyersBtn.setPrefWidth(100);
        buyersBtn.setFont(Font.font("Verdana"));
        buyersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        buttonBox.getChildren().add(buyersBtn);
        buyersBtn.setOnAction(e ->
        {
            root.setCenter(buyersTable());
        });

        //matchesBtn
        matchesBtn = new ToggleButton("Matches");
        matchesBtn.setPrefHeight(20);
        matchesBtn.setPrefWidth(100);
        matchesBtn.setFont(Font.font("Verdana"));
        matchesBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        buttonBox.getChildren().add(matchesBtn);
        matchesBtn.setOnAction(e ->
        {
            root.setCenter(matchesTable());
        });

        //taskBtn
        tasksBtn = new ToggleButton("Tasks");
        tasksBtn.setPrefHeight(20);
        tasksBtn.setPrefWidth(100);
        tasksBtn.setFont(Font.font("Verdana"));
        tasksBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        buttonBox.getChildren().add(tasksBtn);
        tasksBtn.setOnAction(e ->
        {
            root.setCenter(tasksTable());
        });

        //myProfileBtn
        myProfileBtn = new ToggleButton("My Profile");
        myProfileBtn.setPrefHeight(20);
        myProfileBtn.setPrefWidth(100);
        myProfileBtn.setFont(Font.font("Verdana"));
        myProfileBtn.setToggleGroup(tGroup);
        myProfileBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        buttonBox.getChildren().add(myProfileBtn);
        myProfileBtn.setOnAction(e ->
        {
            root.setCenter(null);
        });

        //signOutBtn
        signOutBtn = new ToggleButton("Sign Out");


        topVBox.getChildren().addAll(headLine, buttonBox);
    }
    public TableView sellersTable()
    {
        TableView sellersTable = new TableView();

        sellersTable.setPrefWidth(400);
        TableColumn name = new TableColumn("Name");
        TableColumn age = new TableColumn("Age");
        TableColumn location = new TableColumn("Location");
        TableColumn qualifications = new TableColumn("Qualifications");
        TableColumn rating = new TableColumn("Rating");

        name.setPrefWidth(150);
        age.setPrefWidth(150);
        location.setPrefWidth(150);
        qualifications.setPrefWidth(150);
        rating.setPrefWidth(150);

        sellersTable.getColumns().addAll(name, age, location, qualifications, rating);

        return sellersTable;
    }

    public TableView buyersTable()
    {
        TableView buyersTable = new TableView();

        buyersTable.setPrefWidth(400);
        TableColumn buyerDescription = new TableColumn("Buyer description");
        TableColumn location = new TableColumn("Location");
        TableColumn qualifications = new TableColumn("Qualifications");
        TableColumn rating = new TableColumn("Rating");

        buyerDescription.setPrefWidth(200);
        location.setPrefWidth(150);
        qualifications.setPrefWidth(150);
        rating.setPrefWidth(50);

        buyersTable.getColumns().addAll(buyerDescription, location, qualifications, rating);

        return buyersTable;
    }

    public TableView matchesTable()
    {
        TableView matchesTable = new TableView();

        matchesTable.setPrefWidth(400);
        TableColumn jobDescription = new TableColumn("Job description");
        TableColumn buyerDescription = new TableColumn("Buyer description");
        TableColumn location = new TableColumn("Location");
        TableColumn qualifications = new TableColumn("Qualification(s)");
        TableColumn rating = new TableColumn("Rating");
        TableColumn salary = new TableColumn("Salary");

        jobDescription.setPrefWidth(300);
        buyerDescription.setPrefWidth(200);
        location.setPrefWidth(150);
        qualifications.setPrefWidth(150);
        rating.setPrefWidth(50);
        salary.setPrefWidth(80);

        matchesTable.getColumns().addAll(jobDescription, buyerDescription, location, qualifications, rating, salary);

        return matchesTable;
    }

    public TableView tasksTable() {
        TableView tasksTable = new TableView();

        tasksTable.setPrefWidth(400);
        TableColumn jobDescription = new TableColumn("Job description");
        TableColumn buyerDescription = new TableColumn("Buyer description");
        TableColumn location = new TableColumn("Location");
        TableColumn qualifications = new TableColumn("Qualification(s)");
        TableColumn rating = new TableColumn("Rating");
        TableColumn salary = new TableColumn("Salary");

        jobDescription.setPrefWidth(300);
        buyerDescription.setPrefWidth(200);
        location.setPrefWidth(150);
        qualifications.setPrefWidth(150);
        rating.setPrefWidth(50);
        salary.setPrefWidth(80);

        tasksTable.getColumns().addAll(jobDescription, buyerDescription, location, qualifications, rating, salary);

        return tasksTable;
    }
}*/