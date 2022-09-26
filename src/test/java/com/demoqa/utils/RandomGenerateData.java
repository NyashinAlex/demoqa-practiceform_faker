package com.demoqa.utils;

import java.util.Random;

public class RandomGenerateData {
    public static String choiceGender() {
        String[] array = {
                "Male",
                "Female",
                "Other"
        };
        int randomGender = new Random().nextInt(array.length);
        return array[randomGender];
    }
}
