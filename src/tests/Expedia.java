package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;

public class Expedia {

    private WebDriver driver;
    private String browserType = "chrome";

    @Test
    public void hotelReservation() {

//        1. Search

//        2. Modify the search results page, give criteria

//        3. Analyze the results and make our selection

//        4. Book reservation

//        5. Fill out contact / billing

//        6. Get confirmation

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.open(browserType);
        driver.get("https://www.expedia.com");
    }
}
