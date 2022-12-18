package com.ui.bookingappui;

import com.ui.bookingappui.function.Help;
import com.ui.bookingappui.function.SQLconnect;
import com.ui.bookingappui.model.doctorSummaryInfor;
import com.ui.bookingappui.model.patientSummaryInfor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class registFormControl implements Initializable {
    @FXML
    private ComboBox<String> doctorId;

    @FXML
    private ComboBox<String> patientId;
    @FXML
    private Label nameDoctor;
    @FXML
    private Label namePatient;
    @FXML
    private TextField moneyPay;

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField timeField;

    private final ObservableList<String> listIdDoctor = FXCollections.observableArrayList();
    private final ObservableList<String> listIdPatient = FXCollections.observableArrayList();
    private ArrayList<patientSummaryInfor> patientSummaryInfors;
    private ArrayList<doctorSummaryInfor> doctorSummaryInfors;

    @FXML
    private void changeDoctorId(ActionEvent e){
        doctorSummaryInfors.forEach((element->{
            if(element.getDoctorId() == doctorId.getValue()){
                nameDoctor.setText(element.getDoctorName());
            }


        }));
    }
    @FXML
    private void changePatientId(ActionEvent e){
        patientSummaryInfors.forEach(element->{
            if(element.getPatientId() == patientId.getValue()){
                namePatient.setText(element.getPatientName());
            }
        });


    }
    @FXML
    private void handleRegist() throws SQLException {


        LocalDate dateNow= LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("hh:mm:ss");
        System.out.println(dateNow.format(formatDate));
        System.out.println(timeNow.format(formatTime));
        System.out.println(datePicker.getValue().toString());
        String timeExam = timeField.getText();
        System.out.println(Time.valueOf(timeExam));
        SQLconnect sqLconnect = new SQLconnect();
        sqLconnect.connect();
        PreparedStatement statement = sqLconnect.getConnection().prepareStatement("insert into medical_bill values (?,?,?,?,?,?,?)");
        statement.setString(1,patientId.getValue());
        statement.setString(2,doctorId.getValue());
        statement.setDate(3, Date.valueOf(dateNow));
        statement.setTime(4, Time.valueOf(timeNow));
        statement.setDate(5, Date.valueOf(datePicker.getValue()));
        statement.setTime(6, Time.valueOf(timeExam));
        statement.setInt(7,Integer.parseInt(moneyPay.getText()));
        boolean isExecute = statement.execute();
        System.out.println(isExecute);
        if(!isExecute){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("STATUS");
            alert.setContentText("SUCCESS REGISTRATION.");
            alert.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("STATUS");
            alert.setContentText("Error DATA.");
            alert.show();

        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Help help = new Help();
        try {
            patientSummaryInfors = help.generateAllPatientIdAndName();
            doctorSummaryInfors = help.generateAllDoctorIdAndName();
            patientSummaryInfors.forEach((data)->{
                listIdPatient.add(data.getPatientId());
            });
            doctorSummaryInfors.forEach((data)->{
                listIdDoctor.add(data.getDoctorId());
            });
            doctorId.setItems(listIdDoctor);
            patientId.setItems(listIdPatient);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}
