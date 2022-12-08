package com.ui.bookingappui.function;

import com.ui.bookingappui.rules.text_field_rules;

import java.util.ArrayList;

public class checkRuleInput {
    public static void main(String[] args) {
        ArrayList<String> test;
        checkRuleInput checkRuleInput = new checkRuleInput();
        test = checkRuleInput.checkPatientInputData("Nguyen Minh Duc", "Nam dinh", "1243j4324", "meomeobeogmail.com", "453");
        for (String s : test) {
            System.out.println(s);

        }
    }

    public ArrayList<String> checkPatientInputData(String name, String address, String phoneNUmber, String email, String age) {
        ArrayList<String> error = new ArrayList<String>();
        text_field_rules rules = new text_field_rules();
        boolean requiredData = rules.check_required(name) && rules.check_required(address) && rules.check_required(email)
                && rules.check_required(age) && rules.check_required(phoneNUmber);
        boolean isEmail = rules.check_isMail(email);
        boolean isNumber = rules.isOnlyNumber(phoneNUmber) && rules.isOnlyNumber(age);
        if (requiredData) {
            if (!isEmail) {
                error.add("email is invalid.");
            }
            if (!isNumber) {
                error.add("Number data is invalid");
            }

        } else {
            error.add("You must enter all the data.");
        }


        return error;
    }

    public ArrayList<String> checkDoctorInputData(String nameDoctor, String age, String levelDoctor,
                                                  String work_specialize, String phone_number, String email,
                                                  String descriptionDoctor, String gender) {
        ArrayList<String> error = new ArrayList<String>();
        text_field_rules rules = new text_field_rules();

        boolean requiredData = rules.check_required(nameDoctor) &&
                rules.check_required(age) &&
                rules.check_required(levelDoctor) &&
                rules.check_required(work_specialize) &&
                rules.check_required(phone_number) &&
                rules.check_required(email) &&
                rules.check_required(descriptionDoctor) &&
                rules.check_required(gender);
        boolean isEmail = rules.check_isMail(email);
        boolean isNumber = rules.check_number(phone_number) && rules.isOnlyNumber(age);
        if (requiredData) {
            if (!isEmail) {
                error.add("email is invalid.");
            }
            if (!isNumber) {
                error.add("Number data is invalid");
            }

        } else {
            error.add("You must enter all the data.");
        }
        return error;

    }
}
