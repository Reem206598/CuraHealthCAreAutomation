package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage{
    private WebDriver driver;

    // Locators for elements
    private By appointmentButton = By.id("btn-make-appointment");

    //Constructor
    public HomePage(WebDriver driver){
        this.driver = driver;

    }
    //Method to click on the MAke appointment button
    public void makeappointment(){
        driver.findElement(appointmentButton).click();
    }

}
