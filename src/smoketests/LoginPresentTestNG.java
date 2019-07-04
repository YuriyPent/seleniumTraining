package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverFactory;

public class LoginPresentTestNG {

    @Test
    public void LoginElementsPresentTest(){

        WebDriver driver = DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName"))
                .isDisplayed();
        boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword"))
                .isDisplayed();

        Assert.assertTrue(loginEmailBox, "Email textbox present");
        Assert.assertTrue(passwordBox, "Password textbox present");
    }
}
