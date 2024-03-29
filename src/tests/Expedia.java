package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Expedia {

    private WebDriver driver;
    private String browserType = "chrome";
    private String city = "New York, New York";
    private String checkIn = "07/07/2019";
    private String checkOut = "07/14/2019";
    private String pricePerNight125 = "price-1-1";
    private String propertyTypeHotel = "popularFilter-0-hotel";
    private String search = "//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[10]/label/button";
    private String cityName = "//*[@id=\"app\"]/div/div/div/div/div[1]/div/section/div/form/div[1]/div/div/button";
    private String searchResult = "3";

    @Test
    public void hotelReservation() {

//        1. Search
        driver.findElement(By.id("tab-hotel-tab-hp")).click();
        driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
        driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
        driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
        driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
        driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
        driver.findElement(By.xpath(search)).click();

//        Print the name of the city
        String actualCity = driver.findElement(By.xpath(cityName)).getText();
        System.out.println("CITY: " + actualCity);

//        2. Modify the search results page, give criteria

//      price per night $75-125
        driver.findElement(By.id(pricePerNight125)).click();
//      Property Type
        driver.findElement(By.id(propertyTypeHotel)).click();

//        3. Analyze the results and make our selection
        driver.findElement(By.xpath(
                "//*[@id=\"app\"]/div/div/div/div/div[1]/main/div/div/div[2]/section[1]/ol/li[" + searchResult + "]/div/div/a")).click();
//          Switch the window to the top
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

//        Print hotel name and rating
        String hotelName = driver.findElement(
                By.xpath("//*[@id=\"app\"]/div/div/div/main/div[1]/div[1]/div/div/section[1]/div/h1")).getText();
        String hotelRating = driver.findElement(
                By.xpath("//*[@id=\"app\"]/div/div/div/main/div[1]/div[1]/div/div/section[2]/section/div/span/span[1]/span")).getText();
        System.out.println("HOTEL: " + hotelName);
        System.out.println("RATING: " + hotelRating);

//        4. Book reservation
        driver.findElement(
                By.xpath("//*[@id=\"app\"]/div/div/div/main/div/section/ul/li[1]/div/div/div/section/div/div[2]/div[2]/div/form/button/span/span/span")).click();
        String hotelPrice = driver.findElement(By.xpath("//*[@id=\"trip-summary\"]/div[2]/div[3]/div[7]/span[2]")).getText();
        System.out.println("PRICE IS: " + hotelPrice);

//        5. Fill out contact / billing

//        6. Get confirmation
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Payment"));

    }

    @AfterMethod
    public void tearDown() throws Exception {
//        driver.quit();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = DriverFactory.open(browserType);
        driver.get("https://www.expedia.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().fullscreen();
    }
}
