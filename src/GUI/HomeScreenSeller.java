package GUI;

import Controller.Seller;
import Controller.Task;
import Database.DBHandlerLocation;
import Database.DBHandlerSeller;
import Database.DBHandlerTask;
import Diagrams.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
import java.util.Optional;

/**
 * Created by christianhasselstrom on 01/12/2015.
 */
public class HomeScreenSeller {

    public static void homeScreenSeller() {
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
        Label requestTaskLbl = new Label("Double click to request task");

        sellersBtn.setPrefHeight(20);
        sellersBtn.setPrefWidth(100);
        sellersBtn.setFont(Font.font("Verdana"));
        sellersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        buttonBox.getChildren().add(sellersBtn);
        sellersBtn.setOnAction(e ->
        {
            requestTaskLbl.setVisible(false);
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
            requestTaskLbl.setVisible(false);
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
            requestTaskLbl.setVisible(true);
            sellersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            buyersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            tasksBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            myProfileBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            matchesBtn.setStyle("-fx-background-color: linear-gradient(#279dc4, #a7d9f5)");
            root.setCenter(MatchesTableSeller.matchesTable());
        });

        //taskBtn
        tasksBtn.setPrefHeight(20);
        tasksBtn.setPrefWidth(100);
        tasksBtn.setFont(Font.font("Verdana"));
        tasksBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        buttonBox.getChildren().add(tasksBtn);
        tasksBtn.setOnAction(e ->
        {
            requestTaskLbl.setVisible(false);
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
            requestTaskLbl.setVisible(false);
            sellersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            buyersBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            matchesBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            tasksBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
            myProfileBtn.setStyle("-fx-background-color: linear-gradient(#279dc4, #a7d9f5)");
            root.setCenter(MyProfileSeller.myProfileWindow());
        });
        myProfileBtn.fire();

        //accceptBtn attributes
        requestTaskLbl.setPrefHeight(20);
        requestTaskLbl.setPrefWidth(190);
        requestTaskLbl.setTextFill(Color.WHITE);
        requestTaskLbl.setFont(Font.font("Verdana"));
        requestTaskLbl.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)");
        requestTaskLbl.setVisible(false);

        VBox accBox = new VBox();
        accBox.setPadding(new Insets(0,0,0,550));
        accBox.getChildren().add(requestTaskLbl);
        buttonBox.getChildren().add(accBox);

        //Task task = MatchesTableSeller.matchesTable().getSelectionModel().getSelectedItem();


        //signOutBtn
        ToggleButton signOutBtn = new ToggleButton("Sign Out");


        //tophbox get children
        topHBox.getChildren().add(headLine);

        //topvbox get children
        topVBox.getChildren().addAll(topHBox, buttonBox);
    }

    public static void alertWindow(String description)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Request Task");
        alert.setHeaderText("Do you want to request this task?");
        alert.setContentText("Press OK to request.");

        ButtonType buttonTypeOk = new ButtonType("OK");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOk, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOk)
        {
            DBHandlerTask.updateSetRequest(description);
            System.out.print("Pressed OK");
        } else
        {

        }
    }

    public static void ratingWindow(String businesssName, String jobDescription)
    {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(#42C0FB, #236B8E) ");

        Stage window = new Stage();
        Scene scene = new Scene(root, 400, 250);
        window.setScene(scene);
        window.setResizable(false);

        Label topLabel = new Label("Rate " + businesssName);
        topLabel.setPadding(new Insets(10,0,0,10));
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        topLabel.setEffect(r);
        topLabel.setTextFill(Color.GHOSTWHITE);
        topLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        Label centerLabel = new Label("Give rating from 1-9: ");
        topLabel.setTextFill(Color.GHOSTWHITE);
        topLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        ComboBox ratingCombo = new ComboBox();
        ratingCombo.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
        ratingCombo.setPrefWidth(100);

        Button rateButton = new Button("Rate!");
        rateButton.setTextFill((Color.GHOSTWHITE));
        rateButton.setFont(Font.font("Verdana"));
        rateButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)");
        rateButton.setOnMouseEntered(e -> rateButton.setStyle("-fx-background-color: linear-gradient(#240e10, #006600)"));
        rateButton.setOnMouseExited(event -> rateButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)"));
        rateButton.setOnAction(e ->
        {
            DBHandlerTask.setNewBuyerRating(businesssName, ratingCombo, jobDescription);
        });


        HBox centerHBox = new HBox();
        centerHBox.setPadding(new Insets(40,0,0,10));
        centerHBox.getChildren().addAll(centerLabel, ratingCombo, rateButton);

        root.setTop(topLabel);
        root.setCenter(centerHBox);


        window.show();
    }
}
