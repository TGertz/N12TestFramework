package pages.basedatevalidate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

public class BasePoliticValidatePage extends BasePage {

    public BasePoliticValidatePage(WebDriver driver) {
        super(driver);
    }

    private final By findBtnPolitic = By.xpath("//body/nav[1]/ul[1]/li[1]/ul[1]/li[2]/a[contains(text(),'פוליטי')]");
    private final By findH1Politic = By.xpath("//header/h1[contains(text(),'פוליטי')]");
    private final By findToolbar = By.xpath("//header[@class='toolbar']");
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public BasePoliticValidatePage clickToFindPolitic(){
        WebElement btnPolitic = driver.findElement(findBtnPolitic);
        btnPolitic.click();
        return this;
    }

    public BasePoliticValidatePage findPoliticH1(){
        WebElement politicH1 =driver.findElement(findH1Politic);
        waitElementIsVisible(politicH1).isDisplayed();
        return this;
    }

    public BasePoliticValidatePage navToolbarScrollCheck(){
        WebElement toolbar = driver.findElement(findToolbar);
        js.executeScript("window.scrollBy(0,3000)");
        Assert.assertTrue(waitElementIsVisible(toolbar).isDisplayed(),"The toolbar is displayed while scrolling to down.");
        return this;
    }
}