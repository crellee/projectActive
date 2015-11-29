package GUI;

import Controller.Location;
import Database.DBHandlerLocation;
import Database.DBHandlerTask;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.ResultSet;

/**
 * Created by christianhasselstrom on 27/11/2015.
 */
public class CreateTaskWindow
{
    public static void openWindow()
    {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(#42C0FB, #236B8E) ");
        Stage window = new Stage();
        Scene scene = new Scene(root, 700 , 600);
        window.setScene(scene);

        //Headline
        Label headLine = new Label("Create New Task");
        Label emptyLabel = new Label();
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        headLine.setEffect(r);
        headLine.setTextFill(Color.GHOSTWHITE);
        headLine.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        VBox topVBox = new VBox();
        topVBox.setPadding(new Insets(20));
        topVBox.setSpacing(24);
        topVBox.getChildren().addAll(headLine, emptyLabel);
        root.setTop(topVBox);


        //label fields
        Label jobDescriptionLabel = new Label("Job description");
        jobDescriptionLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label locationLabel = new Label("Location");
        locationLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label cityLabel = new Label("City");
        cityLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label requiredQualificationLabel = new Label("Required qualification for the job");
        requiredQualificationLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label salaryLabel = new Label("Salary per hour");
        salaryLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label fromDateLabel = new Label("Work start date");
        fromDateLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label toDateLabel = new Label("Work end date");
        toDateLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label numberOfHoursPrDayLabel = new Label("Number of working hours");
        numberOfHoursPrDayLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label cellNumberLabel = new Label("Phone number");
        cellNumberLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));


        //input fields
        TextField jobDescriptionField = new TextField();
        ComboBox locationCombo = new ComboBox<>();
        locationCombo.setPrefWidth(200);
        TextField cityField = new TextField();
        ComboBox requiredQualificationCombo = new ComboBox<>();
        requiredQualificationCombo.getItems().addAll("hvad", "hvad23");
        requiredQualificationCombo.setPrefWidth(200);
        TextField salaryField = new TextField();
        DatePicker fromDatePicker = new DatePicker();
        fromDatePicker.setPrefWidth(200);
        DatePicker toDatePicker = new DatePicker();
        toDatePicker.setPrefWidth(200);
        TextField numberOfHoursPrDayField = new TextField();
        TextField cellNumberField = new TextField();

        //combobox location & city databse connector

        ResultSet rs = DBHandlerLocation.getPostNumbers();
        ObservableList<String> data = FXCollections.observableArrayList();
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
        locationCombo.getItems().addAll(data);

        locationCombo.setOnAction(e ->
        {
            String no = locationCombo.getValue().toString();
            cityField.setText(DBHandlerLocation.setCity(no));
        });

        //create button
        Button createButton = new Button("Create task");
        createButton.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        createButton.setTextFill(Color.WHITE);
        createButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)");
        createButton.setPrefWidth(150);
        createButton.setPrefHeight(50);
        createButton.setOnAction(e ->
        {
            DBHandlerTask.saveTask(jobDescriptionField, locationCombo, cityField, requiredQualificationCombo, salaryField, fromDatePicker,
                    toDatePicker, numberOfHoursPrDayField, cellNumberField);
            window.close();

        });

        //VBox m labels
        VBox labelVBox = new VBox();
        labelVBox.getChildren().addAll(jobDescriptionLabel, locationLabel, cityLabel, requiredQualificationLabel, salaryLabel,
                fromDateLabel, toDateLabel, numberOfHoursPrDayLabel, cellNumberLabel);
        labelVBox.setSpacing(24);

        //VBox med input fields
        VBox fieldVBox = new VBox();
        fieldVBox.getChildren().addAll(jobDescriptionField, locationCombo, cityField, requiredQualificationCombo, salaryField,
                fromDatePicker, toDatePicker, numberOfHoursPrDayField, cellNumberField, createButton);
        fieldVBox.setSpacing(15);


        //hbox med de to overstående vboxes
        HBox centerHBox = new HBox();
        centerHBox.getChildren().addAll(labelVBox, fieldVBox);
        centerHBox.setSpacing(10);
        centerHBox.setPadding(new Insets(5,0,0,130));

        root.setLeft(centerHBox);


        window.show();
    }
}
