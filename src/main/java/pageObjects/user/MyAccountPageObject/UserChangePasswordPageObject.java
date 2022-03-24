package pageObjects.user.MyAccountPageObject;

import org.openqa.selenium.WebDriver;
import pageObjects.user.CommonPageObject;
import pageUIs.user.MyAccountPageUI.ChangePasswordPageUI;

public class UserChangePasswordPageObject extends CommonPageObject {
    private WebDriver driver;

    public UserChangePasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void changePasswordForm(String oldPassword, String newPassword) {
        senkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);
        senkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
        senkeyToElement(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, newPassword);

        clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
    }
}
