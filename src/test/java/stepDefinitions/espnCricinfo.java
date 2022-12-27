package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import pages.espnCricinfoPage;

public class espnCricinfo {
    WebDriver driver;
    espnCricinfoPage espncricinfo;
    @Given("User is on home page of ESPN website with url {string}")
    public void user_is_on_home_page_of_espn_website_with_url(String url) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
    }
    @And("User clicks on ESPN Cricinfo Button in apps section")
    public void user_clicks_on_espn_cricinfo_button_in_apps_section() throws InterruptedException {
        espncricinfo= new espnCricinfoPage(driver);
        espncricinfo.getcricinfosite();
    }
    @And("User is redirected to ESPN Cricinfo website")
    public void user_is_redirected_to_espn_cricinfo_website() {
        espncricinfo.redirecttocricinfo();
    }
    @And("User click on teams dropdown and select India")
    public void user_click_on_teams_dropdown_and_select_india() {
        espncricinfo.select_Ind();
    }
    @When("User click on teams dropdown and select New Zealand")
    public void user_click_on_teams_dropdown_and_select_new_zealand() {
        espncricinfo.select_NZ();
    }
    @And("User is redirected to the page having results of New Zealand team")
    public void user_is_redirected_to_the_page_having_results_of_new_zealand_team() {
        espncricinfo.NZ_page();
    }
    @And("User clicks on the result button present on home tab")
    public void user_clicks_on_the_result_button_present_on_home_tab() {
        espncricinfo.click_result();
    }
    @When("User clicks on Bangladesh v India series in key series panel")
    public void user_clicks_on_bangladesh_v_india_series_in_key_series_panel() {
        espncricinfo.click_indvban();
    }
    @And("select fixtures and results on redirected page")
    public void select_fixtures_and_results_on_redirected_page() {
        espncricinfo.click_fix_res();
    }
    @And("click on third ODI match")
    public void click_on_third_odi_match() {
        espncricinfo.select_match();
    }
    @Then("User is redirected to Full scorecard page for the selected match")
    public void user_is_redirected_to_full_scorecard_page_for_the_selected_match() {
        espncricinfo.verify_scrcrdpage();
    }
    @Then("User is redirected to the page having results of Indian team")
    public void user_is_redirected_to_the_page_having_results_of_Indian_team() {
        espncricinfo.verifypage();
        driver.close();
    }
    @Then("Results of the selected team is displayed")
    public void results_of_the_selected_team_is_displayed() {
        espncricinfo.display_res();
        driver.close();
    }
    @And("Table with data of players is displayed")
    public void table_with_data_of_players_is_displayed() {
        espncricinfo.get_result();
        driver.close();
    }
}
