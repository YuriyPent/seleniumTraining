package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.DriverFactory;

public class Login {

    @Test
    public void loginTestPOM() {

//    1. Initialize driver
        WebDriver driver = DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

//    2. Enter login information (Login page)
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("tim@testemail.com");
        loginPage.setPassword("trpass");
        loginPage.clickSubmit();

//    3. Get confirmation (Dashboard Page)
        DashboardPage dashboardPage = new DashboardPage(driver);
        String conf = dashboardPage.confirmationMessage();
        System.out.println(conf);
        String title = dashboardPage.title();

//        Assertions
        Assert.assertTrue(conf.contains("Logged in successfully"));
        Assert.assertTrue(title.contains("Account"));

//    4. Close the driver

        driver.close();
    }
}
