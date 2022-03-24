package stepDefinitions;

import cucumberOptions.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.user.CommonPageObject;
import pageUIs.user.BasePageUserUI;
import pageUIs.user.RegisterPageUI;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class RegisterPageSteps extends CommonPageObject {
    WebDriver driver;
    static String email, fName, lName, password;

    public RegisterPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }


    private String fakeEmail() {
        return "AutoTest" + (new Random().nextInt(999999)) + "@gmail.com";
    }

    private void inputToFirstNameTextbox(String firstName) {
        senkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    private void inputToLastNameTextbox(String lastName) {
        senkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    private void inputToEmailTextbox(String email) {
        senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    private void inputToPasswordTextbox(String password) {
        senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    private void inputToConfirmPasswordTextbox(String password) {
        senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    private void clickToRegisterButton() {
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    private String getSuccessRegisterMessage() {
        return getElementText(driver, RegisterPageUI.RESGISTER_SUCCESS_MESSAGE);
    }

    @When("Input Register Form")
    public void inputRegisterForm(DataTable table) {
        List<Map<String, String>> customer = table.asMaps(String.class, String.class);
        fName = customer.get(0).get("First Name");
        lName = customer.get(0).get("Last Name");
        email = fakeEmail();
        password = customer.get(0).get("Password");
        inputToFirstNameTextbox(fName);
        inputToLastNameTextbox(lName);
        inputToEmailTextbox(email);
        inputToPasswordTextbox(password);
        inputToConfirmPasswordTextbox(password);
        clickToRegisterButton();
    }

    @Then("Verify Register Success")
    public void verifyRegisterSuccess() {
        Assert.assertEquals(getSuccessRegisterMessage(), "Your registration completed");
    }

    @And("Logout Account")
    public void logoutAccount() {
        clickToElement(driver, BasePageUserUI.LOGOUT_LINK_AT_USER);
    }
}
