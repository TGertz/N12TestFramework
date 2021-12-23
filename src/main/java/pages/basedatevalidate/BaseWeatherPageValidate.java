package pages.basedatevalidate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class BaseWeatherPageValidate<actualCity> extends BasePage {

    public BaseWeatherPageValidate(WebDriver driver) {
        super(driver);
    }

    private final By padeWeather = By.xpath("//div//ul[@class='weather-slider tns-slider tns-gallery tns-subpixel tns-calc tns-horizontal']");
    private final By findH1Weather = By.xpath("//h1[contains(text(),'מזג האוויר')]");
    //private final By weatherMap = By.xpath("//div[@class='forcastMapWrap weatherSearch']");
    //private final By weatherMap = By.xpath("//html/body/main/div[2]/ul");
    //private final By weatherMap = By.xpath("//div[@class='forcastMapWrap weatherSearch']//strong");
    private final By weatherMap = By.xpath("//strong[contains(text(),'אילת') or contains(text(),'אשדוד') or contains(text(),'באר שבע')  or contains(text(),'חיפה')  or contains(text(),'טבריה')  or contains(text(),'ירושלים')  or contains(text(),'צפת')  or contains(text(),'תל אביב - יפו')]");
    private final By currentCityName = By.xpath("//body/main[1]/div[1]/form[1]/button[1]/span[2]");
    String[] expectedCityArray = new String[]{"אילת", "אשדוד", "באר שבע", "חיפה", "טבריה", "ירושלים", "צפת", "תל אביב - ויפו"};
    //String[] actualCitys = new String[8];
    String[] actualCitys = new String[]{"","","","","","","","תל אביב - ויפו"};

    public BaseWeatherPageValidate clickToFindWeather() {
        WebElement btnPolitic = driver.findElement(padeWeather);
        btnPolitic.click();
        return this;
    }

    public BaseWeatherPageValidate findWeatherH1() {
        WebElement WeatherH1 = driver.findElement(findH1Weather);
        waitElementIsVisible(WeatherH1).isDisplayed();
        return this;
    }

    public BaseWeatherPageValidate cityValidation() {
        List<WebElement> allCitys = driver.findElements(weatherMap);
                int i = 0;
                    for(WebElement City : allCitys) {
                        for(int j = 0; j < expectedCityArray.length; j++) {
                        //System.out.print("Web element at now :    " + link.getText());
                        System.out.println("expectedCityArray *********  " + expectedCityArray[j]);
                        if(City.getText().contains(expectedCityArray[j])) {
                            if(expectedCityArray[j] == "תל אביב - ויפו" && actualCitys[i] == null){
                                actualCitys[i] = "תל אביב - ויפו";
                                System.out.println("actualCitys[i] *********  " + actualCitys[i] + "  at index : " + i);
                            }
                            else {
                                actualCitys[i] = expectedCityArray[j];
                                System.out.println("actualCitys[i] *********  " + actualCitys[i] + "  at index : " + i);
                                i++;
                            }
                        }
                    }
                }
                Assert.assertEquals(actualCitys, expectedCityArray);
                return this;
            }


    public BaseWeatherPageValidate cityValidationClick(){
        for(int i = 0; i < actualCitys.length; i++){
            WebElement cityClick = driver.findElement(By.xpath("//div//strong[contains(text()," + actualCitys[i] + ")]"));
            System.out.println("clicked city page :   //div//strong[contains(text()," + actualCitys[i] + ")]");
            cityClick.click();
            WebElement element = driver.findElement(currentCityName);
            String currentCityNameStr = element.getText();
            System.out.println("actual city page :   " + currentCityNameStr);
            Assert.assertEquals(currentCityNameStr, actualCitys[i]);
        }
        return this;
    }
}
