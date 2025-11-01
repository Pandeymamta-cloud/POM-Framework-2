package framework.driver;

import framework.utils.Genrics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> TL = new ThreadLocal<>();

    public static WebDriver getDriver() { return TL.get(); }


    public static void launchBrowser(String browser) {
        if (browser == null) browser = System.getProperty("browser", "chrome");
        switch (browser.toLowerCase()) {
            case "firefox" -> { TL.set(new FirefoxDriver()); }
            default -> { TL.set(new ChromeDriver()); }
        }

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        getDriver().get(Genrics.getValue("url","prod"));
    }

    public static void quit() {
        WebDriver d = TL.get();
        if (d != null) { d.quit(); TL.remove(); }
    }
}
