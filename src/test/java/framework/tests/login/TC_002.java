package framework.tests.login;

import framework.pages.LoginPage;
import framework.tests.BaseTest;
import org.testng.annotations.Test;

public class TC_002 extends BaseTest {

    @Test
    public void TC_001() {

        String email = "mamta", password = "mamta123456";

        LoginPage lp = new LoginPage(driver);

        lp.login(email, password);
        lp.verifyLoginSuccess();



    }

}
