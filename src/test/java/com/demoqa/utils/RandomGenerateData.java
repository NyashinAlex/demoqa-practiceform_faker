package com.demoqa.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;
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
    public static LocalDate  generateBirthDate() {
        return LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
    }
    public static String choiceSubject() {
        String[] array = {
                "Maths",
                "Chemistry",
                "Computer Science",
                "Commerce",
                "Economics"
        };
        int randomSubject = new Random().nextInt(array.length);
        return array[randomSubject];
    }
    public static String choiceHobbies() {
        String[] array = {
                "Sports",
                "Reading",
                "Music"
        };
        int randomHobbies = new Random().nextInt(array.length);
        return array[randomHobbies];
    }
    public static String choiceState() {
        String[] array = {
                "NCR",
                "Uttar Pradesh",
                "Haryana",
                "Rajasthan"
        };
        int randomState = new Random().nextInt(array.length);
        return array[randomState];
    }
    public static String choiceCity(String State) {
        ArrayList<String> city = new ArrayList<>();
        if(Objects.equals(State, "NCR")) {
            city.add("Delhi");
            city.add("Gurgaon");
            city.add("Noida");
        } else if (Objects.equals(State, "Uttar Pradesh")) {
            city.add("Agra");
            city.add("Lucknow");
            city.add("Merrut");
        } else if (Objects.equals(State, "Rajasthan")) {
            city.add("Jaipur");
            city.add("Jaiselmer");
        }
        int randomCity = new Random().nextInt(city.size());
        return city.get(randomCity);
    }
    public static String getRandomDay() {
        int minDay = 1;
        int maxDay = 20;
        int randomDay = minDay + (int)(Math.random() * ((maxDay - minDay) + 1));
        return String.valueOf(randomDay);
    }
    public static String getRandomYear() {
        int minYear = 1990;
        int maxYear = 2000;
        int randomYear = minYear + (int)(Math.random() * ((maxYear - minYear) + 1));
        return String.valueOf(randomYear);
    }
}