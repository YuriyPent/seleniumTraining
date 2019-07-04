package smoketests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {

    @Test
    public void pageTitleTest(){

        String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
        WebDriver driver = utilities.DriverFactory.open("chrome");
        driver.get(webURL);
        String actualTitle = driver.getTitle();
        String expectedTitle = "SDET Training | Account Management";
    }
}
