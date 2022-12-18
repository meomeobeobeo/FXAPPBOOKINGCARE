package com.ui.bookingappui.model;

public class patientSummaryInfor {
    private String patientId;
    private String patientName;

    public patientSummaryInfor(String patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }
}
