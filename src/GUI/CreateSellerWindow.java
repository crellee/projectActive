package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by roije on 25/11/2015.
 */
public class CreateSellerWindow
{
    public static void openWindow()
    {
        BorderPane root = new BorderPane();
        Stage window = new Stage();
        Scene scene = new Scene(root, 600, 600);
        window.setScene(scene);

        //Labels fields
        Label firstNameLabel = new Label("First name:");
        Label lastNameLabel = new Label("Last name:");
        Label birthdateLabel = new Label("Birthday:");
        Label emailLabel = new Label("Email:");
        Label enterPasswordLabel = new Label("Enter password:");
        Label confirmPasswordLabel = new Label("Confirm password:");
        Label qualificationsLabel = new Label("Qualifications:");
        Label locationLabel = new Label("Postal code: ");

        //Input fields
        TextField firstNameText = new TextField();
        TextField lastNameText = new TextField();
        DatePicker birthdayField = new DatePicker();
        TextField emailText = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField confirmPasswordField = new PasswordField();
        ComboBox<String> qualificationsCombo = new ComboBox<>();
        qualificationsCombo.setPrefWidth(200);
        ComboBox<String> locationCombo = new ComboBox<>();

        VBox labelVBox = new VBox();
        labelVBox.getChildren().addAll(firstNameLabel,lastNameLabel,birthdateLabel, emailLabel, enterPasswordLabel,
                confirmPasswordLabel, qualificationsLabel, locationLabel);
        labelVBox.setSpacing(11);

        VBox inputVBox = new VBox();
        inputVBox.getChildren().addAll(firstNameText, lastNameText, birthdayField, emailText, passwordField,
                confirmPasswordField, qualificationsCombo, locationCombo);

        HBox centerHBox = new HBox();
        centerHBox.getChildren().addAll(labelVBox, inputVBox);
        centerHBox.setPadding(new Insets(70,0,0,50));

        root.setCenter(centerHBox);

        window.show();
    }
}
