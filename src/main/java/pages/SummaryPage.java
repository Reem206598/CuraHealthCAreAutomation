package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryPage {
    private WebDriver driver;

    @FindBy(id= "facility")
    private WebElement facility;

    @FindBy(id = "hospital_readmission")
    private WebElement readmission;
    @FindBy(id = "program")
    private WebElement program;

    @FindBy(id = "visit_date")
    private WebElement visitDate;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFacility() {
        return facility;
    }

    public WebElement getReadmission() {
        return readmission;
    }

    public WebElement getProgram() {
        return program;
    }

    public WebElement getVisitDate() {
        return visitDate;
    }
}
