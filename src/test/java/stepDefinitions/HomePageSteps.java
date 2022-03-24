package stepDefinitions;

import cucumberOptions.Hooks;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageObjects.user.CommonPageObject;
import pageUIs.user.HomePageUI;


public class HomePageSteps extends CommonPageObject {
    WebDriver driver;


    public HomePageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
    }

    @Given("Click Register Header")
    public void clickRegisterHeader() {
        clickToElement(driver, HomePageUI.REGISTER_CLICK);
    }

    @Given("Click Login Header")
    public void clickLoginHeader() {
        clickToElement(driver, HomePageUI.LOGIN_CLICK);
    }
}
