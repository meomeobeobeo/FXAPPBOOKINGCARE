package com.ui.bookingappui;

import com.ui.bookingappui.function.*;
import com.ui.bookingappui.model.doctors;
import com.ui.bookingappui.model.medical_bill;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class dashBoardControl implements Initializable {


    private final ObservableList<String> list_age = FXCollections.observableArrayList(new Help().initialAge());
    private final ObservableList<String> gender = FXCollections.observableArrayList("Nam", "Nữ");
    private final ObservableList<String> list_search_choose = FXCollections.observableArrayList(
            "Search with Name",
            "Search with age",
            "Search with ID",
            "Search with phone number",
            "Search with Email"
    );
    private final ObservableList<patients> patients_list = FXCollections.observableArrayList();
    private final ObservableList<doctors> doctors_list = FXCollections.observableArrayList();
    private final ObservableList<String> list_level = FXCollections.observableArrayList("Thạc sĩ", "Phó giáo sư", "Giáo sư");
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
    @FXML
    private TextField name_doctor;
    @FXML
    private TextField address_doctor;
    @FXML
    private TextField phone_number_doctor;
    @FXML
    private TextField email_doctor;
    @FXML
    private TextArea description_doctor;
    @FXML
    private ComboBox<String> gender_doctor;
    @FXML
    private TextField search_doctor_field;
    @FXML
    private ComboBox<String> search_doctor_choose;
    private ResultSet result_patients;
    private ResultSet result_doctors;
    @FXML
    private Button btn_doctor_infor;
    @FXML
    private Button btn_dashBoard;
    @FXML
    private TextField namePatient;
    @FXML
    private Button btn_setting;
    @FXML
    private ComboBox<String> gender_patient;
    @FXML
    private TextField addressPatient;
    @FXML
    private AnchorPane doctor_pane;
    @FXML
    private TextField phone_number_patient;
    @FXML
    private ComboBox<String> age_patient;
    @FXML
    private Button btn_patientInfor;
    @FXML
    private AnchorPane dashBoard_pane;
    @FXML
    private AnchorPane setting_pane;
    @FXML
    private AnchorPane patient_pane;
    @FXML
    private TextField email_patient;
    @FXML
    private ComboBox<String> search_patient_choose;
    @FXML
    private TextField searchText_patient;
    @FXML
    private TableView<patients> table_patients;
    @FXML
    private TableColumn<patients, String> patient_id_col;
    @FXML
    private TableColumn<patients, Integer> patient_age_col;
    @FXML
    private TableColumn<patients, String> patient_name_col;
    @FXML
    private TableColumn<patients, String> patient_email_col;
    @FXML
    private ComboBox<String> level_doctor;
    @FXML
    private ComboBox<String> age_doctor;
    @FXML
    private ComboBox<String> work_special_doctor;
    @FXML
    private TableView<doctors> table_doctors;
    @FXML
    private TableColumn<doctors, String> doctor_id_col;
    @FXML
    private TableColumn<doctors, Integer> doctor_age_col;
    @FXML
    private TableColumn<doctors, String> doctor_name_col;
    @FXML
    private TableColumn<doctors, String> doctor_email_col;
    @FXML
    private TextField mailPatientID;
    @FXML
    private TextField mailDoctorID;
    @FXML
    private TextArea mailContent;
    @FXML
    private ComboBox<String> mailPatientIdBox;
    @FXML
    private ComboBox<String> mailDoctorIdBox;
    @FXML
    private TableView<medical_bill> regist_table;
    @FXML
    private TableColumn<medical_bill,String> regist_patient_id_col;
    @FXML
    private TableColumn<medical_bill,String> regist_doctor_id_col;
    @FXML
    private TableColumn<medical_bill,LocalDate> regist_date_col;
    @FXML
    private TableColumn<medical_bill,Integer> payment_col;
    @FXML
    private ComboBox<String> search_dash_choose;
    @FXML
    private TextField dash_search_text;
    ObservableList<String> search_dash_chooses = FXCollections.observableArrayList(
            "Search with patient id",
            "Search with doctor id",
            "Search with payment < value",
            "Search All"
    );
    private final ObservableList<medical_bill> regist_data = FXCollections.observableArrayList();
    ResultSet result_search_regist;
    private final ObservableList<String> mailPatientBoxItems = FXCollections.observableArrayList("");
    private final ObservableList<String> mailDoctorBoxItems = FXCollections.observableArrayList("");
    @FXML
    private void mail_choose_patient_id(){
        mailPatientID.setText(mailPatientIdBox.getValue());
    }
    @FXML
    private void mail_choose_doctor_id(){
        mailDoctorID.setText(mailDoctorIdBox.getValue());
    }





    // Khởi tạo
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        age_patient.setItems(list_age);
        gender_patient.setItems(gender);
        search_patient_choose.setItems(list_search_choose);

        level_doctor.setItems(list_level);
        age_doctor.setItems(list_age);
        work_special_doctor.setItems((list_work_special));
        gender_doctor.setItems(gender);
        search_doctor_choose.setItems(list_search_choose);


        //show in table patient
        patient_id_col.setCellValueFactory(new PropertyValueFactory<patients, String>("id"));
        patient_age_col.setCellValueFactory(new PropertyValueFactory<patients, Integer>("age"));
        patient_name_col.setCellValueFactory(new PropertyValueFactory<patients, String>("namePatient"));
        patient_email_col.setCellValueFactory(new PropertyValueFactory<patients, String>("email"));
        table_patients.setItems(patients_list);

        //show in table doctor

        doctor_id_col.setCellValueFactory(new PropertyValueFactory<doctors, String>("id"));
        doctor_age_col.setCellValueFactory(new PropertyValueFactory<doctors, Integer>("age"));
        doctor_name_col.setCellValueFactory(new PropertyValueFactory<doctors, String>("nameDoctor"));
        doctor_email_col.setCellValueFactory(new PropertyValueFactory<doctors, String>("email"));
        table_doctors.setItems(doctors_list);
        // dash board
        search_dash_choose.setItems(search_dash_chooses);
        regist_patient_id_col.setCellValueFactory(new PropertyValueFactory<medical_bill,String>("patient_id"));
        regist_doctor_id_col.setCellValueFactory(new PropertyValueFactory<medical_bill,String>("doctor_id"));
        regist_date_col.setCellValueFactory(new PropertyValueFactory<medical_bill, LocalDate>("registration_date"));
        payment_col.setCellValueFactory(new PropertyValueFactory<medical_bill,Integer>("payment"));
        regist_table.setItems(regist_data);
        mailPatientIdBox.setItems(mailPatientBoxItems);
        mailDoctorIdBox.setItems(mailDoctorBoxItems);




    }
    private void regist_table_setData(PreparedStatement prepare) throws SQLException {
        regist_data.clear();
        result_search_regist = prepare.executeQuery();
        if (!result_search_regist.isBeforeFirst() && result_search_regist.getRow() == 0) {
            new myAlert().getAlertCanNotFindData().show();
            return;
        }
        while (result_search_regist.next()){
            mailPatientBoxItems.add(result_search_regist.getString("patient_id"));
            mailDoctorBoxItems.add(result_search_regist.getString("doctor_id"));
            regist_data.add(
                    new medical_bill(
                            result_search_regist.getString("patient_id"),
                            result_search_regist.getString("doctor_id"),
                            result_search_regist.getDate("registration_date").toLocalDate(),
                            result_search_regist.getTime("registration_time").toLocalTime(),
                            result_search_regist.getDate("medical_examination_date").toLocalDate(),
                            result_search_regist.getTime("medical_examination_time").toLocalTime(),
                            result_search_regist.getInt("payment")
                            )
            );
        }
        System.out.println(regist_data);


    }
    @FXML
    private void search_regist_action(ActionEvent event) throws SQLException {
        SQLconnect sqLconnect = new SQLconnect();
        String searchText = dash_search_text.getText();


        if(search_dash_choose.getValue() == "Search with patient id"){
            sqLconnect.connect();
            PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from medical_bill where patient_id = ?");
            prepare.setString(1,searchText);
            regist_table_setData(prepare);
            System.out.println("search success");


        } else if (search_dash_choose.getValue() == "Search with doctor id") {
            sqLconnect.connect();
            PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from medical_bill where doctor_id = ?");
            prepare.setString(1,searchText);
            regist_table_setData(prepare);
            System.out.println("search success");

        } else if (search_dash_choose.getValue() == "Search with payment < value") {
            String key = searchText.replaceAll("\\s+", "");
            Help help = new Help();
           if(help.checkStringOnlyNumber(key)){
               sqLconnect.connect();
               PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from medical_bill where payment <= ?");
               prepare.setInt(1,Integer.parseInt(key));
               regist_table_setData(prepare);
               System.out.println("search success");

           }
           else {
               new myAlert().getAlertDataInvalid().show();
           }

        } else if (search_dash_choose.getValue() == "Search All") {
            sqLconnect.connect();
            PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from medical_bill");
            regist_table_setData(prepare);
            System.out.println("search success");

        } else {

        }
    }
    @FXML
    private void set_patient_detail(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("detailPatient.fxml")));
        Parent detailPage =loader.load();
        Scene detailPageScene = new Scene(detailPage);
        detailPageScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("detail.css")).toExternalForm());
        patients patient = table_patients.getSelectionModel().getSelectedItem();
        if(patient == null){
            new myAlert().getAlertDataInvalid().show();
            return;
        }
        patientDetailControl patientDetailControl = loader.getController();
        patientDetailControl.setValueDetail(patient);
        stage.setScene(detailPageScene);

    }
    @FXML
    private void set_detail_doctor(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("detailDoctor.fxml")));
        Parent detailPage =loader.load();
        Scene detailPageScene = new Scene(detailPage);
        detailPageScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("detail.css")).toExternalForm());
        doctors doctor = table_doctors.getSelectionModel().getSelectedItem();
        if( doctor == null){
            new myAlert().getAlertDataInvalid().show();
            return;
        }
        doctorDetailControl doctorDetailControl = loader.getController();
        doctorDetailControl.setValueDetail(doctor);
        stage.setScene(detailPageScene);

    }

    @FXML
    private void regist_doctor(ActionEvent e) {
        ArrayList<String> errorInput;
        checkRuleInput check = new checkRuleInput();
        errorInput = check.checkDoctorInputData(name_doctor.getText(), age_doctor.getValue(), level_doctor.getValue(), work_special_doctor.getValue(), phone_number_doctor.getText(), email_doctor.getText(), description_doctor.getText(), gender_doctor.getValue());
        if (errorInput.size() > 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            String content = "";
            for (String a : errorInput) {

                content = content + "\n" + a;
            }
            alert.setHeaderText("Error in text field.");
            alert.setContentText(content);
            alert.show();
            return;
        }
        doctors newDoctor = new doctors(
                new Help().renderId(),
                name_doctor.getText(),
                Integer.parseInt(age_doctor.getValue()),
                level_doctor.getValue(),
                work_special_doctor.getValue(),
                phone_number_doctor.getText(),
                email_doctor.getText(),
                description_doctor.getText(),
                gender_doctor.getValue()
        );
        SQLconnect sqLconnect = new SQLconnect();

        try {
            sqLconnect.connect();
            PreparedStatement preparedStatement = sqLconnect.getConnection().prepareStatement("insert into doctors values (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,newDoctor.getId());
            preparedStatement.setString(2,newDoctor.getNameDoctor());
            preparedStatement.setString(3,newDoctor.getPhone_number());
            preparedStatement.setString(4,newDoctor.getEmail());
            preparedStatement.setString(5,newDoctor.getGender());
            preparedStatement.setInt(6,newDoctor.getAge());
            preparedStatement.setString(7,newDoctor.getLevelDoctor());
            preparedStatement.setString(8,newDoctor.getWork_specialize());
            preparedStatement.setString(9,newDoctor.getDescriptionDoctor());
            preparedStatement.execute();

            System.out.println("insert data success....");
            name_doctor.setText("");
            address_doctor.setText("");
            phone_number_doctor.setText("");
            email_doctor.setText("");
            age_doctor.setValue("");
            level_doctor.setValue("");
            work_special_doctor.setValue("");
            gender_doctor.setValue("");
            name_doctor.requestFocus();
            description_doctor.setText("");
        } catch (SQLException err) {
            throw new RuntimeException(err);
        }


    }


    @FXML
    private void regist_patient(ActionEvent event) {
        ArrayList<String> errorInput;
        checkRuleInput check = new checkRuleInput();
        errorInput = check.checkPatientInputData(namePatient.getText(), addressPatient.getText(), phone_number_patient.getText(), email_patient.getText(), age_patient.getValue());
        if (errorInput.size() > 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            String content = "";
            for (String a : errorInput) {

                content = content + "\n" + a;
            }
            alert.setHeaderText("Error in text field.");
            alert.setContentText(content);
            alert.show();
            return;
        }

        patients newPatient = new patients(
                new Help().renderId(),
                namePatient.getText(),
                addressPatient.getText(),
                phone_number_patient.getText(),
                email_patient.getText(), gender_patient.getValue(),
                Integer.parseInt(age_patient.getValue())
        );
//
        String phone = Integer.toString(newPatient.getAge());
        String query = "insert into patients values(" + "'" + newPatient.getId() + "'" + "," + "N'" + newPatient.getNamePatient() + "',N'" + newPatient.getAddressPatient() + "','" + newPatient.getPhone_number() + "'" + ",'" + newPatient.getEmail() + "',N'" + newPatient.getGender() + "'," + phone + ")";

        SQLconnect sqLconnect = new SQLconnect();

        try {
            sqLconnect.connect();

            PreparedStatement preparedStatement = sqLconnect.getConnection().prepareStatement("insert into patients values (?,?,?,?,?,?,?)");
            preparedStatement.setString(1,newPatient.getId());
            preparedStatement.setString(2,newPatient.getNamePatient());
            preparedStatement.setString(3,newPatient.getAddressPatient());
            preparedStatement.setString(4, newPatient.getPhone_number());
            preparedStatement.setString(5, newPatient.getEmail());
            preparedStatement.setString(6, newPatient.getGender());
            preparedStatement.setInt(7, newPatient.getAge());



            preparedStatement.execute();

            System.out.println("insert data success....");
            namePatient.setText("");
            addressPatient.setText("");
            phone_number_patient.setText("");
            email_patient.setText("");
            age_patient.setValue("");
            gender_patient.setValue("");
            namePatient.requestFocus();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private void patient_setData(PreparedStatement prepare) throws SQLException {
        patients_list.clear();
        result_patients = prepare.executeQuery();
        if (!result_patients.isBeforeFirst() && result_patients.getRow() == 0) {
            new myAlert().getAlertCanNotFindData().show();
            return;
        }


        while (result_patients.next()) {
            System.out.println(result_patients.getString("namePatient"));
            patients_list.add(
                    new patients(
                            result_patients.getString("id"),
                            result_patients.getString("namePatient"),
                            result_patients.getString("addressPatient"),
                            result_patients.getString("phone_number"),
                            result_patients.getString("email"),
                            result_patients.getString("gender"),
                            result_patients.getInt("age")

                    ));
        }
        System.out.println(patients_list);

    }

    private void doctor_setData(PreparedStatement prepare) throws SQLException {

        doctors_list.clear();
        result_doctors = prepare.executeQuery();
        if (!result_doctors.isBeforeFirst() && result_doctors.getRow() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Status");
            alert.setContentText("Can not find data.");
            alert.show();
            return;
        }
        while (result_doctors.next()) {
            doctors_list.add(
                    new doctors(
                            result_doctors.getString("id"),
                            result_doctors.getString("nameDoctor"),
                            result_doctors.getInt("age"),
                            result_doctors.getString("levelDoctor"),
                            result_doctors.getString("work_specialize"),
                            result_doctors.getString("phone_number"),
                            result_doctors.getString("email"),
                            result_doctors.getString("descriptionDoctor"),
                            result_doctors.getString("gender")
                    )
            );
        }


    }

    @FXML
    private void search_doctors() throws SQLException {
        String choose = search_doctor_choose.getValue();
        SQLconnect sqLconnect = new SQLconnect();
        sqLconnect.connect();
        String searchText = search_doctor_field.getText();

        if (searchText == "") {
            Alert error_search_patient_alert = new Alert(Alert.AlertType.ERROR);
            error_search_patient_alert.setHeaderText("Warming...");
            error_search_patient_alert.setContentText("You field search do not empty");
            error_search_patient_alert.show();
            return;
        }

        if (choose == "Search with Name") {

            String query = "select * from doctors where nameDoctor like N'" + searchText + "%'";

            System.out.println(query);
            PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from doctors where nameDoctor like ?   ");
            prepare.setString(1,searchText + "%");

            // set data into state
            doctor_setData(prepare);
        } else if (choose == "Search with age") {
            String key = searchText.replaceAll("\\s+", "");
            Help help = new Help();
            if (help.checkStringOnlyNumber(key)) {

                String query = "select * from doctors where age = " + searchText.replaceAll("\\s+", "");
                System.out.println(query);
                PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from doctors where age = ?   ");
                prepare.setInt(1,Integer.parseInt(key));
                // set data into state
                doctor_setData(prepare);
            } else {
                new myAlert().getAlertDataInvalid().show();

            }

        } else if (choose == "Search with ID") {
            patients_list.clear();
            String query = "select * from doctors where id = " + "'" + searchText.replaceAll("\\s+", "") + "'";
            System.out.println(query);
            PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from doctors where id = ?   ");
            prepare.setString(1,searchText);
            // set data into state
            doctor_setData(prepare);
        } else if (choose == "Search with phone number") {
            patients_list.clear();
            String query = "select * from doctors where phone_number = " + "'" + searchText.replaceAll("\\s+", "") + "'";
            System.out.println(query);
            // set data into state
            PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from doctors where phone_number = ?   ");
            prepare.setString(1,searchText);
            // set data into state
            doctor_setData(prepare);
        } else if (choose == "Search with Email") {
            patients_list.clear();
            String query = "select * from doctors where email = " + "'" + searchText.replaceAll("\\s+", "") + "'";
            System.out.println(query);
            // set data into state
            PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from doctors where email = ?   ");
            prepare.setString(1,searchText);
            // set data into state
            doctor_setData(prepare);


        } else {

        }

    }


    @FXML
    private void search_patients() throws SQLException {


        String choose = search_patient_choose.getValue();
        SQLconnect sqLconnect = new SQLconnect();
        sqLconnect.connect();
        String searchText = searchText_patient.getText();
        if (searchText == "") {
            Alert error_search_patient_alert = new Alert(Alert.AlertType.ERROR);
            error_search_patient_alert.setHeaderText("Warming...");
            error_search_patient_alert.setContentText("You field search do not empty");
            error_search_patient_alert.show();
            return;
        }


        if (choose == "Search with Name") {

            String query = "select * from patients where namePatient like N'" + searchText + "%'";
            System.out.println(query);
            PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from patients where namePatient like ?");
            prepare.setString(1,searchText + "%");
            // set data into state
            patient_setData(prepare);
        } else if (choose == "Search with age") {
            String key = searchText.replaceAll("\\s+", "");
            Help help = new Help();
            if (help.checkStringOnlyNumber(key)) {
                String query = "select * from patients where age = " + searchText.replaceAll("\\s+", "");
                System.out.println(query);
                PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from patients where age = ?");
                prepare.setInt(1,Integer.parseInt(key));
                // set data into state
                patient_setData(prepare);
            } else {
                new myAlert().getAlertDataInvalid().show();
            }


        } else if (choose == "Search with ID") {
            patients_list.clear();
            String query = "select * from patients where id = " + "'" + searchText.replaceAll("\\s+", "") + "'";
            System.out.println(query);
            System.out.println(query);
            PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from patients where id = ?");
            prepare.setString(1,searchText);
            // set data into state
            patient_setData(prepare);
        } else if (choose == "Search with phone number") {
            patients_list.clear();
            String query = "select * from patients where phone_number = " + "'" + searchText.replaceAll("\\s+", "") + "'";
            System.out.println(query);
            PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from patients where phone_number = ?");
            prepare.setString(1,searchText);
            // set data into state
            patient_setData(prepare);

        } else if (choose == "Search with Email") {
            patients_list.clear();
            String query = "select * from patients where email = " + "'" + searchText.replaceAll("\\s+", "") + "'";
            System.out.println(query);

            PreparedStatement prepare = sqLconnect.getConnection().prepareStatement("select * from patients where email = ?");
            prepare.setString(1,searchText);
            // set data into state
            patient_setData(prepare);


        } else {

        }


    }

    @FXML
    private void sendMail() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Email Status.");
        String patientID = mailPatientID.getText();
        String doctorID = mailDoctorID.getText();
        System.out.println("patient  " + mailPatientID.getText());
        System.out.println("doctor  " + mailDoctorID.getText());
        SQLconnect sqLconnect = new SQLconnect();
        sqLconnect.connect();
        if (patientID == "") {
            if (doctorID == "") {
                new myAlert().getAlertRequiredField().show();

            }
        } else {
            String query = "select * from patients where id = " + "'" + patientID.replaceAll("\\s+", "") + "'";
            ResultSet inforPatient = sqLconnect.getData(query);
            if (!inforPatient.isBeforeFirst() && inforPatient.getRow() == 0) {
                new myAlert().getAlertCanNotFindData().show();
                return;
            }
            while (inforPatient.next()) {
                String email = inforPatient.getString("email");
                mailThreat mail = new mailThreat();
                mail.setToEmail(email);
                mail.setContent(mailContent.getText());
                Thread thread = new Thread(mail);
                thread.start();

                if (!thread.isInterrupted()) {

                    alert.setContentText("Send email success");
                    alert.show();
                } else {

                    alert.setContentText("Send email error.");
                    alert.show();
                }
            }
        }
        //
        if (!(doctorID == "")) {
            String query = "select * from doctors where id = " + "'" + doctorID.replaceAll("\\s+", "") + "'";
            ResultSet inforDoctor = sqLconnect.getData(query);
            if (!inforDoctor.isBeforeFirst() && inforDoctor.getRow() == 0) {
                new myAlert().getAlertCanNotFindData().show();
                return;
            }
            while (inforDoctor.next()) {
                String email = inforDoctor.getString("email");
                mailThreat mail = new mailThreat();
                mail.setToEmail(email);
                mail.setContent(mailContent.getText());
                Thread thread = new Thread(mail);
                thread.start();

                if (!thread.isInterrupted()) {

                    alert.setContentText("Send email success");
                    alert.show();
                } else {

                    alert.setContentText("Send email error.");
                    alert.show();
                }
            }

        }
    }
    @FXML
    private void handleRegistTab() throws IOException {
        Stage stage = new Stage();
        FXMLLoader main = new FXMLLoader(Objects.requireNonNull(getClass().getResource("regist.fxml")));
        Parent mainPage = main.load();
        Scene mainScene = new Scene(mainPage);
        mainScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("detail.css")).toExternalForm());
        mainScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("regist.css")).toExternalForm());

        stage.setScene(mainScene);
        stage.show();
    }

    // set route
    @FXML
    private void handleClick(ActionEvent e) {
        if (e.getSource() == btn_dashBoard) {
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
