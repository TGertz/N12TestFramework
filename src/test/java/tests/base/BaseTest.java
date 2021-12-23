package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.basedatevalidate.BaseDateValidate;
import pages.basedatevalidate.BasePoliticValidatePage;
import pages.basedatevalidate.BaseWeatherPageValidate;


import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected BasePoliticValidatePage basePoliticValidatePage = new BasePoliticValidatePage(driver);
    protected BaseDateValidate baseDateValidate = new BaseDateValidate(driver);
    protected BaseWeatherPageValidate baseWeatherPageValidate = new BaseWeatherPageValidate(driver);



    @AfterTest
    public void clearCookiesAndLocalStorage(){
        if(CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void close(){
        if(HOLD_BROWSER_OPEN){
            driver.getWindowHandle();
        }
    }
}
