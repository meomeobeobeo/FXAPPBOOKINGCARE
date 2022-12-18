package com.ui.bookingappui.function;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.ui.bookingappui.model.doctors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLconnect {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public static void main(String[] args) throws SQLException {
        ArrayList<doctors> list = new ArrayList<doctors>();
        SQLconnect sqLconnect = new SQLconnect();
        sqLconnect.connect();
        ResultSet newData = sqLconnect.getData("select * from doctors");
        while (newData.next()) {
            System.out.println(newData.getString("nameDoctor"));
            list.add(
                    new doctors(
                            newData.getString("id"),
                            newData.getString("nameDoctor"),
                            newData.getInt("age"),
                            newData.getString("levelDoctor"),
                            newData.getString("work_specialize"),
                            newData.getString("phone_number"),
                            newData.getString("email"),
                            newData.getString("descriptionDoctor"),
                            newData.getString("gender")
                    )
            );
            list.forEach((e) -> {
                System.out.println(e.getNameDoctor());
            });


        }
    }

    public void connect() throws SQLServerException {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");

        ds.setPassword("meotrangbeo1");
        ds.setServerName("DESKTOP-JPBHIFB\\SQLEXPRESS");
        ds.setEncrypt("true");
        ds.setTrustServerCertificate(true);
        ds.setSSLProtocol("TLSv1.2");
        ds.setPortNumber(1433);
        ds.setDatabaseName("bookingapp");
        this.connection = ds.getConnection();
        System.out.println("connect success to sql server.");
    }

    public ResultSet getData(String query) throws SQLException {
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        return resultSet;

    }

    public Connection getConnection() {
        return connection;
    }

    public void insertDataSQL(String querry) throws SQLException {
        connection.prepareStatement(querry).execute();

    }

    public void executeQuerry(String query) throws SQLException {
        boolean res = connection.prepareStatement(query).execute();
    }


}
