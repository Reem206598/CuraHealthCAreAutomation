package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import com.reem.curahealthcare.utils.WebDriverSetup;

import java.time.Duration;

public class HomePageTest {
    private WebDriver driver;
    private WebDriverWait wait;



    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver and navigate to the home page
        driver = WebDriverSetup.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Use Duration for timeout

        // Adjust timeout as needed
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown() {

        // Quit the driver after the test
        WebDriverSetup.quitDriver();
    }

    @Test
    public void testMakeAppointmentButton() {
        // Create an instance of the HomePage class
        HomePage homePage = new HomePage(driver);

        // Click on the "Make Appointment" button
        homePage.makeappointment();
        try {
            Thread.sleep(2000); // Pause for 2 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // Verify that clicking the button navigates to the appointment page
        // Replace with the expected URL or other confirmation element on the appointment page
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Navigation to appointment page failed.");
    }
}
