package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

//    Define web element at class level

    private WebDriver driver;

    @FindBy(id = "MainContent_txtUserName")
    private WebElement usernameBox;

    @FindBy(id = "MainContent_txtPassword")
    private WebElement passwordBox;

    @FindBy(id = "MainContent_btnLogin")
    private WebElement loginButton;

    //    Actions
    private void setUserName(String username) {
        usernameBox.sendKeys(username);
    }

    private void setPassword(String password) {
        passwordBox.sendKeys(password);
    }

    private void clickSubmit() {
        loginButton.click();
    }

    //    Actions
    public void login(String username, String password) {
        setUserName(username);
        setPassword(password);
        clickSubmit();
    }

    //    Constructor initilizes the state of the driver
    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
//        Initialize web elements
        PageFactory.initElements(driver, this);
    }
}
