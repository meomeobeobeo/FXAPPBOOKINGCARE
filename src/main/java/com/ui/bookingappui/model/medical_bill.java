package com.ui.bookingappui.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class medical_bill {

    private String patient_id;
    private String doctor_id;
    private LocalDate registration_date;
    private LocalTime registration_time;
    private LocalDate medical_examination_day;
    private LocalTime medical_examination_time;
    private int payment;

    public String getPatient_id() {
        return patient_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }

    public LocalTime getRegistration_time() {
        return registration_time;
    }

    public LocalDate getMedical_examination_day() {
        return medical_examination_day;
    }

    public LocalTime getMedical_examination_time() {
        return medical_examination_time;
    }

    public int getPayment() {
        return payment;
    }

    public medical_bill(String patient_id, String doctor_id, LocalDate registration_date, LocalTime registration_time, LocalDate medical_examination_day, LocalTime medical_examination_time, int payment) {
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.registration_date = registration_date;
        this.registration_time = registration_time;
        this.medical_examination_day = medical_examination_day;
        this.medical_examination_time = medical_examination_time;
        this.payment = payment;
    }
}
