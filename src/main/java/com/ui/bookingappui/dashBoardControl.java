package com.ui.bookingappui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class dashBoardControl implements Initializable {

    @FXML
    private AnchorPane doctor_pane;

    @FXML
    private Button btn_doctor_infor;

    @FXML
    private Button btn_dashBoard;

    @FXML
    private Button btn_patientInfor;

    @FXML
    private AnchorPane dashBoard_pane;

    @FXML
    private Button btn_setting;

    @FXML
    private AnchorPane setting_pane;

    @FXML
    private AnchorPane patient_pane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void handleClick(ActionEvent e){
        if(e.getSource() == btn_dashBoard){
            System.out.println("dashboard");
            dashBoard_pane.setVisible(true);

            doctor_pane.setVisible(false);
            patient_pane.setVisible(false);
            setting_pane.setVisible(false);
        } else if (e.getSource() == btn_doctor_infor) {
            System.out.println("doctor infor");
            doctor_pane.setVisible(true);
            dashBoard_pane.setVisible(false);

            patient_pane.setVisible(false);
            setting_pane.setVisible(false);

        } else if (e.getSource() == btn_patientInfor) {
            System.out.println("patient infor");
            patient_pane.setVisible(true);

            dashBoard_pane.setVisible(false);
            doctor_pane.setVisible(false);

            setting_pane.setVisible(false);
        } else if (e.getSource() == btn_setting) {
            System.out.println("setting");
            setting_pane.setVisible(true);

            dashBoard_pane.setVisible(false);
            doctor_pane.setVisible(false);
            patient_pane.setVisible(false);

        }

    }
}
