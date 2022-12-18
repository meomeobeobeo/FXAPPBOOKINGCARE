package com.ui.bookingappui.model;

public class doctorSummaryInfor {
    private String doctorId;
    private String doctorName;

    public doctorSummaryInfor(String doctorId, String doctorName) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }
}
