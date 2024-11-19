package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"login\"]/div/div/div[2]/form")
    private WebElement loginForm;

    @FindBy(id = "txt-username")
    private WebElement username;

    @FindBy(id = "txt-password")
    private WebElement password;

    @FindBy(id = "btn-login")
    private WebElement loginButton;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize the @FindBy fields
    }

    public boolean isLoginFormPresent() {
        return loginForm.isDisplayed();
    }

    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
