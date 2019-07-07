package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class Login {

    @Test
    public void loginTestPOM() {
//    1. Initialize driver
        WebDriver driver = DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
//    2. Enter login information (Login page)
//    3. Get confirmation (Dashboard Page
//    4. Close the driver
        driver.close();
    }
}
