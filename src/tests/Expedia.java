package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;

public class Expedia {

    private WebDriver driver;
    private String browserType = "chrome";
    private String city = "New York, New York";
    private String checkIn = "07/07/2019";
    private String checkOut = "07/14/2019";
//    private String numOfGuest = "2";

    @Test
    public void hotelReservation() {

//        1. Search
            driver.findElement(By.id("tab-hotel-tab-hp")).click();
            driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
            driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
            driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
//            new Select(driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[4]/div[4]/label/select")))
//                    .selectByValue(numOfGuest);
            driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[10]/label/button")).click();
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
