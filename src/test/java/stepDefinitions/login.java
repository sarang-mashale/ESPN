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

public class login {
    public static WebDriver driver;
    loginPage login;
    jsonparse jpass;
    static JSONObject obj;

    @Given("User is on login page of website with url {string}")
    public void user_is_on_login_page_of_website_with_url(String string) throws IOException, ParseException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        jpass= new jsonparse();
        obj= jpass.fileRead();
        String url= (String) obj.get(string);
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        login= new loginPage(driver);
        login.clickLoginBtn();
        login.verifyLoginFrame();
    }

    @When("User enters input email {string} and password {string}")
    public void user_enters_input_email_and_password(String string1, String string2) {
        String email= obj.get(string1).toString();
        String password= obj.get(string2).toString();
        login.enterData(email,password);
    }

    @And("Click on login button")
    public void click_on_login_button() {
        login.clickSubmit();
    }

    @Then("Email required warning occur")
    public void email_required_warning_occur() {
        login.nullResult();
    }

    @Then("Incorrect credential message occurs")
    public void incorrect_credential_message_occurs() {
        login.invalidCreds();
    }

    @Then("User is redirected to home page")
    public void User_is_redirected_to_ESPN_home_page() {
        login.validCreds();
    }
}
