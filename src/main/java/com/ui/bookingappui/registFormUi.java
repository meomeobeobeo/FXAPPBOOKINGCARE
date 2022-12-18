package com.ui.bookingappui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class registFormUi extends Application  {

    Stage regisStage = new Stage();
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader registForm = new FXMLLoader(Objects.requireNonNull(getClass().getResource("regist.fxml")));
        Parent mainPage = registForm.load();
        Scene mainScene = new Scene(mainPage);
        mainScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("detail.css")).toExternalForm());
        mainScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("regist.css")).toExternalForm());
        stage.setScene(mainScene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }




}
