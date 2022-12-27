package stepDefinitions;

import org.json.simple.JSONObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.loginPage;
import utilities.jsonparse;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class login_hashmap {
    public static WebDriver driver;
    loginPage login;
    jsonparse jpass;
    static Map obj;
    @Given("User is on login page with url {string}")
    public void user_is_on_login_page_with_url(String string) throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        jpass= new jsonparse();
        obj= jpass.fileReadMap();
        String url= (String) obj.get(string);
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        login= new loginPage(driver);
        login.clickLoginBtn();
        login.verifyLoginFrame();
    }
    @When("User enters email {string} and password {string}")
    public void user_enters_email_and_password(String string1, String string2) {
        String email= obj.get(string1).toString();
        String password= obj.get(string2).toString();
        login.enterData(email,password);
    }
    @And("Clicks login button")
    public void clicks_login_button() {
        login.clickSubmit();
    }
    @Then("Email required warning is displayed")
    public void email_required_warning_is_displayed() {
        login.nullResult();
    }
    @Then("Invalid Creds")
    public void invalid_creds(){
        login.invalidCreds();
    }
    @Then("Success")
    public void success(){
        login.validCreds();
    }
}
