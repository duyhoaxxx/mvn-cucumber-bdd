package pageObjects.user.MenuPageObject;

import org.openqa.selenium.WebDriver;
import pageObjects.user.CommonPageObject;
import pageUIs.user.MenuPageUI.CompareProductsPageUI;

public class UserCompareProductsPageObject extends CommonPageObject {
    private WebDriver driver;

    public UserCompareProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameDisplay(String productName) {
        if (isElementUndisplayed(driver, CompareProductsPageUI.PRODUCT_BY_NAME, productName))
            return false;
        return true;
    }

    public void clickToClearListButton() {
        clickToElement(driver, CompareProductsPageUI.CLEAR_LIST_BUTTON);
    }

    public String getResultMessage() {
        return getElementText(driver, CompareProductsPageUI.NO_DATA_MESSAGE);
    }
}
