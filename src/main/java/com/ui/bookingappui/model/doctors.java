package com.ui.bookingappui.model;


public class doctors {
    private String id;
    private String nameDoctor;
    private int age;
    private String levelDoctor;
    private String work_specialize;
    private String phone_number;
    private String email;
    private String descriptionDoctor;
    private String gender;

    public doctors(String id, String nameDoctor, int age, String levelDoctor, String work_specialize, String phone_number, String email, String descriptionDoctor, String gender) {

        this.id = id;
        this.nameDoctor = nameDoctor;
        this.age = age;
        this.levelDoctor = levelDoctor;
        this.work_specialize = work_specialize;
        this.phone_number = phone_number;
        this.email = email;
        this.descriptionDoctor = descriptionDoctor;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLevelDoctor() {
        return levelDoctor;
    }

    public void setLevelDoctor(String levelDoctor) {
        this.levelDoctor = levelDoctor;
    }

    public String getWork_specialize() {
        return work_specialize;
    }

    public void setWork_specialize(String work_specialize) {
        this.work_specialize = work_specialize;
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

    public String getDescriptionDoctor() {
        return descriptionDoctor;
    }

    public void setDescriptionDoctor(String descriptionDoctor) {
        this.descriptionDoctor = descriptionDoctor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
