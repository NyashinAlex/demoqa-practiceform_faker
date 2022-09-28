package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PracticeFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomGenerateData.*;

public class PracticeFormTests {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    Faker faker = new Faker();
    String firstName,
            lastName,
            userEmail,
            gender,
            userNumber,
            birthDate,
            year,
            month,
            day,
            subjects,
            hobbies,
            picture = "user.jpg",
            currentAddress,
            state,
            city;
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @BeforeEach
    void generationData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().safeEmailAddress(firstName + lastName);
        gender = choiceGender();
        userNumber = faker.phoneNumber().subscriberNumber(10);
        birthDate =  String.valueOf(generateBirthDate());
        year = birthDate.substring(0,4);
        month = getMonthText(birthDate.substring(5,7));
        day = birthDate.substring(8);
        subjects = choiceSubject();
        hobbies = choiceHobbies();
        currentAddress = faker.address().fullAddress();
        state = choiceState();
        city = choiceCity(state);
    }

    @Test
    void fillPracticeForm() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(year, month, day)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        practiceFormPage.checkVisible()
                .checkTableElement("Student Name",firstName + " " + lastName)
                .checkTableElement("Student Email",userEmail)
                .checkTableElement("Gender", gender)
                .checkTableElement("Mobile", userNumber)
                .checkTableElement("Date of Birth", day + " " + month + "," + year)
                .checkTableElement("Subjects", subjects)
                .checkTableElement("Hobbies", hobbies)
                .checkTableElement("Picture", picture)
                .checkTableElement("Address", currentAddress)
                .checkTableElement("State and City", state + " " + city);

    }
    @Test
    void fillMinPracticeForm() {

        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(year, month, day)
                .clickSubmitButton();

        practiceFormPage.checkVisible()
                .checkTableElement("Student Name",firstName + " " + lastName)
                .checkTableElement("Gender", gender)
                .checkTableElement("Mobile", userNumber)
                .checkTableElement("Date of Birth", day + " " + month + "," + year);
    }
}