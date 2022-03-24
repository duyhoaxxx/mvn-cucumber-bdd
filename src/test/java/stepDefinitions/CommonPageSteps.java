package stepDefinitions;

import cucumberOptions.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.user.CommonPageObject;

public class CommonPageSteps extends CommonPageObject {
    WebDriver driver;

    public CommonPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }

    @When("Input to {string} textbox with value {string}")
    public void inputToTextboxWithValue(String fieldName, String value) {
        if (fieldName.equals("Email"))
            value = RegisterPageSteps.email;
        EnterToTextboxByID(driver, fieldName, value);
    }

    @And("Click to {string} button")
    public void clickToButton(String value) {
        ClickToButtonByText(driver, value);
    }
}
