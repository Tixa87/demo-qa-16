package tests;

import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;

public class DemoqaTestWithPageObjects extends TesBase {

    @Test

     void fillFormTest() {
        Faker faker = new Faker();
        String firstName = "Alexandra ";
        String lastName = "Ilina";
        String userEmail = "test@test.com";
        String numberMobile = "1234567890";
        String subjects = "Maths";
        String hobby = "Sports";
        String filename ="приветственное фото.jpg";
       //String pathFileName = "img/приветственное фото.jpg";
        String currentAddress = "Rozino BB";
        String state = "NCR";
        String city = "Gurgaon";

       registrationPage.openPage()
               .setFirstName(firstName)
               .setLastName(lastName)
               .setEmail(userEmail)
               .setGender("Female")
               .setPhone(numberMobile)
               .setBirthDate("23", "August", "1987")
               .selectSubject(subjects)
               .selectHobby(hobby)
               .uploadPicture(filename)
               .setCurrentAddress(currentAddress)
               .setState(state)
               .setCity(city)
               .sendForm();

       registrationPage.verifyResultsModalAppears()
               .verifyResult("Student Name", firstName + lastName)
               .verifyResult("Student Email", userEmail)
               .verifyResult("Gender", "Female")
               .verifyResult("Mobile", numberMobile)
               .verifyResult("Date of Birth", "23 August,1987")
               .verifyResult("Subjects", subjects)
               .verifyResult("Hobbies", hobby)
               .verifyResult("Picture", filename)
               .verifyResult("Address", currentAddress)
               .verifyResult("State and City", state + " " + city);
    }
}
