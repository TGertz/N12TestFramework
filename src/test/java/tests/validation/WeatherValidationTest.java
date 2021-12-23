package tests.validation;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import static constants.Constant.Urls.N12_WEATHER_PAGE;

public class WeatherValidationTest extends BaseTest {

    @Test
    public void validationCheck() {
        basePage.open(N12_WEATHER_PAGE);
        baseWeatherPageValidate.clickToFindWeather();
        baseWeatherPageValidate.findWeatherH1();
        baseWeatherPageValidate.cityValidation();
        baseWeatherPageValidate.cityValidationClick();
    }
}
