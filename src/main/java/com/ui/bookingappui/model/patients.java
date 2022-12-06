package com.ui.bookingappui.model;

public class patients {
    private String id;
    private String namePatient;
    private String addressPatient;
    private String phone_number;
    private String email;
    private String gender;
    private int age;

    public patients(String id, String namePatient, String addressPatient, String phone_number, String email, String gender, int age) {
        this.id = id;
        this.namePatient = namePatient;
        this.addressPatient = addressPatient;
        this.phone_number = phone_number;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getAddressPatient() {
        return addressPatient;
    }

    public void setAddressPatient(String addressPatient) {
        this.addressPatient = addressPatient;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
