package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class searchPage {
    public static WebDriver driver;
    By btn_search= By.id("global-search-trigger");
    By search_field = By.id("global-search-input");
    By result= By.className("player__Results__Item");
    public searchPage(WebDriver driver){
        this.driver=driver;
    }
    public void search_click(){
        driver.findElement(btn_search).click();
    }
    public void data_entry(String name){
        driver.findElement(search_field).sendKeys(name);
    }
    public void click_enter(){
        driver.findElement(search_field).sendKeys(Keys.ENTER);
    }
    public void result(){
        System.out.println(driver.findElement(result).getText());
        driver.quit();
    }
}
