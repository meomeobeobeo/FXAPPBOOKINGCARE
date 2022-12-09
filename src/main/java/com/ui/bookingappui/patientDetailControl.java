package com.ui.bookingappui;

import com.ui.bookingappui.model.patients;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class patientDetailControl {

    @FXML
    private Label address;

    @FXML
    private Label mail;

    @FXML
    private Label gender;

    @FXML
    private ComboBox<String> gender_edit;

    @FXML
    private Label phoneNumber;

    @FXML
    private Label name;

    @FXML
    private Label id;

    @FXML
    private TextField nameEdit;

    @FXML
    private TextField phone_number_edit;

    @FXML
    private ComboBox<String> age_edit;

    @FXML
    private Label age;

    @FXML
    private TextField addressEdit;

    @FXML
    private TextField email_edit;
    @FXML
    private void backToDashBoard(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader main = new FXMLLoader(Objects.requireNonNull(getClass().getResource("dashBoard.fxml")));
        Parent mainPage = main.load();
        Scene mainScene = new Scene(mainPage, 1024, 576);
        mainScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("dashBoard.css")).toExternalForm());
        stage.setScene(mainScene);
        stage.show();
    }

    @FXML
    void editPatientInfor(ActionEvent event) {

    }

    @FXML
    void clearCurrentData(ActionEvent event) {

    }

    @FXML
    void editAction(ActionEvent event) {

    }
    @FXML
    public void setValueDetail(patients patient){
        name.setText(patient.getNamePatient());
        id.setText(patient.getId());
        address.setText(patient.getAddressPatient());
        age.setText(Integer.toString(patient.getAge()));
        phoneNumber.setText(patient.getPhone_number());
        mail.setText(patient.getEmail());
        gender.setText(patient.getGender());


    }

}
