package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import pages.searchPage;

public class search {
    public static WebDriver driver;
    public static WebDriverWait mywait;
    searchPage search;
    @Given("User is on ESPN home page with url {string}")
    public void user_is_on_espn_home_page_with_url(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        mywait=new WebDriverWait(driver,Duration.ofSeconds(5));
        search=new searchPage(driver);
    }
    @And("Search button is clicked")
    public void search_button_is_clicked() {
        search.search_click();
    }
    @When("User enters input name {string}")
    public void user_enters_input_name(String name) {
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("global-search-input")));
        search.data_entry(name);
    }
    @And("press enter key")
    public void press_enter_key() {
        search.click_enter();
    }
    @Then("Player card for the searched player is displayed")
    public void player_card_for_the_searched_player_is_displayed() {
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.className("player__Results__Item")));
        search.result();
    }
}
