package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;

public class userAccount {
    public static WebDriver driver;
    public static WebDriverWait mywait;
    @Given("User is logged in on the website with credentials {string} and {string}")
    public void user_is_logged_in_on_the_website_with_credentials_and(String email, String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt= new ChromeOptions();
        opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver(opt);
        driver.get("https://www.espn.in/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("button[class='button-alt med']")).click();
        driver.switchTo().frame("disneyid-iframe");
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[class='btn btn-primary btn-submit ng-isolate-scope']")).click();
        Thread.sleep(10000);
    }
    @And("User is on ESPN profile frame")
    public void user_is_on_espn_profile_frame() throws InterruptedException {
        //mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/a[contains(text(),'Sign In')]")));
        //mywait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("google_ads_iframe_/21783347309/espn.in/frontpage/index_1")));
        Thread.sleep(8000);
        //mywait.until(ExpectedConditions.titleIs("ESPN: Serving sports fans. Anytime. Anywhere."));
        driver.findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
    }
    @When("User enters valid information in fields name {string} lastname {string}")
    public void user_enters_valid_information_in_fields_name_lastname(String name, String lastname) {
        driver.findElement(By.xpath("//*[@tref='/members/v3_1/modifyAccount']")).click();
        driver.switchTo().frame("disneyid-iframe");
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[class='title title-primary ng-isolate-scope']")));
        System.out.println(driver.findElement(By.cssSelector("h2[class='title title-primary ng-isolate-scope']")).getText());
        driver.findElement(By.xpath("//*[@name='firstName']")).clear();
        driver.findElement(By.xpath("//*[@name='firstName']")).sendKeys(name);
        driver.findElement(By.xpath("//*[@name='lastName']")).clear();
        driver.findElement(By.xpath("//*[@name='lastName']")).sendKeys(lastname);
        Select country= new Select(driver.findElement(By.xpath("//*[@name='legalCountryChoice']")));
        country.selectByVisibleText("India");
    }
    @And("Click on Done button")
    public void click_on_done_button() {
        driver.findElement(By.xpath("//*/button[contains(text(),'Done')]"));
    }
    @Then("User is redirected to the home page")
    public void user_is_redirected_to_the_home_page() {
        System.out.println(driver.getTitle());
    }
    @And("Updated information is displayed in user profile section")
    public void updated_information_is_displayed_in_user_profile_section() {
        driver.findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
        driver.findElement(By.xpath("//*[@tref='/members/v3_1/modifyAccount']")).click();
        driver.switchTo().frame("disneyid-iframe");
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[class='title title-primary ng-isolate-scope']")));
        System.out.println(driver.findElement(By.xpath("//*[@name='firstName']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@name='lastName']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@name='legalCountryChoice']")).getText());
        driver.close();

    }
    @Given("clicks add button in address book section")
    public void clicks_add_button_in_address_book_section() {
        driver.findElement(By.xpath("//*[@tref='/members/v3_1/modifyAccount']")).click();
        driver.switchTo().frame("disneyid-iframe");
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[class='title title-primary ng-isolate-scope']")));
        System.out.println(driver.findElement(By.cssSelector("h2[class='title title-primary ng-isolate-scope']")).getText());
        driver.findElement(By.xpath("//a[@title='Add a new address']")).click();
    }
    @When("User enters the address details in the fields")
    public void user_enters_the_address_details_in_the_fields() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("clicks save address button")
    public void clicks_save_address_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("address details are displayed in ESPN profile frame")
    public void address_details_are_displayed_in_espn_profile_frame() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
