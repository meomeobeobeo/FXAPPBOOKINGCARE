package com.ui.bookingappui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class loginFormControl {
    @FXML
    private TextField emailLogin;
    @FXML
    private TextField passLogin;

    private boolean checkAccount(String email, String passWord) {

        return Objects.equals(email, "a") && Objects.equals(passWord, "a");
    }

    // if login success change into dashBoard scene
    @FXML
    private void signIn(ActionEvent event) throws IOException {
        System.out.println("sign in");
        String email = emailLogin.getText();
        String pass = emailLogin.getText();
        System.out.println(email);
        System.out.println(pass);
        System.out.println(checkAccount(email, pass));
        if (checkAccount(email, pass)) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("dashBoard.fxml")));
            Parent dashBoardPage = loader.load();
            Scene dashBoardPageScene = new Scene(dashBoardPage,1024,576);
            dashBoardPageScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("dashBoard.css")).toExternalForm());

            stage.setScene(dashBoardPageScene);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Have some error>>>");
            alert.setHeaderText("LOGIN ERROR !!!!");
            alert.setContentText("email or pass is incorrect.");
            alert.show();
            emailLogin.setText("");
            passLogin.setText("");
            emailLogin.requestFocus();


        }


    }

    @FXML
    private void loginWithGoogle() {
        System.out.println("login google");
    }

    @FXML
    private void signUp() {
        System.out.println("sign up");
    }


}
