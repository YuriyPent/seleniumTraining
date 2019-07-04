package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {

    @Test
    public void pageTitleTest(){

        System.out.println("Running the test");
        String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
        WebDriver driver = utilities.DriverFactory.open("chrome");
        driver.get(webURL);
        String actualTitle = driver.getTitle();
        System.out.println("ACTUAL TITLE IS: " + actualTitle);
        String expectedTitle = "SDET Training | Account Management";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Before
    public void setUp(){
        System.out.println("Setting up the test");
    }

    @After
    public void tearDown(){
        System.out.println("Closing the test");
    }
}
