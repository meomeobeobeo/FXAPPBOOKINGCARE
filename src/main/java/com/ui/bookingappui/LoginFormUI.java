package com.ui.bookingappui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class LoginFormUI extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("loginform.fxml")));
        Parent root = loader.load();
        Scene loginScene = new Scene(root);
        loginScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("loginform.css")).toExternalForm());
        stage.setScene(loginScene);
        stage.show();

    }
}
