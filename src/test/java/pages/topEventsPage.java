package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class topEventsPage {
    public static WebDriver driver;
    public static WebDriverWait mywait;
    By drpd_topevents= By.xpath("//div[@class='dropdown-wrapper league-nav-desktop desktop-dropdown hoverable']");
    By opt_indvban= By.xpath("//a[@data-id='21108']");
    By drpd_date= By.xpath("//button[@class='button button-filter dropdown-toggle sm selected-date']");
    By opt_prevdate= By.xpath("//div[@class='dropdown-wrapper hoverable']/ul/li[1]");
    By hvr_scrbd= By.xpath("//div[@class='scoreboard active']");
    By opt_fifa= By.xpath("//a[@data-league='fifa.world']");
    By active_date= By.xpath("//li[@class='active']");
    By scrbd_fifa= By.xpath("//div[@data-id='633850']");
    By match_summ= By.xpath("//a[@href='/football/match/_/gameId/633850']");
    By res_fifa= By.xpath("//*[@id='custom-nav']/div[1]/div/div[2]");

    public topEventsPage(WebDriver driver){
        this.driver= driver;
    }
    public void select_event(){
        mywait= new WebDriverWait(driver, Duration.ofSeconds(10));
        mywait.until(ExpectedConditions.visibilityOfElementLocated(drpd_topevents));
        driver.findElement(drpd_topevents).click();
        driver.findElement(opt_indvban).click();
    }
    public void select_date(){
        Actions action= new Actions(driver);
        mywait.until(ExpectedConditions.elementToBeClickable(drpd_date));
        driver.findElement(drpd_date).click();
        WebElement date=driver.findElement(opt_prevdate);
        action.moveToElement(date).click().perform();
    }
    public void display_result(){
        System.out.println(driver.findElement(hvr_scrbd).getText());
//        driver.quit();
    }
    public void select_fifa(){
        driver.findElement(drpd_topevents).click();
        driver.findElement(opt_fifa).click();
    }
    public void select_date1(){
        driver.findElement(drpd_date).click();
        driver.findElement(active_date).click();
    }
    public void select_summ(){
        WebElement match= driver.findElement(scrbd_fifa);
        Actions action= new Actions(driver);
        action.moveToElement(match).build().perform();
        driver.findElement(match_summ).click();

    }
    public void result_fifa(){
        System.out.println(driver.findElement(res_fifa).getText());
    }

}
