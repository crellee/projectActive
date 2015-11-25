package GUI;

import Database.DBHandlerBuyer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by christianhasselstrom on 25/11/2015.
 */
public class CreateBuyerWindow
{
    public static void openWindow()
    {
        BorderPane root = new BorderPane();
        Stage window = new Stage();
        Scene scene = new Scene(root, 600, 600);
        window.setScene(scene);

        //Label fields
        Label firstNameLabel = new Label("First Name");
        Label lastNameLabel = new Label("Last Name");
        Label businessNameLabel = new Label("Business Name");
        Label businessEmailLabel = new Label("Business Email");
        Label enterPasswordLabel = new Label("Enter Password");
        Label confirmPasswordLabel = new Label("Confirm Password");
        Label locationLabel = new Label("Postal code: ");
        Label cityLabel = new Label("City");
        Label cvrNoLabel = new Label("Enter CVR-Number");
        Label fillInformationerrorLabel = new Label("Fill all text fields before creating profile");
            fillInformationerrorLabel.setTextFill(Color.RED);
        Label passwordNotSame = new Label("Passwords must be the same before creating profile");
            passwordNotSame.setTextFill(Color.RED);

        //Input fields
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField businessNameField = new TextField();
        TextField businessEmailField = new TextField();
        PasswordField enterPasswordField = new PasswordField();
        PasswordField confirmPasswordField = new PasswordField();
        ComboBox locationCombo = new ComboBox<>();
            locationCombo.getItems().addAll("2100", "2200", "2300", "2400", "2450", "2500");
            locationCombo.setPrefWidth(200);
        TextField cityField = new TextField();
        TextField cvrNoField = new TextField();

        //Create Button
        Button createButton = new Button("Create");
        createButton.setOnAction(e ->
        {
            if(firstNameField.getText().equals("") || lastNameField.getText().equals("") ||
                    businessEmailField.getText().equals("") || enterPasswordField.getText().equals("") ||
                    confirmPasswordField.getText().equals("") || locationCombo.getValue().toString().equals("") ||
                    cityField.getText().equals("") || cvrNoField.getText().equals(""))
            {
                root.setBottom(fillInformationerrorLabel);
            }
            else if (!enterPasswordField.getText().equals(confirmPasswordField.getText()))
            {
                root.setBottom(passwordNotSame);
            }

            else
            {
                DBHandlerBuyer.saveBuyer(firstNameField, lastNameField, businessNameField, businessEmailField,
                        enterPasswordField, locationCombo, cityField, cvrNoField);
                window.close();
                HomeScreen.homeScreen();
            }
        });

        //Tilføjer til HBox VBox & BorderPane

        VBox labelVBox = new VBox();
        labelVBox.getChildren().addAll(firstNameLabel,lastNameLabel,businessNameLabel, businessEmailLabel, enterPasswordLabel,
                confirmPasswordLabel, locationLabel, cityLabel, cvrNoLabel);
        labelVBox.setSpacing(11);

        VBox inputVBox = new VBox();
        inputVBox.getChildren().addAll(firstNameField, lastNameField, businessNameField, businessEmailField,
                enterPasswordField, confirmPasswordField, locationCombo, cityField, cvrNoField, createButton);

        HBox centerHBox = new HBox();
        centerHBox.getChildren().addAll(labelVBox, inputVBox);
        centerHBox.setPadding(new Insets(70,0,0,50));

        root.setCenter(centerHBox);


        window.show();
    }
}
