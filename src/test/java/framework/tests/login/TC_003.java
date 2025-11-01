package framework.tests.login;

import framework.pages.LoginPage;
import framework.tests.BaseTest;
import org.testng.annotations.Test;

public class TC_003 extends BaseTest {
    @Test
    public void TC_001() {

        String email = "mamta1013@gmail.com", password = "admin555";

        LoginPage lp = new LoginPage(driver);
        lp.login(email, password);
        lp.verifyLoginSuccess();



    }
}
