package pageObjects.user;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.HomePageUI;

public class UserHomePageObject extends CommonPageObject {

    private WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPageObject clickToResgisterLink() {
        clickToElement(driver, HomePageUI.REGISTER_CLICK);
        return PageGeneratorManager.getUserRegisterPage(driver);
    }

    public UserLoginPageObject clickToLoginLink() {
        clickToElement(driver, HomePageUI.LOGIN_CLICK);
        return PageGeneratorManager.getUserLoginPage(driver);
    }

    public String getTopicBlockTitle() {
        return getElementText(driver, HomePageUI.TOPIC_BLOCK_TITLE);
    }

}
