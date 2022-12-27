package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class footballSectionPage {
    public static WebDriver driver;
    public static WebDriverWait mywait;

    By btn_football= By.xpath("//*[contains(text(),'Football')]");
    By drpd_teams= By.xpath("//a[@href='/football/teams']");
    By team_chelsea= By.linkText("Chelsea");
    By btn_fixtures= By.xpath("//span[contains(text(),'Fixtures')]");
    By result= By.xpath("//*[@id=\"fittPageContainer\"]/div[2]/div[5]/div/div[1]/section/div/section/div[3]/div[1]/div[2]/div/div[2]/table/tbody/tr");
    By btn_results= By.xpath("//*[contains(text(),'Results')]");
    By drpd_competition= By.xpath("//*[@id=\"fittPageContainer\"]/div[2]/div[5]/div/div[1]/section/div/section/div[2]/div/select[1]");
    By dsp_league= By.xpath("//*[@id=\"fittPageContainer\"]/div[2]/div[5]/div/div[1]/section/div/section/div[3]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[6]");
    By btn_tournaments= By.xpath("//*[contains(text(),'Tournaments')]");
    By btn_FIFA= By.xpath("//h2[contains(text(),'FIFA World Cup')]");
    By btn_fix_res=By.xpath("//*[contains(text(),'Fixtures & Results')]");
    By header_worldcup= By.xpath("//*[@id='schedule-page']/div/header/h1");
    By res_1= By.xpath("//*[@id='sched-container']/span[1]/h2");
    By res_2=By.xpath("//*[@id='sched-container']/div[2]/table/tbody/tr");
    By res_3=By.xpath("//*[@id='sched-container']/div[2]/table/tbody/tr[2]/td/small");
    public footballSectionPage(WebDriver driver){
        this.driver= driver;
    }
    public void click_football(){
        mywait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(btn_football).click();
    }
    public void select_chelsea(){
        mywait.until(ExpectedConditions.visibilityOfElementLocated(drpd_teams));
        driver.findElement(drpd_teams).click();
        mywait.until(ExpectedConditions.titleContains("Football Teams"));
//        driver.navigate().refresh();
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(team_chelsea).click();
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }

    }
    public void click_fixture(){
        driver.findElement(btn_fixtures).click();
    }
    public void result(){
        System.out.println(driver.findElement(result).getText());
        driver.quit();
    }
    public void click_result(){
        driver.findElement(btn_results).click();
    }
    public void display_result(){
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(result).getText());
        driver.quit();
    }
    public void select_compi(){
        Select competition= new Select(driver.findElement(drpd_competition));
        competition.selectByVisibleText("UEFA Champions League");
    }
    public void verify_dropdown(){
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fittPageContainer\"]/div[2]/div[5]/div/div[1]/section/div/section/div[3]/div[1]/div[2]/div/div[2]/table/tbody/tr/td[6]")));
        String actualleague = driver.findElement(dsp_league).getText();
        String expectedleague = "UEFA Champions League";
        Assert.assertEquals(expectedleague,actualleague);
        driver.quit();
    }
    public void select_FIFA(){
        System.out.println(driver.getCurrentUrl());
        mywait.until(ExpectedConditions.elementToBeClickable(btn_tournaments));
        driver.findElement(btn_tournaments).click();
        mywait.until(ExpectedConditions.titleContains("Football Leagues"));
        driver.findElement(btn_FIFA).click();
    }
    public void click_fix_res(){
        mywait.until(ExpectedConditions.visibilityOfElementLocated(btn_fix_res));
        driver.findElement(btn_fix_res).click();
    }
    public void display_table_data(){
        mywait.until(ExpectedConditions.titleContains("FIFA World Cup Scores"));
        System.out.println(driver.findElement(header_worldcup).getText());
        System.out.println(driver.findElement(res_1).getText());
        System.out.println(driver.findElement(res_2).getText());
        System.out.println(driver.findElement(res_3).getText());
        driver.quit();
    }
}
