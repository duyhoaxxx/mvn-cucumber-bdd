package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FBSteps {
    WebDriver driver;

    @Given("Open Web")
    public void openWeb() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Then("Verify email textbox displayed")
    public void verifyEmailTextboxDisplayed() {
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
    }

    @And("Verify password textbox displayed")
    public void verifyPasswordTextboxDisplayed() {
        Assert.assertTrue(driver.findElement(By.id("pass")).isDisplayed());
    }

    @And("Close Web")
    public void closeWeb() {
        driver.quit();
    }

    @When("Input to User and Password")
    public void inputToUserAndPassword(DataTable table) {
        List<Map<String,String>> customer = table.asMaps(String.class,String.class);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(customer.get(0).get("User"));
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(customer.get(0).get("Password"));
    }
}
