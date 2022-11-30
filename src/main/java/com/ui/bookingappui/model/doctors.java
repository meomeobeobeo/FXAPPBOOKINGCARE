package com.ui.bookingappui.model;


import java.io.IOException;

public class doctors {
    private String id;
    private String name;
    private int age;
    private String level;
    private String work_specialize;
    private String phone_number;
    private String email;
    private String description;

    public doctors(String id, String name, int age, String level, String work_place, String phone_number, String email, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.level = level;
        this.work_specialize = work_place;
        this.phone_number = phone_number;
        this.email = email;
        this.description = description;
    }

    public static void main(String[] args) throws IOException {


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
