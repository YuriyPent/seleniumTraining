package demos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main (String[] args){

        //1. Define the web driver
        System.setProperty("webdriver.chrome.driver", "sf/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        2. Open web browser and navigate to page
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
    }
}
