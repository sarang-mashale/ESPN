package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

public class nbaSection {
    WebDriver driver;
    WebDriverWait mywait;
    JavascriptExecutor js;
    @Given("User is on home page of website with url {string}")
    public void user_is_on_home_page_of_website_with_url(String url) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver();
        js =(JavascriptExecutor) driver;
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle() + "\n");
        mywait= new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @When("User clicks on NBA button")
    public void user_clicks_on_nba_button() {
       driver.findElement(By.xpath("//a[@href='/nba/']")).click();
    }
    @And("clicks on teams and select team")
    public void clicks_on_teams_and_select_team() {
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/nba/teams']")));
        driver.findElement(By.xpath("//a[@href='/nba/teams']")).click();
        mywait.until(ExpectedConditions.titleContains("NBA Teams"));
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//*[contains(text(),'Chicago Bulls')]")).click();
        System.out.println(driver.getTitle());
    }
    @And("clicks on schedule button")
    public void clicks_on_schedule_button() {
        mywait.until(ExpectedConditions.titleContains("Chicago Bulls"));
        driver.findElement(By.xpath("//*[contains(text(),'Schedule')]")).click();
    }
    @Then("Upcoming match schedule is displayed")
    public void upcoming_match_schedule_is_displayed() {
        System.out.println("\n" + driver.findElement(By.xpath("//tbody/tr[29]")).getText());
        driver.quit();

    }
    @Then("Result of latest match is displayed on home page of NBA section")
    public void result_of_latest_match_is_displayed_on_home_page_of_nba_section() throws IOException {
        mywait.until(ExpectedConditions.titleContains("NBA"));
//        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-id='35241396']")));
        js.executeScript("window.scrollBy(0,150)");
        TakesScreenshot result_shot= ((TakesScreenshot) driver);
        File src_file= result_shot.getScreenshotAs(OutputType.FILE);
        File target_loc= new File("C:\\Users\\sarang_mashale\\IdeaProjects\\ESPN_Automation\\screenshots\\result.png");
        FileUtils.copyFile(src_file,target_loc);
        driver.quit();
    }
    @Then("results of selected team is displayed")
    public void results_of_selected_team_is_displayed(){
        mywait.until(ExpectedConditions.titleContains("2022-23 Chicago Bulls Schedule"));
        for(int i=1; i<8; i++){
            System.out.print(driver.findElement(By.xpath("//*/tbody/tr[1]/td["+ i +"]")).getText() + ": ");
            System.out.println(driver.findElement(By.xpath("//*/tbody/tr[27]/td["+ i +"]")).getText());
        }
//        System.out.print(driver.findElement(By.xpath("//*/tbody/tr[1]/td[1]")).getText() + ": ");
//        System.out.println(driver.findElement(By.xpath("//*/tbody/tr[27]/td[1]")).getText());
//        System.out.print(driver.findElement(By.xpath("//*/tbody/tr[1]/td[2]")).getText() + ": ");
//        System.out.println(driver.findElement(By.xpath("//tbody/tr[27]/td[2]/div/span[3]/a")).getText());
//        System.out.print(driver.findElement(By.xpath("//*/tbody/tr[1]/td[3]")).getText() + ": ");
//        System.out.println(driver.findElement(By.xpath("//*/tbody/tr[27]/td[3]")).getText());
//        System.out.print(driver.findElement(By.xpath("//*/tbody/tr[1]/td[4]")).getText() + ": ");
//        System.out.println(driver.findElement(By.xpath("//*/tbody/tr[27]/td[4]")).getText());
//        System.out.print(driver.findElement(By.xpath("//*/tbody/tr[1]/td[5]")).getText() + ": ");
//        System.out.println(driver.findElement(By.xpath("//*/tbody/tr[27]/td[5]")).getText());
//        System.out.print(driver.findElement(By.xpath("//*/tbody/tr[1]/td[6]")).getText() + ": ");
//        System.out.println(driver.findElement(By.xpath("//*/tbody/tr[27]/td[6]")).getText());
//        System.out.print(driver.findElement(By.xpath("//*/tbody/tr[1]/td[7]")).getText() + ": ");
//        System.out.println(driver.findElement(By.xpath("//*/tbody/tr[27]/td[7]")).getText());
        driver.quit();
    }
}
