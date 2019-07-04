package smoketests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {

    @Test
    public void pageTitleTest(){

        String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
        WebDriver driver = utilities.DriverFactory.open("chrome");
        driver.get(webURL);
        String actualTitle = driver.getTitle();
        System.out.println("ACTUAL TITLE IS: " + actualTitle);
        String expectedTitle = "SDET Training | Account Management";
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
