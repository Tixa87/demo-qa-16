package Tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DemoqaTestWithPageObjects extends TesBase {


    @Test

     void fillFormTest() {

       String firstName = "Alexandra";
       String lastName = "Ilina";
       String userEmail = "test@test.com";
       String numberMobile = "1234567890";
       String subjects = "Maths";
       String hobby = "Sports";
       String filename ="приветственное фото";
       String pathFileName = "images/" + filename;
       String current_Address = "Rozino BB";
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
               .uploadPicture(pathFileName)
               .setCurrentAddress(current_Address)
               .setState(state)
               .setCity(city)
               .sendForm();



       registrationPage.verifyResultsModalAppears()
               .verifyResult("Student Name", firstName + lastName)
               .verifyResult("Student Email", userEmail)
               .verifyResult("Gender", "Female")
               .verifyResult("Mobile", numberMobile)
               .verifyResult("Date of Birth", "23 August,1897")
               .verifyResult("Subjects", subjects)
               .verifyResult("Hobbies", hobby)
               .verifyResult("Picture", filename)
               .verifyResult("Address", current_Address)
               .verifyResult("State and City", state + " " + city);




    }
}
