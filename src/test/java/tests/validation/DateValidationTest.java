package tests.validation;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import static constants.Constant.Urls.N12_HOME_PAGE;

public class DateValidationTest extends BaseTest {

        @Test
        public void dateValidationCheck(){
                basePage.open(N12_HOME_PAGE);
                baseDateValidate.dateValidate();
        }
}
