package stepImplementations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class BDDLoginTest {
    private WebDriver driver;

    private String username = "tim@testemail.com";
    private String password = "trpass";

    @Given("^user is on the login page$")
    public void user_is_on_the_login_page() {

        System.out.println("User is on the login page");
//        open driver
        driver = DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
    }

    @When("^user enters correct username and correct password$")
    public void user_enters_correct_username_and_correct_password() {
        System.out.println("User enters correct username and correct password");
        driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
        driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
        driver.findElement(By.id("MainContent_btnLogin")).click();
    }

    @When("^user enters (.*)$")
    public void user_enters_username(String username) {
        System.out.println("TESTING: " + username);
        driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);

    }

    @And("^user enters <password>$")
    public void user_enters_password(String password) {
        driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);

    }

    @Then("^user gets confirmation$")
    public void user_gets_confirmation() {
        System.out.println("User gets confirmation");
        Assert.assertTrue(driver.findElement(By.id("conf_message"))
                .getText().contains("success"));
        driver.close();
    }
}
