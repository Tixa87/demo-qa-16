package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.components.RandomGenerator;

public class DemoqaTestWithPageObjects extends TesBase {

    @Test

     void fillFormTest() {
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String numberMobile = faker.phoneNumber().subscriberNumber(10);
        String dayBirth = String.valueOf(faker.number().numberBetween(10, 28));
        String yearBirth = String.valueOf(faker.number().numberBetween(1900, 2000));
        String monthBirth = RandomGenerator.randomBirthMonth();
        String dateOfBirth = dayBirth + " "+ monthBirth + "," + yearBirth;
        String userGender = RandomGenerator.randomUserGender();
        String subjects = RandomGenerator.randomUserSub();
        String hobby = RandomGenerator.randomUserHobby();
        String filename ="приветственное фото.jpg";
       //String pathFileName = "img/приветственное фото.jpg";
        String currentAddress = faker.address().streetAddress();
        String state = "NCR";
        String city = "Gurgaon";

       registrationPage.openPage()
               .setFirstName(firstName)
               .setLastName(lastName)
               .setEmail(userEmail)
               .setGender(userGender)
               .setPhone(numberMobile)
               .setBirthDate(dayBirth, monthBirth, yearBirth)
               .selectSubject(subjects)
               .selectHobby(hobby)
               .uploadPicture(filename)
               .setCurrentAddress(currentAddress)
               .setState(state)
               .setCity(city)
               .sendForm();

       //RandomGenerator.randomUserGender()
        //       .;

       registrationPage.verifyResultsModalAppears()
               .verifyResult("Student Name", firstName + " " + lastName)
               .verifyResult("Student Email", userEmail)
               .verifyResult("Gender", userGender)
               .verifyResult("Mobile", numberMobile)
               .verifyResult("Date of Birth", dateOfBirth)
               .verifyResult("Subjects", subjects)
               .verifyResult("Hobbies", hobby)
               .verifyResult("Picture", filename)
               .verifyResult("Address", currentAddress)
               .verifyResult("State and City", state + " " + city);
    }
}
