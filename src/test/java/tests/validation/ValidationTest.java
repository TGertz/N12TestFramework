package tests.validation;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import static constants.Constant.Urls.N12_HOME_PAGE;

public class ValidationTest extends BaseTest {

    @Test
    public void validationCheck(){
        basePage.open(N12_HOME_PAGE);
        basePoliticValidatePage.clickToFindPolitic();
        basePoliticValidatePage.findPoliticH1();
        basePoliticValidatePage.navToolbarScrollCheck();
    }
}