package com.ui.bookingappui.function;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLconnect {
    public void connect() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");

        ds.setPassword("meotrangbeo1");
        ds.setServerName("DESKTOP-JPBHIFB\\SQLEXPRESS");
        ds.setEncrypt("true");
        ds.setTrustServerCertificate(true);
        ds.setSSLProtocol("TLSv1.2");
        ds.setPortNumber(1433);
        ds.setDatabaseName("QLSV");
        try (Connection connection = ds.getConnection()) {
            System.out.println("SUCCESS.............");
            System.out.println(connection.getCatalog());
            System.out.println(connection.getSchema());


        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
