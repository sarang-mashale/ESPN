package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {
    public static WebDriver driver;
    public static WebDriverWait mywait;

    By btn_login= By.cssSelector("button[class='button-alt med']");
    By ESPN_logo= By.cssSelector("div[id='logo']");
    By input_email= By.cssSelector("input[type='email']");
    By input_password= By.cssSelector("input[type='password']");
    By btn_submit= By.id("BtnSubmit");
    By msg_required= By.id("InputLoginValue-error");
    By msg_incorrectcreds = By.id("LoginError");

    public loginPage(WebDriver driver){
        this.driver =driver;
    }
    public void clickLoginBtn(){
        driver.findElement(btn_login).click();
    }
    public void verifyLoginFrame(){

        mywait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.switchTo().frame("oneid-iframe");
        mywait.until(ExpectedConditions.visibilityOfElementLocated(ESPN_logo));
        WebElement logo = driver.findElement(ESPN_logo);
        Assert.assertTrue(logo.isDisplayed());
        System.out.println("User is on login frame");
    }
    public void enterData(String email, String password){
        driver.findElement(input_email).sendKeys(email);
        driver.findElement(input_password).sendKeys(password);
    }
    public void clickSubmit(){
        driver.findElement(btn_submit).click();
    }
    public void nullResult(){
        mywait.until(ExpectedConditions.visibilityOfElementLocated(msg_required));
        System.out.println(driver.findElement(msg_required).getText());
        driver.close();
    }
    public void invalidCreds(){
        mywait.until(ExpectedConditions.visibilityOfElementLocated(msg_incorrectcreds));
        System.out.println(driver.findElement(msg_incorrectcreds).getText());
        driver.close();
    }
    public void validCreds(){
        System.out.println(driver.getTitle());
        driver.close();
    }


}