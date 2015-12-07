package GUI;

import Controller.Buyer;
import Database.DBHandlerBuyer;
import Database.DBHandlerLocation;
import Diagrams.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
 * Created by christianhasselstrom on 01/12/2015.
 */
public class HomeScreenBuyer
{

    public static void homeScreenBuyer() {
        BorderPane root = new BorderPane();
        ToggleGroup tGroup = new ToggleGroup();
        root.setStyle("-fx-background-color: linear-gradient(#42C0FB, #236B8E) ");
        root.setPadding(new Insets(15));
        VBox topVBox = new VBox();
        topVBox.setPrefWidth(1280);
        topVBox.setSpacing(70);
        HBox topHBox = new HBox();
        topHBox.setPrefWidth(1280);
        topHBox.setSpacing(800);
        root.setTop(topVBox);
        HBox buttonBox = new HBox();
        buttonBox.setPrefWidth(1280);
        buttonBox.setSpacing(5);

        //Create scene
        Stage window = new Stage();
        Scene scene = new Scene(root, 1280, 700);
        window.setScene(scene);
        window.setResizable(false);
        window.show();

        //Label
        Label headLine = new Label("Vicarius");
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        headLine.setEffect(r);
        headLine.setTextFill(Color.GHOSTWHITE);
        headLine.setFont(Font.font("Verdana", FontWeight.BOLD, 60));

        //sellersBtn
        ToggleButton sellersBtn = new ToggleButton("Sellers");
        ToggleButton buyersBtn = new ToggleButton("Buyers");
        ToggleButton matchesBtn = new ToggleButton("Matches");
        ToggleButton tasksBtn = new ToggleButton("Tasks");
        ToggleButton myProfileBtn = new ToggleButton("My Profile");

        sellersBtn.setPrefHeight(20);
        sellersBtn.setPrefWidth(100);
        sellersBtn.setFont(Font.font("Verdana"));
        sellersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        buttonBox.getChildren().add(sellersBtn);
        sellersBtn.setOnAction(e ->
        {
            buyersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            matchesBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            tasksBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            myProfileBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            sellersBtn.setStyle("-fx-background-color: linear-gradient(#279dc4, #a7d9f5)");
            root.setCenter(SellersTable.getSellersTable());
        });

        //buyersBtn
        buyersBtn.setPrefHeight(20);
        buyersBtn.setPrefWidth(100);
        buyersBtn.setFont(Font.font("Verdana"));
        buyersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        buttonBox.getChildren().add(buyersBtn);
        buyersBtn.setOnAction(e ->
        {
            sellersBtn.setStyle(("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)"));
            matchesBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            tasksBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            myProfileBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            buyersBtn.setStyle("-fx-background-color: linear-gradient(#279dc4, #a7d9f5)");
            root.setCenter(BuyersTable.getBuyersTable());
        });

        //matchesBtn
        matchesBtn.setPrefHeight(20);
        matchesBtn.setPrefWidth(100);
        matchesBtn.setFont(Font.font("Verdana"));
        matchesBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        buttonBox.getChildren().add(matchesBtn);
        matchesBtn.setOnAction(e ->
        {
            sellersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            buyersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            tasksBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            myProfileBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            matchesBtn.setStyle("-fx-background-color: linear-gradient(#279dc4, #a7d9f5)");
            root.setCenter(MatchesTableSeller.matchesTable());
            root.setCenter(MatchesTableBuyer.matchesTable());
        });

        //taskBtn
        tasksBtn.setPrefHeight(20);
        tasksBtn.setPrefWidth(100);
        tasksBtn.setFont(Font.font("Verdana"));
        tasksBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        buttonBox.getChildren().add(tasksBtn);
        tasksBtn.setOnAction(e ->
        {
            sellersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            buyersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            matchesBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            myProfileBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            tasksBtn.setStyle("-fx-background-color: linear-gradient(#279dc4, #a7d9f5)");
            root.setCenter(TasksTable.getTasksTable());
        });

        //myProfileBtn
        myProfileBtn.setPrefHeight(20);
        myProfileBtn.setPrefWidth(100);
        myProfileBtn.setFont(Font.font("Verdana"));
        myProfileBtn.setToggleGroup(tGroup);
        myProfileBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        buttonBox.getChildren().add(myProfileBtn);
        myProfileBtn.setOnAction(e ->
        {
            sellersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            buyersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            matchesBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            tasksBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            myProfileBtn.setStyle("-fx-background-color: linear-gradient(#279dc4, #a7d9f5)");
            root.setCenter(MyProfileBuyer.myProfileWindow());
        });
        myProfileBtn.fire();

        //signOutBtn
        ToggleButton signOutBtn = new ToggleButton("Sign Out");

        //CreateTaskButton
        Button createTaskButton = new Button("Create Task");
        createTaskButton.setPrefHeight(40);
        createTaskButton.setPrefWidth(150);
        createTaskButton.setTextFill(Color.WHITE);
        createTaskButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)");
        createTaskButton.setOnAction(e ->
        {
            CreateTaskWindow.openWindow();
        });

        //tophbox get children
        topHBox.getChildren().addAll(headLine, createTaskButton);

        //topvbox get children
        topVBox.getChildren().addAll(topHBox, buttonBox);
    }

    public static TableView matchesTable() {
        TableView matchesTable = new TableView();

        matchesTable.setPrefWidth(400);
        TableColumn jobDescription = new TableColumn("Job description");
        TableColumn buyerDescription = new TableColumn("Controller.Buyer description");
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
}
