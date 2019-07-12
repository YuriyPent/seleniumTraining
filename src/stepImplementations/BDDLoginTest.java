package stepImplementations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BDDLoginTest {

//    WebDriver driver;

    @Given("^user is on the login page$")
    public void user_is_on_the_login_page() {
        System.out.println("User is on the login page");
    }

    @When("user enters correct username and correct password")
    public void user_enters_correct_username_and_correct_password() {
        System.out.println("User enters correct username and correct password");
    }

    @Then("user gets confirmation")
    public void user_gets_confirmation() {
        System.out.println("User gets confirmation");
    }
}
