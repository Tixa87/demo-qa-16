import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DemoqaHW3 {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";}

    @Test

     void fillFormTest() {

        String firstName = "Alexandra";
        String lastName = "Ilina";
        String userEmail = "test@test.com";
        String numberMobile = "1234567890";
        String subjects = "Maths";
        String current_Address = "Rozino BB";

        open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(numberMobile);

       // BirthDay Window
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__day--023").click();

        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/приветственное фото.jpg"));
        $("#currentAddress").setValue(current_Address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();


        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alexandra Ilina"), text(userEmail), text(numberMobile), text("23 August,1987"), text("Female"), text(subjects), text(current_Address), text("приветственное фото"));




    }
}
