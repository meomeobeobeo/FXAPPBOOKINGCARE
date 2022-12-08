package com.ui.bookingappui.function;

import javafx.scene.control.Alert;

public class myAlert {
    private static Alert alertCanNotFindData;
    private static Alert alertRequiredField;
    private static Alert alertDataInvalid;

    public myAlert() {
        alertCanNotFindData = new Alert(Alert.AlertType.WARNING);
        alertCanNotFindData.setHeaderText("STATUS.");
        alertCanNotFindData.setContentText("Can not find data");

        alertRequiredField = new Alert(Alert.AlertType.WARNING);
        alertRequiredField.setContentText("Need data in field.");
        alertRequiredField.setHeaderText("Warming");

        alertDataInvalid = new Alert(Alert.AlertType.WARNING);
        alertDataInvalid.setHeaderText("Warming");
        alertDataInvalid.setContentText("You must enter valid data");

    }

    public Alert getAlertRequiredField() {
        return alertRequiredField;
    }

    public Alert getAlertDataInvalid() {
        return alertDataInvalid;
    }

    public Alert getAlertCanNotFindData() {
        return alertCanNotFindData;
    }
}
