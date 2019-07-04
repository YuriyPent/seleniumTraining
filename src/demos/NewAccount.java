package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

    public static void main(String[] args) {

        String name = "Mary Smith";
        String email = "ms@testemail.com";
        String password = "mspass";
        String country = "United States";
        String phoneNumber = "123456789";
        String browserType = "chrome";

        String gender = "Female";
        boolean weeklyEmail = true;
        boolean monthlyEmail = false;
        boolean occassionalEmail = false;

//      Define WebDriver
        WebDriver driver;
        driver = utilities.DriverFactory.open(browserType);
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();

//      Define web elements
        WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        WebElement passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
        WebElement verifypasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
        WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        WebElement maleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
        WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
        WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));

//      Fill out the form
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phoneNumber);
        passwordElement.sendKeys(password);
        verifypasswordElement.sendKeys(password);
        new Select(countryElement).selectByVisibleText(country);

//      Gender radio button algorithm
        if (gender.equalsIgnoreCase("Male")) {
            maleRadio.click();
        } else {
            femaleRadio.click();
        }
//      Check box algorithm
        if (weeklyEmail) {
            if (!weeklyCheckbox.isSelected()) {
                weeklyCheckbox.click();
            }
        } else {
            if (weeklyCheckbox.isSelected()) {
                weeklyCheckbox.click();
            }
        }

        driver.findElement(By.id("MainContent_btnSubmit")).click();

//      Get confirmation & close the browser
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("CONFIRMATION: " + conf);
        driver.close();
    }
}
