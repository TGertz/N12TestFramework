package pages.basedatevalidate;

import com.google.common.base.CharMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BaseDateValidate extends BasePage {

    public BaseDateValidate(WebDriver driver) {
        super(driver);
    }

    private final By padeDate = By.xpath("//span[@class='date']");

    public BaseDateValidate dateValidate(){
        WebElement element = driver.findElement(padeDate);
        String sDate = element.getText();
        String strDateDigits = CharMatcher.inRange('0', '9').retainFrom(sDate);

        LocalDate nowDate = LocalDate.now();
        String strNowDate = nowDate.format(DateTimeFormatter.ofPattern("ddMMyy"));

        System.out.println("expected date: " + strDateDigits + " ----> current date: " + strNowDate);
        Assert.assertEquals(strDateDigits, strNowDate);
        return this;
    }
}
