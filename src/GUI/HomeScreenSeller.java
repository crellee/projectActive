package GUI;

import Controller.Seller;
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
import javafx.scene.layout.Border;
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


        //tophbox get children
        topHBox.getChildren().add(headLine);

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

    public static TableView matchesTable() {
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

    public static TableView tasksTable() {
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

    public static BorderPane myProfileWindow() {



        //GUI Seller

        BorderPane rootMyProfileSeller = new BorderPane();
        //Scene scene2 = new Scene(rootMyProfileSeller, 1280, 700, Color.LIGHTBLUE);
        rootMyProfileSeller.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #bfeef4, #bfeef4)");


        //VBox and HBox
        HBox profilHBox = new HBox(10);                 // Center BorderPane
        profilHBox.setPadding(new Insets(20, 10, 10, 20));
        VBox profilVBox = new VBox(5);                  //Left BorderPane
        profilVBox.setPadding(new Insets(50, 0, 10, 30));
        VBox vboxFirstname = new VBox();
        vboxFirstname.setPadding(new Insets(0,20,0,0));
        VBox vboxLastname = new VBox();
        VBox vboxButton = new VBox();
        vboxButton.setPadding(new Insets(400, 0, 0, 0));
        VBox vboxCombobox = new VBox(10);
        vboxCombobox.setPadding(new Insets(30, 30, 30, 100));


        // Separator
        Separator separator = new Separator();
        InnerShadow innerShadow = new InnerShadow();
        separator.setEffect(innerShadow);
        separator.setOrientation(Orientation.VERTICAL);
        separator.setMaxHeight(550);
        separator.setPadding(new Insets(20, 10, 20, 10));

        //Labels, Buttons
        Button buttonUpdate = new Button("Save Profil");
        buttonUpdate.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        buttonUpdate.setTextFill(Color.WHITE);
        buttonUpdate.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)");
        buttonUpdate.setPrefWidth(150);
        buttonUpdate.setPrefHeight(50);

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
        Label ageLabel = new Label("");
        Label mailLabel = new Label("");
        Label cityLabel = new Label("");
        Label locationLabel = new Label("");
        Label chefLabel = new Label();


        //Picture
        Image img = new Image("http://www.fscspatriots.org/wp-content/uploads/2014/12/no_photo_available-male.jpg");
        ImageView imageview = new ImageView(img);
        imageview.setFitHeight(232.6);
        imageview.setFitWidth(172.5);

        //CheckBox
        CheckBox carpenterCheck = new CheckBox("Carpenter");
        carpenterCheck.setDisable(true);
        carpenterCheck.setStyle("-fx-opacity: 1");
        CheckBox janitorCheck = new CheckBox("Janitor");
        janitorCheck.setDisable(true);
        janitorCheck.setStyle("-fx-opacity: 1");
        CheckBox cleanerCheck = new CheckBox("Cleaner");
        cleanerCheck.setDisable(true);
        cleanerCheck.setStyle("-fx-opacity: 1");
        CheckBox waiterCheck = new CheckBox("Waiter");
        waiterCheck.setDisable(true);
        waiterCheck.setStyle("-fx-opacity: 1");
        CheckBox chefCheck = new CheckBox("Chef");
        chefCheck.setDisable(true);
        chefCheck.setStyle("-fx-opacity: 1");
        CheckBox bartenderCheck = new CheckBox("Bartender");
        bartenderCheck.setDisable(true);
        bartenderCheck.setStyle("-fx-opacity: 1");
        CheckBox storeCheck = new CheckBox("Store employee");
        storeCheck.setDisable(true);
        storeCheck.setStyle("-fx-opacity: 1");
        CheckBox retailCheck = new CheckBox("Retail");
        retailCheck.setDisable(true);
        retailCheck.setStyle("-fx-opacity: 1");
        CheckBox pedagogueCheck = new CheckBox("Pedagogue");
        pedagogueCheck.setDisable(true);
        pedagogueCheck.setStyle("-fx-opacity: 1");



        //Tilføjelser til HBox, VBox og Borderpane
        ///////////////////////////////////////////
        vboxFirstname.getChildren().addAll(name, ageLabel, mailLabel, cityLabel, locationLabel, chefLabel);
        vboxLastname.getChildren().addAll(lastName);
        vboxCombobox.getChildren().addAll(carpenterCheck, janitorCheck, cleanerCheck, waiterCheck, chefCheck, bartenderCheck,
                storeCheck, retailCheck, pedagogueCheck);
        vboxButton.getChildren().add(buttonUpdate);
        profilVBox.getChildren().addAll(imageview);
        profilHBox.getChildren().addAll(separator, vboxFirstname, vboxLastname, ratingLabel, rating, vboxCombobox, vboxButton);
        rootMyProfileSeller.setCenter(profilHBox);
        rootMyProfileSeller.setLeft(profilVBox);

        /*
        buttonUpdate.setOnAction(e -> {


        });
        */


        ResultSet rs = DBHandlerSeller.getFirstName();
        try {
            while (rs.next()) {
                Seller seller = new Seller();
                seller.setFirstName(rs.getString("firstName"));
                seller.setLastName(rs.getString("lastName"));
                seller.setAge(rs.getInt("age"));
                seller.setEmail(rs.getString("email"));
                seller.setRating(rs.getDouble("rating"));
                seller.setCity(rs.getString("city"));
                seller.setLocation(rs.getString("location"));
                seller.setQualiCarpenter(rs.getInt("qualiCarpenter"));
                seller.setQualiJanitor(rs.getInt("qualiJanitor"));
                seller.setQualiCleaner(rs.getInt("qualiCleaner"));
                seller.setQualiWaiter(rs.getInt("qualiWaiter"));
                seller.setQualiChef(rs.getInt("qualiChef"));
                seller.setQualiBartender(rs.getInt("qualiBartender"));
                seller.setQualiStore(rs.getInt("qualiStore"));
                seller.setQualiRetail(rs.getInt("qualiRetail"));
                seller.setQualiPeda(rs.getInt("qualiPeda"));


                name.setText(seller.getFirstName());
                lastName.setText(seller.getLastName());
                ageLabel.setText("age" + Integer.toString(seller.getAge()));
                mailLabel.setText(seller.getEmail());
                rating.setText(Double.toString(seller.getRating()));
                cityLabel.setText(seller.getCity());
                locationLabel.setText(seller.getLocation());

                //qualiCarpenter, qualiJanitor, qualiCleaner, qualiWaiter," +
                //"qualiChef, qualiBartender, qualiStore, qualiRetail, qualiPeda


                if(seller.getQualiCarpenter() == 1)
                {
                    carpenterCheck.setSelected(true);
                }

                if(seller.getQualiJanitor() == 1)
                {
                    janitorCheck.setSelected(true);
                }

                if(seller.getQualiCleaner() == 1)
                {
                    cleanerCheck.setSelected(true);
                }

                if(seller.getQualiWaiter() == 1)
                {
                    waiterCheck.setSelected(true);
                }

                if(seller.getQualiChef() == 1)
                {
                    chefCheck.setSelected(true);
                }

                if(seller.getQualiBartender() == 1)
                {
                    bartenderCheck.setSelected(true);
                }

                if(seller.getQualiStore() == 1)
                {
                    storeCheck.setSelected(true);
                }

                if(seller.getQualiRetail() == 1)
                {
                    retailCheck.setSelected(true);
                }

                if(seller.getQualiPeda() == 1)
                {
                    pedagogueCheck.setSelected(true);
                }



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rootMyProfileSeller;
    }


}
