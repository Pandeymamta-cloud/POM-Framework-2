package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@ID='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@ID='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SubmitButton;

    @FindBy(xpath = "//button[@id='signup']")
    public WebElement SignupButton;

    @FindBy(xpath = "//span [Text()=\"Incorrect username or password\"]")
    public WebElement errorMessage;

    @FindBy(xpath = "//h1[Text()='Contact List']")
    public WebElement ContactlistHeader;



    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        SubmitButton.click();
    }

    public String loginWithInvalidCreds(String email, String password) {
        if(!email.isEmpty()) {
            emailInput.clear();
            passwordInput.clear();
        }
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        SubmitButton.click();
        // Wait for error message to appear (simple sleep for demo, use WebDriverWait in real code)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return errorMessage.getText();
    }

    public boolean isContactlistDisplayed() {
        return ContactlistHeader.isDisplayed();
    }


    public void verifyLoginSuccess() {
        if (!isContactlistDisplayed()) {
            throw new AssertionError("Login failed: Contactlist not displayed.");
        }else {
            System.out.println("Login successful: Dashboard is displayed." + ContactlistHeader.getText());
        }
    }
}