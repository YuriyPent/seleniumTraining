package tests;

import org.openqa.selenium.WebDriver;
import pages.LoginPageFactory;
import utilities.DriverFactory;

public class LoginFactory {

    private String username = "tim@testemail.com";
    private String password = "trpass";

    public void loginTestPageFactory() {

//        1. Initialize driver
        WebDriver driver = DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

//        2. Enter login
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(username, password);
    }
}
