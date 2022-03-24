package pageObjects.user.MenuPageObject;

import org.openqa.selenium.WebDriver;
import pageObjects.user.CommonPageObject;

public class UserRecentlyViewedProductsPageObject extends CommonPageObject {
    private WebDriver driver;

    public UserRecentlyViewedProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
