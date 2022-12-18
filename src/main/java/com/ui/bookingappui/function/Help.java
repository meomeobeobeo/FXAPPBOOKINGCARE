package com.ui.bookingappui.function;

import com.ui.bookingappui.model.doctorSummaryInfor;
import com.ui.bookingappui.model.patientSummaryInfor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Help {

    public int[] innitialArray() {
        int[] array = new int[120];
        Arrays.setAll(array, i -> i + 1);
        return array;
    }

    public String[] initialAge() {
        int[] arr = innitialArray();
        String[] age = new String[120];
        for (int i = 0; i < 120; i++) {
            age[i] = Integer.toString(arr[i]);

        }
        return age;
    }

    public String renderId() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public boolean checkStringOnlyNumber(String str) {
        return str.matches("[0-9]+");
    }

    public ArrayList<doctorSummaryInfor> generateAllDoctorIdAndName() throws SQLException {
        ArrayList<doctorSummaryInfor> list = new ArrayList<doctorSummaryInfor>();
        SQLconnect sqLconnect = new SQLconnect();
        sqLconnect.connect();
        ResultSet data = sqLconnect.getData("select id , nameDoctor from doctors");
        while (data.next()){
            list.add(new doctorSummaryInfor(
                    data.getString("id"),
                    data.getString("nameDoctor")
            ));
        }



        return list;
    }
    public ArrayList<patientSummaryInfor> generateAllPatientIdAndName() throws SQLException {
        ArrayList<patientSummaryInfor> list = new ArrayList<patientSummaryInfor>();
        SQLconnect sqLconnect = new SQLconnect();
        sqLconnect.connect();
        ResultSet data = sqLconnect.getData("select id , namePatient from patients");
        while (data.next()){
            list.add(new patientSummaryInfor(
                    data.getString("id"),
                    data.getString("namePatient")
            ));
        }



        return list;
    }



    public static void main(String[] args) throws SQLException {
       Help s = new Help();
       ArrayList<patientSummaryInfor> pa = s.generateAllPatientIdAndName();
       ArrayList<doctorSummaryInfor> doc = s.generateAllDoctorIdAndName();

        pa.forEach((res)->{
            System.out.println(res.getPatientName());
        });
    }

}
