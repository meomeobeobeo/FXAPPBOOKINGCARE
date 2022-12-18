package com.ui.bookingappui;

import com.ui.bookingappui.function.Help;
import com.ui.bookingappui.function.SQLconnect;
import com.ui.bookingappui.model.doctors;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class doctorDetailControl implements Initializable {
    @FXML
    private Label doctorLevel;

    @FXML
    private Label mail;

    @FXML
    private Label gender;

    @FXML
    private TextArea description_doctor_edit;

    @FXML
    private Label doctorWorkAs;

    @FXML
    private TextField name_doctor_edit;

    @FXML
    private TextField phone_number_doctor_edit;

    @FXML
    private TextField email_doctor_edit;

    @FXML
    private Label description;

    @FXML
    private ComboBox<String> work_special_doctor_edit;

    @FXML
    private ComboBox<String> level_doctor_edit;

    @FXML
    private Label phoneNumber;

    @FXML
    private Label name;

    @FXML
    private ComboBox<String> age_doctor_edit;

    @FXML
    private Label id;

    @FXML
    private Label age;

    @FXML
    private ComboBox<String> gender_doctor_edit;
    private final ObservableList<String> list_age = FXCollections.observableArrayList(new Help().initialAge());
    private final ObservableList<String> genderList = FXCollections.observableArrayList("Nam", "Nữ");
    private final ObservableList<String> list_work_special = FXCollections.observableArrayList(
            "Não và thần kinh",
            "Phẫu thuật chỉnh hình",
            "U bướu",
            "Nhi",
            "Tai mũi họng",
            "Mắt",
            "Khoa ngoại tổng hợp",
            "Tim mạch",
            "Nội tiết",
            "Thận",
            "Phổi",
            "Khoa tiêu hóa",
            "Khoa tiết niệu",
            "Phụ sản",
            "Nha khoa"
    );
    private final ObservableList<String> list_level = FXCollections.observableArrayList("Thạc sĩ", "Phó giáo sư", "Giáo sư");

    @FXML
    void editDoctorAction(ActionEvent event) {
        name_doctor_edit.setText(name.getText());
        phone_number_doctor_edit.setText(phoneNumber.getText());
        email_doctor_edit.setText(mail.getText());
        description_doctor_edit.setText(description.getText());
        level_doctor_edit.setValue(doctorLevel.getText());
        age_doctor_edit.setValue(age.getText());
        work_special_doctor_edit.setValue(doctorWorkAs.getText());
        gender_doctor_edit.setValue(gender.getText());

    }

    @FXML
    void clearCurrentData(ActionEvent event) throws SQLException, IOException {
        SQLconnect sqLconnect = new SQLconnect();
        sqLconnect.connect();
        PreparedStatement preparedStatement = sqLconnect.getConnection().prepareStatement("delete from doctors where id = ?");
        preparedStatement.setString(1,id.getText());
        preparedStatement.execute();
        System.out.println("delete success.....");
        backToDashBoard(event);
    }



    @FXML
    void handle_edit_infor_doctor(ActionEvent event) throws SQLException, IOException {
        SQLconnect sqLconnect = new SQLconnect();
        sqLconnect.connect();
        PreparedStatement preparedStatement = sqLconnect.getConnection().prepareStatement("update doctors set nameDoctor = ? , phone_number = ? , email = ?, gender = ? , age = ? , levelDoctor = ? , work_specialize = ? , descriptionDoctor = ? where id = ?");
        preparedStatement.setString(1,name_doctor_edit.getText());
        preparedStatement.setString(2,phone_number_doctor_edit.getText());
        preparedStatement.setString(3,email_doctor_edit.getText());
        preparedStatement.setString(4,gender_doctor_edit.getValue());
        preparedStatement.setInt(5,Integer.parseInt(age_doctor_edit.getValue()));
        preparedStatement.setString(6,level_doctor_edit.getValue());
        preparedStatement.setString(7,work_special_doctor_edit.getValue());
        preparedStatement.setString(8,description_doctor_edit.getText());
        preparedStatement.setString(9,id.getText());
        preparedStatement.execute();
        System.out.println("update data success.");
        backToDashBoard(event);


    }
    @FXML
    public void setValueDetail(doctors doctor){
        id.setText(doctor.getId());
        name.setText(doctor.getNameDoctor());
        phoneNumber.setText(doctor.getPhone_number());
        mail.setText(doctor.getEmail());
        description.setText(doctor.getDescriptionDoctor());
        gender.setText(doctor.getGender());
        age.setText(Integer.toString(doctor.getAge()));
        doctorLevel.setText(doctor.getLevelDoctor());
        doctorWorkAs.setText(doctor.getWork_specialize());






    }



    @FXML
    void backToDashBoard(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader main = new FXMLLoader(Objects.requireNonNull(getClass().getResource("dashBoard.fxml")));
        Parent mainPage = main.load();
        Scene mainScene = new Scene(mainPage, 1024, 576);
        mainScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("dashBoard.css")).toExternalForm());
        stage.setScene(mainScene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gender_doctor_edit.setItems(genderList);
        level_doctor_edit.setItems(list_level);
        age_doctor_edit.setItems(list_age);
        work_special_doctor_edit.setItems(list_work_special);
    }
}
