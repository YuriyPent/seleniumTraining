package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    //    This method return a WebDriver object
    public static WebDriver open(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "sf/chromedriver.exe");
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "sf/IEDriverServer.exe");
            return new InternetExplorerDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "sf/geckodriver.exe");
            return new FirefoxDriver();
        }
    }
}
