package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class signUp {
    public static WebDriver driver;
    public static WebDriverWait mywait;
    @Given("User is on signup page of website with url {string}")
    public void user_is_on_signup_page_of_website(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        mywait= new WebDriverWait(driver, Duration.ofSeconds(5));
        System.out.println(driver.getTitle());
        driver.findElement(By.cssSelector("button[class='button med']")).click();
        driver.switchTo().frame("disneyid-iframe");
        System.out.println(driver.findElement(By.cssSelector("h2[class='title title-primary ng-isolate-scope']")).getText());
    }
    @When("User enters inputs first name {string} last name {string} email {string} and password {string}")
    public void user_enters_inputs_first_name_last_name_email_and_password(String firstname, String lastname, String email, String password) {
        driver.findElement(By.name("firstName")).sendKeys(firstname);
        driver.findElement(By.name("lastName")).sendKeys(lastname);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("newPassword")).sendKeys(password);
    }
    @And("Click on sign up button")
    public void click_on_sign_up_button() {
        driver.findElement(By.cssSelector("button[class='btn btn-primary ng-scope ng-isolate-scope']")).click();
    }
    @Then("warning occurs under email field")
    public void warning_occurs_under_email_field() throws InterruptedException {
        System.out.println("Test Case:Invalid Email ID");
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='field field-email ng-scope badgeable field-required field-error']/div/div/div")));
        System.out.println(driver.findElement(By.xpath("//*[@class='field field-email ng-scope badgeable field-required field-error']/div/div/div")).getText());
        driver.close();
    }
    @Then("warning occurs below every field")
    public void warning_occurs_below_every_field() {
        System.out.println("Test Case:Null Inputs");
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='field field-email ng-scope badgeable field-required field-error']/div/div/div")));
        System.out.println(driver.findElement(By.xpath("  //*[@class='field field-first-name ng-scope ng-isolate-scope badgeable field-required field-error']/label/div")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@class='field field-last-name ng-scope ng-isolate-scope badgeable field-required field-error']/label/div")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@class='field field-email ng-scope badgeable field-required field-error']/div/div/div")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@class='field field-new-password badgeable field-error']/label/div")).getText());
        driver.close();
    }
    @Then("User is redirected to ESPN home page")
    public void User_is_redirected_to_ESPN_home_page() {
        System.out.println(driver.getTitle());
        driver.close();
    }
}
