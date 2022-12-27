package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import pages.footballSectionPage;

public class footballSection {
    public static WebDriver driver;
    footballSectionPage football;
    @Given("User is on home page with url {string}")
    public void user_is_on_home_page_with_url(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
    }
    @When("User clicks on football button")
    public void user_clicks_on_football_button() {
        football= new footballSectionPage(driver);
        football.click_football();
    }
    @And("clicks on teams dropdown and select a team")
    public void clicks_on_teams_dropdown_and_select_a_team(){
        football.select_chelsea();
    }
    @And("clicks on fixtures")
    public void clicks_on_fixtures() {
        football.click_fixture();
    }
    @Then("Table for scheduled matches of selected team is displayed")
    public void table_for_scheduled_matches_of_selected_team_is_displayed() {
        football.result();
    }
    @When("clicks on results")
    public void clicks_on_results() {
        football.click_result();
    }
    @Then("Table for the results of selected team is displayed")
    public void table_for_the_results_of_selected_team_is_displayed() {
        football.display_result();
    }
    @And("select a competition from competitions dropdown")
    public void select_a_competition_from_competitions_dropdown() {
        football.select_compi();
    }
    @Then("Fixture for selected competition of selected team is displayed")
    public void fixture_for_selected_competition_of_selected_team_is_displayed() {
        football.verify_dropdown();
    }
    @And("clicks on tournaments dropdown and select FIFA World Cup")
    public void clicks_on_tournaments_dropdown_and_select_fifa_world_cup() {
        football.select_FIFA();
    }
    @And("clicks on fixtures & results")
    public void clicks_on_fixtures_results() {
        football.click_fix_res();
    }
    @Then("Results of latest match and schedule of upcoming match is displayed")
    public void results_of_latest_match_and_schedule_of_upcoming_match_is_displayed() {
        football.display_table_data();
    }
}
