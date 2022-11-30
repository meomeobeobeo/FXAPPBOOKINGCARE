module com.ui.bookingappui {

    requires com.microsoft.sqlserver.jdbc;

    requires java.naming;
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ui.bookingappui to javafx.fxml;
    exports com.ui.bookingappui;
    exports com.ui.bookingappui.function;
}