package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import pages.topEventsPage;

public class topEvents {
    public static WebDriver driver;
    public static topEventsPage topevent;
    WebDriverWait mywait;
    @Given("User is on Home page with url {string}")
    public void user_is_on_home_page_with_url(String url) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        mywait= new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @When("User clicks on the Top events button and select an event")
    public void user_clicks_on_the_top_events_button_and_select_an_event(){
       topevent= new topEventsPage(driver);
       topevent.select_event();
    }
    @When("Select the date")
    public void select_the_date() {
        topevent.select_date();
    }
    @Then("Result of match is displayed of selected date")
    public void result_of_match_is_displayed_of_selected_date() {
        topevent.display_result();
    }
    @When("User clicks on the Top events button and select world cup event")
    public void user_clicks_on_the_top_events_button_and_select_world_cup_event() {
        topevent.select_fifa();
    }
    @And("select date")
    public void select_date(){
        topevent.select_date1();
    }
    @And("Click on Summary of any match")
    public void click_on_summary_of_any_match() {
        topevent.select_summ();
    }
    @Then("User is redirected to the summary page of match")
    public void user_is_redirected_to_the_summary_page_of_match() {
        mywait.until(ExpectedConditions.titleContains("Argentina vs."));
        System.out.println(driver.getTitle());
    }
    @And("The summary and details of the match")
    public void the_summary_and_details_of_the_match() {
        topevent.result_fifa();
    }
}
