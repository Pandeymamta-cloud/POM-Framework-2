package framework.tests.login;

import com.aventstack.chaintest.plugins.ChainTestListener;
import framework.pages.LoginPage;
import framework.tests.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ChainTestListener.class)
/**
 * Test Case: Login with valid email and invalid password
 * Steps:
 * 1. Enter valid email and invalid password
 * 2. Attempt login
 * 3. Verify error message is displayed
 */
public class TC_003 extends BaseTest {
    @Test(description="Login with valid email and invalid password")
    public void TC_001() {

        String email = "mamta1013@gmail.com", password = "admin555";

        LoginPage lp = new LoginPage(driver);
//        lp.login(email, password);
        lp.loginWithInvalidCreds(email, password);



    }
}
