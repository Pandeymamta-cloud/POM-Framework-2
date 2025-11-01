package framework.tests.login;

import com.aventstack.chaintest.plugins.ChainTestListener;
import framework.pages.LoginPage;
import framework.tests.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ChainTestListener.class)
public class TC_001 extends BaseTest {


    @Test
    public void TC_001() {

        String email = "mamta1013@gmail.com", password = "mamta123456";

        LoginPage lp = new LoginPage(driver);
        lp.login(email, password);
        lp.verifyLoginSuccess();



    }
}
