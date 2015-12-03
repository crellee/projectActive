package GUI;

import Controller.Buyer;
import Controller.Seller;
import Database.DBHandlerBuyer;
import Database.DBHandlerLocation;
import Database.DBHandlerSeller;
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
        ToggleButton buyersBtn = new ToggleButton("Buyers");
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
        ToggleButton matchesBtn = new ToggleButton("Matches");
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
        ToggleButton tasksBtn = new ToggleButton("Tasks");
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
        ToggleButton myProfileBtn = new ToggleButton("My Profile");
        myProfileBtn.setPrefHeight(20);
        myProfileBtn.setPrefWidth(100);
        myProfileBtn.setFont(Font.font("Verdana"));
        myProfileBtn.setToggleGroup(tGroup);
        myProfileBtn.setStyle("-fx-background-color: linear-gradient(#fafdfe, #a7d9f5)");
        buttonBox.getChildren().add(myProfileBtn);
        myProfileBtn.setOnAction(e ->
        {
            root.setCenter(myProfileWindow());
        });

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

    public static TableView sellersTable() {
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

    public static TableView buyersTable() {
        TableView buyersTable = new TableView();

        buyersTable.setPrefWidth(400);
        TableColumn buyerDescription = new TableColumn("Controller.Buyer description");
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

    public static TableView tasksTable() {
        TableView tasksTable = new TableView();

        tasksTable.setPrefWidth(400);
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

        tasksTable.getColumns().addAll(jobDescription, buyerDescription, location, qualifications, rating, salary);

        return tasksTable;
    }

    public static BorderPane myProfileWindow() {



        //GUI Seller

        BorderPane rootMyProfileBuyer = new BorderPane();
//        Scene scene2 = new Scene(rootMyProfileSeller, 1280, 700, Color.LIGHTBLUE);
        rootMyProfileBuyer.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #bfeef4, #bfeef4)");


        //VBox and HBox
        HBox profilHBox = new HBox(10);                 // Center BorderPane
        profilHBox.setPadding(new Insets(20, 10, 10, 20));
        VBox profilVBox = new VBox(20);                  //Left BorderPane
        profilVBox.setPadding(new Insets(50, 0, 10, 30));
        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();
        VBox vboxButton = new VBox();
        vboxButton.setPadding(new Insets(400, 0, 0, 0));



        // Separator
        Separator separator = new Separator();
        InnerShadow innerShadow = new InnerShadow();
        separator.setEffect(innerShadow);
        separator.setOrientation(Orientation.VERTICAL);
        separator.setMaxHeight(550);
        separator.setPadding(new Insets(20, 10, 20, 10));

        //Labels, Buttons
        Button buttonUpdate = new Button("Edit profile");
        buttonUpdate.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        buttonUpdate.setTextFill(Color.WHITE);
        buttonUpdate.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)");
        buttonUpdate.setPrefWidth(125);
        buttonUpdate.setPrefHeight(25);
        buttonUpdate.setOnAction(e ->
        {
            EditBuyerProfile.openWindow();
        });

        Label name = new Label();
        name.setFont(Font.font("Calibri", FontWeight.BOLD, 35));
        name.setPadding(new Insets(20, 0, 0, 0));
        Label lastName = new Label();
        lastName.setFont(Font.font("Calibri", FontWeight.BOLD, 35));
        lastName.setPadding(new Insets(20, 0, 0, 0));
        Label rating = new Label("");
        rating.setFont(Font.font("Calibri", FontWeight.BOLD, 35));
        rating.setPadding(new Insets(20, 0, 0, 0));
        Label ratingLabel = new Label("              RATING:   ");
        ratingLabel.setPadding(new Insets(27, 0, 0, 0));
        ratingLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 25));
        ratingLabel.setAlignment(Pos.CENTER);
   /*   Label age = new Label("35");
        age.setFont(Font.font("Calibri", FontWeight.b   bb  bBOLD,35));
        age.setPadding(new Insets(30,0,0,0)); */
        Label businessNameLabel = new Label();
        businessNameLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label businessNameLabelLabel = new Label("Business Name:");
        businessNameLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label businessEmailLabel = new Label();
        businessEmailLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label businessEmailLabelLabel = new Label("Business Email:");
        businessEmailLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label postNoLabel = new Label();
        postNoLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label postNoLabelLabel = new Label("Post No:");
        postNoLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label cityLabel = new Label();
        cityLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label cityLabelLabel = new Label("City:");
        cityLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label cvrLabel = new Label();
        cvrLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));
        Label cvrLabelLabel = new Label("CVR No:");
        cvrLabelLabel.setFont(Font.font("Oswald", FontWeight.BOLD, 15));


        //Picture
        Image img = new Image("http://www.fscspatriots.org/wp-content/uploads/2014/12/no_photo_available-male.jpg");
        ImageView imageview = new ImageView(img);
        imageview.setFitHeight(232.6);
        imageview.setFitWidth(172.5);



        //Tilføjelser til HBox, VBox og Borderpane
        ///////////////////////////////////////////
        vBox1.getChildren().addAll(name, businessNameLabelLabel, businessEmailLabelLabel, postNoLabelLabel, cityLabelLabel,
                cvrLabelLabel);
        vBox2.getChildren().addAll(lastName, businessNameLabel, businessEmailLabel, postNoLabel, cityLabel, cvrLabel);
        //vboxButton.getChildren().add(null);
        profilVBox.getChildren().addAll(imageview, buttonUpdate);
        profilHBox.getChildren().addAll(separator, vBox1, vBox2, ratingLabel, rating, vboxButton);


        rootMyProfileBuyer.setCenter(profilHBox);
        rootMyProfileBuyer.setLeft(profilVBox);


        ResultSet rs = DBHandlerBuyer.getUserInformations();
        try {
            while (rs.next()) {
                Buyer buyer = new Buyer();

                buyer.setFirstName(rs.getString("firstName"));
                buyer.setLastName(rs.getString("lastName"));
                buyer.setBusinessName(rs.getString("businessName"));
                buyer.setBusinessEmail(rs.getString("businessEmail"));
                buyer.setLocation(rs.getString("location"));
                buyer.setCvr(rs.getInt("cvr"));
                buyer.setRating(rs.getDouble("rating"));


                name.setText(buyer.getFirstName());
                lastName.setText(buyer.getLastName());
                businessNameLabel.setText(buyer.getBusinessName());
                businessEmailLabel.setText(buyer.getBusinessEmail());
                postNoLabel.setText(buyer.getLocation());
                cityLabel.setText(DBHandlerLocation.setCity(postNoLabel.getText()));
                cvrLabel.setText(Integer.toString(buyer.getCvr()));
                rating.setText(Double.toString(buyer.getRating()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        return rootMyProfileBuyer;
    }
}
