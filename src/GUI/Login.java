package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by christianhasselstrom on 25/11/2015.
 */
public class Login
{
    BorderPane borderRoot;
    Stage window;
    HBox loginHBox;
    Button loginButton;
    TextField loginTextfield;
    PasswordField passwordField;


    public void loginZ()
    {
        borderRoot = new BorderPane();
        Scene sceneLogin = new Scene(borderRoot, 600, 600);
        window.setScene(sceneLogin);

        loginHBox = new HBox();

        loginButton = new Button("Login");

        loginTextfield = new TextField();
        passwordField = new PasswordField();


        loginHBox.setSpacing(10);
        borderRoot.setTop(loginHBox);
        loginHBox.setPrefWidth(600);

        loginHBox.getChildren().addAll(loginTextfield, passwordField, loginButton);
        borderRoot.getChildren().addAll(loginHBox);

        window.show();
    }
}
