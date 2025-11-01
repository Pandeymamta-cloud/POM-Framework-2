package framework.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {

        framework.driver.DriverFactory.launchBrowser("chrome");
        driver = framework.driver.DriverFactory.getDriver();

    }


    @AfterClass

    public void teardown() {
        framework.driver.DriverFactory.quit();
    }

}
