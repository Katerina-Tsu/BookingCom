package steps;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class BookingSteps {
    String city;

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void quit() {
        WebDriverRunner.getWebDriver().quit();
    }

    @Given("User is looking for {string} city")
    public void userIsLookingForCity(String city) {
        this.city = city;
    }

    @When("User does search")
    public void userDoesSearch() {
        open("https://www.booking.com/");
        $(By.id("ss")).sendKeys(city);
        $(".sb-searchbox__button").click();

    }

    @Then("Hotel {string} should be on the first page")
    public void hotelShouldBeOnTheFirstPage(String hotel) {
//        ArrayList<String> hotelNames = new ArrayList<>();
//        for (SelenideElement element : $$(".sr-hotel__name")) {
//            hotelNames.add(element.getText());
//        }
//        Assert.assertTrue(hotelNames.contains(hotel));
        assertThat($$(".sr-hotel__name").texts(), hasItem(hotel));
    }

    @And("Rating of the {string} is {string}")
    public void ratingOfTheDoubleTreeByHiltonМинскIs(String hotel, String rating) {

    }
}
