package com.ui.bookingappui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class mainUi extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader main = new FXMLLoader(Objects.requireNonNull(getClass().getResource("loginform.fxml")));
        Parent mainPage = main.load();
        Scene mainScene = new Scene(mainPage, 1024, 576);
        mainScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("loginform.css")).toExternalForm());
        stage.setScene(mainScene);
        stage.show();


    }
}
