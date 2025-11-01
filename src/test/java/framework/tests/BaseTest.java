package framework.tests;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.annotations.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;

import org.testng.ITestResult;

@Listeners(ChainTestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @AfterMethod
    public void addScreenshOt(org.testng.ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE && driver instanceof TakesScreenshot) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File screenshot = ts.getScreenshotAs(OutputType.FILE);

            String screenshotPath = System.getProperty("user.dir") + "/target/chaintest/screenshots/" + result.getName() + "_" + System.currentTimeMillis() + ".png";
            File destination = new File(screenshotPath);
            screenshot.renameTo(destination);
            destination.getParentFile().mkdirs();
            ChainTestListener.log("Screenshot on failure: <a href='screenshots/" + destination.getName() + "' target='_blank'>View Screenshot</a>");
        }
    }



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
