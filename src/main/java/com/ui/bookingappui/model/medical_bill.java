package com.ui.bookingappui.model;

import java.time.LocalDateTime;

public class medical_bill {

    private String patient_id;
    private String doctor_id;
    private LocalDateTime registration_date;
    private LocalDateTime medical_examination_day;

    public medical_bill(String patient_id, String doctor_id, LocalDateTime registration_date, LocalDateTime medical_examination_day) {
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.registration_date = registration_date;
        this.medical_examination_day = medical_examination_day;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public LocalDateTime getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDateTime registration_date) {
        this.registration_date = registration_date;
    }

    public LocalDateTime getMedical_examination_day() {
        return medical_examination_day;
    }

    public void setMedical_examination_day(LocalDateTime medical_examination_day) {
        this.medical_examination_day = medical_examination_day;
    }


}
