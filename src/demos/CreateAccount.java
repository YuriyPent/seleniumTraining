package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

    public static void main(String[] args) {

//        1. Create WebDriver
//        System.setProperty("webdriver.gecko.driver", "sf/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "sf/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        2. Open browser to account page --> click create account
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
//        driver.findElement(By.linkText("Create Account")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();

//        3. Fill out the form
//        How to locate elements
        driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Mary Smith");
        driver.findElement(By.id("MainContent_txtEmail")).sendKeys("ms@testemail.com");
        driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("123456789");
        driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("mspass");
        driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("mspass");

//          How to interact with other HTML elements
        driver.findElement(By.id("MainContent_Female")).click();
        new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("United States");
        driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
        driver.findElement(By.id("MainContent_btnSubmit")).click();

//       4. Get confirmation
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("CONFIRMATION: " + conf);

//      5. Close the browser
        driver.close();
    }
}
