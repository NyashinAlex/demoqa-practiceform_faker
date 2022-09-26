package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PracticeFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class PracticeFormTests {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillPracticeForm() {

        Faker faker = new Faker(new Locale("ru"));

        String firstName,
                lastName,
                userName,
                gender,
                userNumber,
                birthDate,
                subjects,
                hobbies,
                picture = "user.jpg",
                state,
                city;

        practiceFormPage.openPage()
                .setFirstName("Alex")
                .setLastName("Nyashin")
                .setUserEmail("nyashin@test.com")
                .setGender("Male")
                .setUserNumber("8905478547")
                .setBirthDate("1996","July","07")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .uploadPicture("user.jpg")
                .setCurrentAddress("Moscow")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmitButton();

        practiceFormPage.checkVisible()
                .checkTableElement("Student Name","Alex Nyashin")
                .checkTableElement("Student Email","nyashin@test.com")
                .checkTableElement("Gender", "Male")
                .checkTableElement("Mobile", "8905478547")
                .checkTableElement("Date of Birth", "07 July,1996")
                .checkTableElement("Subjects", "Maths")
                .checkTableElement("Hobbies", "Sports")
                .checkTableElement("Picture", "user.jpg")
                .checkTableElement("Address", "Moscow")
                .checkTableElement("State and City", "NCR Delhi");

    }
    @Test
    void fillMinPracticeForm() {

        practiceFormPage.openPage()
                .setFirstName("Alex")
                .setLastName("Nyashin")
                .setGender("Male")
                .setUserNumber("8905478547")
                .setBirthDate("1996","July","07")
                .clickSubmitButton();

        practiceFormPage.checkVisible()
                .checkTableElement("Student Name","Alex Nyashin")
                .checkTableElement("Gender", "Male")
                .checkTableElement("Mobile", "8905478547")
                .checkTableElement("Date of Birth", "07 July,1996");
    }
}