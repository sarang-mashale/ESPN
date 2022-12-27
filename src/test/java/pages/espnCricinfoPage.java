package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class espnCricinfoPage {
    public static WebDriver driver;
    public static WebDriverWait mywait;
    By btn_moreespn= By.cssSelector("li.pillar.more-espn");
    By btn_espncricinfo= By.cssSelector("li.external.logo.cricinfo");
    By alert_cricinfo= By.cssSelector("div.wzrk-alert.wiz-show-animate");
    By btn_cancel= By.id("wzrk-cancel");
    By drpd_teams= By.xpath("//div[@class='ds-flex ds-flex-row']/div[3]/a");
    By btn_India= By.xpath("//a[@href='/team/india-6']");
    By btn_NZ= By.xpath("//a[@href='/team/new-zealand-5']");
    By btn_result= By.xpath("//body/div[@id='__next']/section[@id='pane-main']/section[@id='main-container']/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]");
    By res_3rdODI= By.xpath("//a[@href='/series/india-in-new-zealand-2022-23-1322272/new-zealand-vs-india-3rd-odi-1322280/full-scorecard']");
    By res_2ndODI= By.xpath("//a[@href='/series/india-in-new-zealand-2022-23-1322272/new-zealand-vs-india-2nd-odi-1322279/full-scorecard']");
    By res_1stODI= By.xpath("//a[@href='/series/india-in-new-zealand-2022-23-1322272/new-zealand-vs-india-1st-odi-1322278/full-scorecard']");
    By btn_indvban= By.xpath("//a[@href='/series/india-in-bangladesh-2022-23-1340842']");
    By btn_fix_res= By.xpath("//a[@href='/series/india-in-bangladesh-2022-23-1340842/match-schedule-fixtures-and-results']");
    By btn_scrcrd= By.xpath("//a[@href='/series/india-in-bangladesh-2022-23-1340842/bangladesh-vs-india-3rd-odi-1340847/full-scorecard']");
    public espnCricinfoPage(WebDriver driver){
        this.driver= driver;
    }
    public void getcricinfosite(){
        driver.findElement(btn_moreespn).click();
        driver.findElement(btn_espncricinfo).click();
    }
    public void redirecttocricinfo(){
        String ESPN_home = driver.getWindowHandle();
        Set<String> s1= driver.getWindowHandles();
        Iterator<String> i1= s1.iterator();
        while (i1.hasNext())
        {
            String Childwindow= i1.next();
            if(!ESPN_home.equalsIgnoreCase(Childwindow)){
                driver.switchTo().window(Childwindow);
            }
        }
        System.out.println(driver.getTitle());
    }
    public void select_Ind(){
        mywait= new WebDriverWait(driver, Duration.ofSeconds(25));
        mywait.until(ExpectedConditions.visibilityOfElementLocated(alert_cricinfo));
        driver.findElement(btn_cancel).click();
        driver.findElement(drpd_teams).click();
        driver.findElement(btn_India).click();
    }
    public void verifypage(){
        mywait.until(ExpectedConditions.titleContains("India Cricket Team"));
        String actualTitle= driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle ="India Cricket Team, India team and players, captain, fixtures, schedules, Scores";
        Assert.assertEquals(expectedTitle,actualTitle);
//        driver.quit();
    }
    public void select_NZ(){
        mywait.until(ExpectedConditions.titleContains("Live Cricket scores"));
        mywait.until(ExpectedConditions.visibilityOfElementLocated(alert_cricinfo));
        driver.findElement(btn_cancel).click();
        driver.findElement(drpd_teams).click();
        driver.findElement(btn_NZ).click();
    }
    public void NZ_page(){
        mywait.until(ExpectedConditions.titleContains("New Zealand Cricket Team"));
        System.out.println(driver.getTitle());
    }
    public void click_result(){
        driver.findElement(btn_result).click();
    }
    public void display_res(){
        System.out.println("Results of last 3 matches");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(driver.findElement(res_3rdODI));
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(driver.findElement(res_2ndODI));
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(driver.findElement(res_1stODI));
//        driver.quit();
    }
    public void click_indvban(){
        driver.findElement(btn_indvban).click();
    }
    public void click_fix_res(){
        mywait.until(ExpectedConditions.visibilityOfElementLocated(alert_cricinfo));
        driver.findElement(btn_cancel).click();
        driver.findElement(btn_fix_res).click();
        driver.getTitle();
    }
    public void select_match(){
        mywait.until(ExpectedConditions.elementToBeClickable(btn_scrcrd));
        driver.findElement(btn_scrcrd).click();
    }
    public void verify_scrcrdpage(){
        mywait.until(ExpectedConditions.titleContains("Full Scorecard of India"));
        System.out.println(driver.getTitle());
    }
    public void get_result(){
        System.out.print(driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[5]/div[1]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div/div[2]/table[1]/thead/tr/th[1]")).getText() + ":   ");
        System.out.println(driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[5]/div[1]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr[1]/td[1]")).getText());
        System.out.print("Status:   ");
        System.out.println(driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[5]/div[1]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr[1]/td[2]")).getText());
        for(int i=3; i<9 ; i++){
            System.out.print(driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[5]/div[1]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div/div[2]/table[1]/thead/tr/th["+ i +"]")).getText()+":   ");
            System.out.println(driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[5]/div[1]/div/div[3]/div[1]/div[2]/div[1]/div[2]/div/div[2]/table[1]/tbody/tr[1]/td["+ i +"]")).getText());
        }
//        driver.quit();
    }
}
