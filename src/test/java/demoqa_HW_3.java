import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SetValueOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class demoqa_HW_3 {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";}

    @Test

     void fillFormTest() {

        String firstName = "Alexandra";
        String lastName = "Ilina";
        String userEmail = "test@test.com";
        String NumberMobile = "1234567890";
        String subjects = "Maths";
       // File image = File(" не успела еще разобраться как и где размещать файл");
        String Current_Address = "Rozino BB";

        open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(NumberMobile);

       // BirthDay Window
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__day--023").click();

        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        // $("#uploadPicture").uploadFile(image);
        $("#currentAddress").setValue(Current_Address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();


        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alexandra Ilina"), text(userEmail), text("23 August,1987"), text("Female"), text(subjects), text(Current_Address));




    }
}
