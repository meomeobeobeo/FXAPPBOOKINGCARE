package com.ui.bookingappui;

import com.ui.bookingappui.function.Help;
import com.ui.bookingappui.function.SQLconnect;
import com.ui.bookingappui.model.patients;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class patientDetailControl implements Initializable {

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
    private final ObservableList<String> list_age = FXCollections.observableArrayList(new Help().initialAge());
    private final ObservableList<String> genderList = FXCollections.observableArrayList("Nam", "Nữ");
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
        nameEdit.setText(name.getText());
        addressEdit.setText(address.getText());
        phone_number_edit.setText(phone_number_edit.getText());
        email_edit.setText(mail.getText());


    }

    @FXML
    void clearCurrentData(ActionEvent event) throws IOException, SQLException {
        SQLconnect sqLconnect = new SQLconnect();
        sqLconnect.connect();
        PreparedStatement preparedStatement = sqLconnect.getConnection().prepareStatement("delete from patients where id = ?");
        preparedStatement.setString(1,id.getText());
        preparedStatement.execute();
        System.out.println("delete success ...");
        backToDashBoard(event);
    }

    @FXML
    void editAction(ActionEvent event) throws SQLException, IOException {
        SQLconnect sqLconnect = new SQLconnect();
        sqLconnect.connect();
        PreparedStatement preparedStatement = sqLconnect.getConnection()
                                .prepareStatement("update patients set namePatient = ?,addressPatient = ? , phone_number = ? , email = ? , gender = ? , age = ? where id = ?");
        preparedStatement.setString(1,nameEdit.getText());
        preparedStatement.setString(2,addressEdit.getText());
        preparedStatement.setString(3,phone_number_edit.getText());
        preparedStatement.setString(4,email_edit.getText());
        preparedStatement.setString(5,gender_edit.getValue());
        preparedStatement.setString(6,age_edit.getValue());
        preparedStatement.setString(7,id.getText());
        preparedStatement.execute();
        System.out.println("update data success.");
        backToDashBoard(event);


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        age_edit.setItems(list_age);
        gender_edit.setItems(genderList);
    }
}
