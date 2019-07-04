package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

    public static void main(String[] args) {

        String name = "Mary Smith";
        String email = "ms@testemail.com";
        String password = "mspass";
        String country = "United States";
        String phoneNumber = "123456789";

        String gender;
        String weeklyEmail;
        String monthlyEmail;
        String occassionalEmail;

        String browserType = "chrome";
        WebDriver driver;

//        1. Create WebDriver
        if (browserType.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "sf/chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("Using Chrome");
        } else if (browserType.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "sf/geckodriver.exe");
            driver = new FirefoxDriver();
            System.out.println("Using FF");
        } else {
            System.setProperty("webdriver.chrome.driver", "sf/chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("Using Chrome");
        }

//        2. Open browser to account page --> click create account
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();

//        3. Fill out the form
//        How to locate elements
        driver.findElement(By.name("ctl00$MainContent$txtFirstName"))
                .sendKeys(name);
        driver.findElement(By.id("MainContent_txtEmail"))
                .sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"))
                .sendKeys(phoneNumber);
        driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"))
                .sendKeys(password);
        driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"))
                .sendKeys(password);

//          How to interact with other HTML elements
        driver.findElement(By.id("MainContent_Female")).click();
        new Select(driver.findElement(By.id("MainContent_menuCountry")))
                .selectByVisibleText(country);
        driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
        driver.findElement(By.id("MainContent_btnSubmit")).click();

//       4. Get confirmation
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("CONFIRMATION: " + conf);

//      5. Close the browser
        driver.close();

    }
}
