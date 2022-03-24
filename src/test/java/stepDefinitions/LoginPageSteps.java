package stepDefinitions;

import cucumberOptions.Hooks;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.user.CommonPageObject;
import pageUIs.user.HomePageUI;

public class LoginPageSteps extends CommonPageObject {
    WebDriver driver;

    public LoginPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }

    private String getLoginSuccess(){
        return getElementText(driver, HomePageUI.TOPIC_BLOCK_TITLE);
    }

    @Then("Verify Login Success")
    public void verifyLoginSuccess() {
        Assert.assertEquals(getLoginSuccess(), "Welcome to our store");
    }

}
