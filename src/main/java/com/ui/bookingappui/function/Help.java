package com.ui.bookingappui.function;

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


}
