package pageObjects.user.MenuPageObject;

import org.openqa.selenium.WebDriver;
import pageObjects.user.CommonPageObject;
import pageUIs.user.MenuPageUI.SearchPageUI;

public class UserSearchPageObject extends CommonPageObject {
    private WebDriver driver;

    public UserSearchPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSearchButton() {
        clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
    }

    public String getErrMessage() {
        return getElementText(driver, SearchPageUI.ERR_MESSAGE);
    }

    public void inputToKeywordTextbox(String keyword) {
        senkeyToElement(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, keyword);
    }

    public void advancedSearch(boolean status) {
        if (isElementSelected(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX) != status)
            clickToElement(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
    }

    public void searchKeywordBasicForm(String keyword) {
        inputToKeywordTextbox(keyword);
        advancedSearch(false);
        clickToSearchButton();
    }

    public String getResultMessage() {
        waitForElementVisible(driver, SearchPageUI.NO_RESULT_MESSAGE);
        return getElementText(driver, SearchPageUI.NO_RESULT_MESSAGE);
    }

    public int getNumberResult() {
        return getElementSize(driver, SearchPageUI.ALL_RESULTS_SEARCH);
    }

    public boolean isProductSearchDisplay(String nameProduct) {
        if (isElementUndisplayed(driver, SearchPageUI.RESULTS_SEARCH_PRODUCT_BY_NAME, nameProduct))
            return false;
        return true;
    }

    public void selectCategory(String category) {
        selectItemInDefaultDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN, category);
    }

    public void selectManufacturer(String manufacturer) {
        selectItemInDefaultDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, manufacturer);
    }

    public void automaticallySearchSubCategories(boolean status) {
        if (isElementSelected(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX) != status)
            clickToElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
    }

    public void searchInProductDescriptions(boolean status) {
        if (isElementSelected(driver, SearchPageUI.SEARCH_IN_PRODUCT_DESCRIPTIONS_CHECKBOX) != status)
            clickToElement(driver, SearchPageUI.SEARCH_IN_PRODUCT_DESCRIPTIONS_CHECKBOX);
    }

    public void searchKeywordAdvancedForm(String keyword, String category, boolean isAutoSearch, String manufacturer, boolean isSearchInPD) {
        inputToKeywordTextbox(keyword);
        advancedSearch(true);
        selectCategory(category);
        automaticallySearchSubCategories(isAutoSearch);
        selectManufacturer(manufacturer);
        searchInProductDescriptions(isSearchInPD);

        clickToSearchButton();
    }
}
