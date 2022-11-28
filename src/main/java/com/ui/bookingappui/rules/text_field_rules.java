package com.ui.bookingappui.rules;

import java.util.regex.Pattern;

public class text_field_rules {

    // check required field
    public boolean check_required(String text) {
        return !text.equals("");

    }

    // check is email
    public boolean check_isMail(String email) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();

    }

    // check is number
    public boolean check_number(String number_str) {
        if (number_str == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(number_str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean check_isAge(String value) {
        if (value == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(value);
            if (!(1 < d && d < 150)) {
                return false;
            }

        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


}
