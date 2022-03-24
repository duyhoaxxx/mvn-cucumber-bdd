package pageObjects.user.MyAccountPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.user.CommonPageObject;
import pageUIs.user.MyAccountPageUI.MyProductReviewsPageUI;

import java.util.List;

public class UserMyProductReviewsPageObject extends CommonPageObject {
    private WebDriver driver;

    public UserMyProductReviewsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMyProductReviewTitleDisplayed(String rvTitle) {
        List<WebElement> allTitle = getListWebElement(driver, MyProductReviewsPageUI.ALL_TITLE_MY_PRODUCT_REVIEWS);
        for (WebElement element : allTitle) {
            if(element.getText().equals(rvTitle))
                return true;
        }
        return false;
    }

    public boolean isMyProductReviewTextDisplayed(String rvText) {
        List<WebElement> allText = getListWebElement(driver, MyProductReviewsPageUI.ALL_TEXT_MY_PRODUCT_REVIEWS);
        for (WebElement element : allText) {
            if(element.getText().equals(rvText))
                return true;
        }
        return false;
    }
}
