package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationresultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationresultsModal registrationresultsModal = new RegistrationresultsModal();

    private final String TITLE_NAME = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbyCheckBoxes = $("#hobbiesWrapper"),
            uploadFileInput = $("#uploadPicture"),
            currentAddressTextArea = $("#currentAddress"),
            stateSelect = $("#state"),
            citySelect = $("#city"),
            cityAndStateList = $("#stateCity-wrapper"),
            SendFormButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_NAME));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmail.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genterWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage selectSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage selectHobby(String hobby) {
        hobbyCheckBoxes.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String fileNamePath) {
        uploadFileInput.uploadFromClasspath(fileNamePath);

        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressTextArea.setValue(currentAddress);

        return this;
    }

    public RegistrationPage setState(String state) {
        stateSelect.click();
        cityAndStateList.$(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        citySelect.click();
        cityAndStateList.$(byText(city)).click();

        return this;
    }

    public RegistrationPage sendForm() {
        SendFormButton.scrollTo().click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationresultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationresultsModal.verifyResult(key, value);

        return this;
    }

}