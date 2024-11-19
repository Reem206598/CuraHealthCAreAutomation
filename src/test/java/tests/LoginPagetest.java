package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import com.reem.curahealthcare.utils.WebDriverSetup;

public class LoginPagetest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize the WebDriver and navigate to the login page
        driver = WebDriverSetup.getDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login"); // Replace with your actual login page URL
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver after the test
        WebDriverSetup.quitDriver();
    }

    @Test
    public void testLoginFormPresence() {
        // Initialize the LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Verify the login form is displayed
       Assert.assertTrue(loginPage.isLoginFormPresent(), "Login form is not displayed!");
    }

    @Test
    public void testValidLogin() {
        // Initialize the LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Verify the login form is displayed
       Assert.assertTrue(loginPage.isLoginFormPresent(), "Login form is not displayed!");

        // Perform login with valid credentials
        loginPage.login("John Doe", "ThisIsNotAPassword"); // Replace with actual credentials

        // Verify successful login by checking the URL or a specific element on the next page
        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"), "Login was not successful!");
    }


    @Test
    public void testInvalidLogin() {
        // Initialize the LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Perform login with invalid credentials
        loginPage.login("invalidUsername", "invalidPassword");

        // Verify that login failed (e.
    }
}