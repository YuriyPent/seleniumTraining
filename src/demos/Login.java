package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main (String[] args){

        //1. Define the web driver
        System.setProperty("webdriver.chrome.driver", "sf/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //2. Open web browser and navigate to page
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        //3. Enter email address
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");

        //4. Enter password
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");

        //5. Click login
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
    }
}
