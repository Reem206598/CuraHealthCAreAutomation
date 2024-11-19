package com.reem.curahealthcare.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSetup {
private static WebDriver driver;


    //Initializing WebDriver

    public static WebDriver getDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login"); // Replace with your actual login page URL
        }
        return driver;
    }
    // Tear down the WebDriver Instance
    public static void quitDriver(){
        if(driver!=null){
        driver.quit();
        driver = null;
        }
    }

}
