package tests;

import com.reem.curahealthcare.utils.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class HomeAndLoginPageTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverSetup.getDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }
    @AfterMethod
    public void tearDown(){
        WebDriverSetup.quitDriver();
    }

    @Test
    public void testHomeAndLogin(){
        // Setp 1: Test the HomePage

        HomePage homePage = new HomePage(driver);
        homePage.makeappointment();// Simulates clicking the "Nake Appointment" button
        try {
            Thread.sleep(2000); // Pause for 2 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // Assert successful navigation to the Login page
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Failed to navigate to the login page !");

        // Step 2: Test the LoginPage
        LoginPage loginPage = new LoginPage(driver);


        // Verify the Login form
       // Assert.assertTrue(loginPage.isLoginFormPresent(), "Login form is displayed!");

        // Perform a login with valid credentials
        loginPage.login("John Doe","ThisIsNotAPassword" );

        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"), "Login was not successful!");



    }
}
