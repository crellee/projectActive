package GUI;

import Controller.InputValidator;
import Controller.Location;
import Controller.Qualification;
import Database.DBHandlerLocation;
import Database.DBHandlerQualification;
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
    public static void openWindow() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(#42C0FB, #236B8E) ");
        Stage window = new Stage();
        Scene scene = new Scene(root, 700, 630);
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
        Label numOfDaysLabel = new Label("Number of days");
        numOfDaysLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label numberOfHoursPrDayLabel = new Label("Number of working hours");
        numberOfHoursPrDayLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label cellNumberLabel = new Label("Phone number");
        cellNumberLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        Label errorMessage = new Label();
        errorMessage.setTextFill(Color.RED);
        errorMessage.setFont(Font.font("Verdana", 13));

        //input fields
        TextField jobDescriptionField = new TextField();
        jobDescriptionField.setOnMouseClicked(e -> errorMessage.setText(""));
        ComboBox locationCombo = new ComboBox<>();
        locationCombo.setPrefWidth(200);
        locationCombo.setOnMouseClicked(e -> errorMessage.setText(""));
        TextField cityField = new TextField();
        ComboBox requiredQualificationCombo = new ComboBox<>();
        requiredQualificationCombo.setPrefWidth(200);
        requiredQualificationCombo.setOnMouseClicked(e -> errorMessage.setText(""));
        TextField salaryField = new TextField();
        salaryField.setOnMouseClicked(e -> errorMessage.setText(""));
        DatePicker fromDatePicker = new DatePicker();
        fromDatePicker.setPrefWidth(200);
        fromDatePicker.setOnMouseClicked(e -> errorMessage.setText(""));
        DatePicker toDatePicker = new DatePicker();
        toDatePicker.setPrefWidth(200);
        toDatePicker.setOnMouseClicked(e -> errorMessage.setText(""));
        TextField numOfDaysField = new TextField();
        numOfDaysField.setEditable(false);
        TextField numberOfHoursPrDayField = new TextField();
        numberOfHoursPrDayField.setOnMouseClicked(e -> errorMessage.setText(""));
        TextField cellNumberField = new TextField();
        cellNumberField.setOnMouseClicked(e -> errorMessage.setText(""));

        //combox required qualifications og database connector
        ResultSet rs1 = DBHandlerQualification.getQualificationName();
        ObservableList<String> data1 = FXCollections.observableArrayList();
        try {
            while (rs1.next())
            {
                Qualification qualification = new Qualification();
                qualification.setQualificationName(rs1.getString("qualificationName"));
                data1.add(qualification.getQualificationName());

            }
        } catch (Exception e)
        {

        }
        requiredQualificationCombo.getItems().addAll(data1);

        //combobox location & city databse connector

        ResultSet rs2 = DBHandlerLocation.getPostNumbers();
        ObservableList<String> data2 = FXCollections.observableArrayList();
        try
        {
            while (rs2.next())
            {
                Location location = new Location();
                location.setPostNo(rs2.getString("postNo"));
                data2.add(location.getPostNo());
            }
        }
        catch (Exception e)
        {

        }
        locationCombo.getItems().addAll(data2);

        locationCombo.setOnAction(e ->
        {
            String no = locationCombo.getValue().toString();
            cityField.setText(DBHandlerLocation.setCity(no));
        });

        //get number of working days

        /*
http://stackoverflow.com/questions/25753727/javafx-using-date-picker
         */

        fromDatePicker.setOnAction( e ->
        {
            try
            {
                long date1 = fromDatePicker.getValue().toEpochDay();
                long date2 = toDatePicker.getValue().toEpochDay();
                int daysInt = 1 + (int) Math.abs(date1 - date2);
                String daysStr = Integer.toString(daysInt);
                numOfDaysField.setText(daysStr);
            }
            catch(NullPointerException e1)
            {
            }
        });

        toDatePicker.setOnAction( e ->
        {
            try
            {

                long date1 = fromDatePicker.getValue().toEpochDay();
                long date2 = toDatePicker.getValue().toEpochDay();
                int daysInt = 1 + (int) Math.abs(date1 - date2);
                String daysStr = Integer.toString(daysInt);
                numOfDaysField.setText(daysStr);
            }
            catch(NullPointerException e1)
            {
            }
        });



        //create button
        Button createButton = new Button("Create task");
        createButton.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        createButton.setTextFill(Color.WHITE);
        createButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)");
        createButton.setPrefWidth(150);
        createButton.setPrefHeight(50);
        createButton.setOnMouseEntered(e -> createButton.setStyle("-fx-background-color: linear-gradient(#240e10, #006600)"));
        createButton.setOnMouseExited(event -> createButton.setStyle("-fx-background-color: linear-gradient(#00e500, #006600)"));
        createButton.setOnAction(e ->
        {
            if(jobDescriptionField.getText().equals("") || cityField.getText().equals("") ||
                    requiredQualificationCombo.getValue().toString().equals("") || salaryField.getText().equals("") ||
                    fromDatePicker.getValue().toString().equals("") || toDatePicker.getValue().toString().equals("") ||
                    numOfDaysField.getText().equals("") || numberOfHoursPrDayField.getText().equals("") ||
                    cellNumberField.getText().equals(""))
            {
                errorMessage.setText("Please fill all fields");
            }
            else if(InputValidator.validDates(fromDatePicker, toDatePicker) == false)
            {
                errorMessage.setText("Start date is after end date");
            }
            else if(cellNumberField.getLength() != 8)
            {
                errorMessage.setText("Phone number too short");

            }
            else
            {
                try
                {
                    DBHandlerTask.saveTask(jobDescriptionField, locationCombo, requiredQualificationCombo, salaryField, fromDatePicker,
                            toDatePicker, numOfDaysField, numberOfHoursPrDayField, cellNumberField);
                    window.close();
                } catch (NullPointerException e1)
                {
                    errorMessage.setText("dfdsf");
                }
                catch (NumberFormatException e2)
                {
                    errorMessage.setText("CVR must be numbers");
                }
            }

        });

        //VBox m labels
        VBox labelVBox = new VBox();
        labelVBox.getChildren().addAll(jobDescriptionLabel, locationLabel, cityLabel, requiredQualificationLabel, salaryLabel,
                fromDateLabel, toDateLabel, numOfDaysLabel, numberOfHoursPrDayLabel, cellNumberLabel);
        labelVBox.setSpacing(24);

        //VBox med input fields
        VBox fieldVBox = new VBox();
        fieldVBox.getChildren().addAll(jobDescriptionField, locationCombo, cityField, requiredQualificationCombo, salaryField,
                fromDatePicker, toDatePicker, numOfDaysField, numberOfHoursPrDayField, cellNumberField, createButton, errorMessage);
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
