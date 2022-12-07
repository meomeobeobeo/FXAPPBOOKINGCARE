package com.ui.bookingappui.function;

import javafx.scene.control.Alert;

public class myAlert {
    Alert alertCanNotFindData;
    Alert alertRequiredField;

    public Alert getAlertRequiredField() {
        return alertRequiredField;
    }

    public myAlert(){
        alertCanNotFindData = new Alert(Alert.AlertType.WARNING);
        alertCanNotFindData.setHeaderText("STATUS.");
        alertCanNotFindData.setContentText("Can not find data");

        alertRequiredField = new Alert(Alert.AlertType.WARNING);
        alertRequiredField.setContentText("Need data in field.");
        alertRequiredField.setHeaderText("Warming");

    }

    public Alert getAlertCanNotFindData() {
        return alertCanNotFindData;
    }
}
