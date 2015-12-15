package GUI;

import Model.Location;
import Model.Seller;
import DatabaseController.DBHandlerLocation;
import DatabaseController.DBHandlerSeller;
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
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by roije on 04/12/2015.
 */
public class EditSellerProfile
{
    public static void openWindow()
    {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(#42C0FB, #236B8E) ");
        Stage window = new Stage();
        Scene scene = new Scene(root, 650, 620);
        window.setScene(scene);

        //Header label
        Label headLine = new Label("Edit Account");
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        headLine.setEffect(r);
        headLine.setTextFill(Color.GHOSTWHITE);
        headLine.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        //Add headline
        VBox topVBox = new VBox();
        topVBox.getChildren().addAll(headLine);
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

        Label fillInformationerrorLabel = new Label("Fill all text fields before editing profile");
        fillInformationerrorLabel.setTextFill(Color.RED);
        Label passwordNotSame = new Label("Passwords must be the same before editing profile");
        passwordNotSame.setTextFill(Color.RED);
        Label fillAllFields = new Label("Please fill ALL fields before editing profile");
        fillAllFields.setTextFill(Color.RED);

        //Input fields
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        DatePicker birthdateField = new DatePicker();
        birthdateField.setPrefWidth(312);
        TextField emailField = new TextField();
        emailField.setEditable(false);
        PasswordField passwordField = new PasswordField();
        PasswordField confirmPasswordField = new PasswordField();
        TextField cityField = new TextField();
        cityField.setEditable(false);
        cityField.setPrefWidth(160);
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

        ComboBox locationCombo = new ComboBox();
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

        //Update button
        Button updateButton = new Button("Update account");
        updateButton.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        updateButton.setTextFill(Color.WHITE);
        updateButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)");
        updateButton.setOnMouseEntered(e -> updateButton.setStyle("-fx-background-color: linear-gradient(#240e10, #006600)"));
        updateButton.setOnMouseExited(event -> updateButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)"));
        updateButton.setPrefWidth(150);
        updateButton.setPrefHeight(50);
        updateButton.setOnAction(e ->
        {
            if (!passwordField.getText().equals(confirmPasswordField.getText()))
            {
                root.setBottom(passwordNotSame);
            }
            else
            {
                try
                {
                    int carpenterInt = DBHandlerSeller.checkSelected(carpenterCheck);
                    int janitorInt = DBHandlerSeller.checkSelected(janitorCheck);
                    int cleanerInt = DBHandlerSeller.checkSelected(cleanerCheck);
                    int waiterInt = DBHandlerSeller.checkSelected(waiterCheck);
                    int chefInt = DBHandlerSeller.checkSelected(chefCheck);
                    int bartenderInt = DBHandlerSeller.checkSelected(bartenderCheck);
                    int storeInt = DBHandlerSeller.checkSelected(storeCheck);
                    int retailInt = DBHandlerSeller.checkSelected(retailCheck);
                    int pedaInt = DBHandlerSeller.checkSelected(pedagogueCheck);

                    DBHandlerSeller.updateSellerProfile(emailField, firstNameField, lastNameField, birthdateField, passwordField,
                            locationCombo, carpenterInt, janitorInt, cleanerInt,  waiterInt,
                            chefInt, bartenderInt, storeInt, retailInt, pedaInt);
                    window.close();
                }
                catch(NullPointerException e1)
                {
                    root.setBottom(fillAllFields);
                }
            }

        });


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

        //VBox with all information labels.
        VBox labelVBox = new VBox();
        labelVBox.getChildren().addAll(firstNameLabel,lastNameLabel,birthdateLabel, emailLabel, enterPasswordLabel,
                confirmPasswordLabel, qualificationsLabel, locationLabel, cityLabel);
        labelVBox.setSpacing(22);

        //VBox with all input fields
        VBox inputVBox = new VBox();
        inputVBox.getChildren().addAll(firstNameField, lastNameField, birthdateField, emailField, passwordField,
                confirmPasswordField, allCheckRows, locationCombo, cityField, updateButton);
        inputVBox.setSpacing(15);

        HBox centerHBox = new HBox();
        centerHBox.getChildren().addAll(labelVBox, inputVBox);
        centerHBox.setSpacing(10);
        centerHBox.setPadding(new Insets(5,0,0,130));

        ResultSet rs2 = DBHandlerSeller.getUserInformationForEdit();
        try
        {
            while (rs2.next())
            {
                Seller seller = new Seller();
                seller.setFirstName(rs2.getString("firstName"));
                seller.setLastName(rs2.getString("lastName"));
                seller.setBirthday(rs2.getString("birthday"));
                seller.setEmail(rs2.getString("email"));
                seller.setPassword(rs2.getString("password"));
                seller.setQualiCarpenter(rs2.getInt("qualiCarpenter"));
                seller.setQualiJanitor(rs2.getInt("qualiJanitor"));
                seller.setQualiCleaner(rs2.getInt("qualiCleaner"));
                seller.setQualiWaiter(rs2.getInt("qualiWaiter"));
                seller.setQualiChef(rs2.getInt("qualiChef"));
                seller.setQualiBartender(rs2.getInt("qualiBartender"));
                seller.setQualiStore(rs2.getInt("qualiStore"));
                seller.setQualiRetail(rs2.getInt("qualiRetail"));
                seller.setQualiPeda(rs2.getInt("qualiPeda"));
                seller.setLocation(rs2.getString("location"));

                birthdateField.setValue(LocalDate.parse(seller.getBirthday().toString()));
                firstNameField.setText(seller.getFirstName());
                lastNameField.setText(seller.getLastName());
                emailField.setText(seller.getEmail());
                passwordField.setText(seller.getPassword());
                birthdateField.setValue(LocalDate.parse(seller.getBirthday()));
                locationCombo.setValue(seller.getLocation());
                cityField.setText(DBHandlerLocation.setCity(locationCombo.getValue().toString()));
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
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        root.setCenter(centerHBox);

        window.show();

    }
}
