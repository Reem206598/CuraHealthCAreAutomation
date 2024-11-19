package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ApointmentPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='appointment']/div[1]/div[1]/form[1]")
    private WebElement appointmentForm;

    @FindBy(id = "combo_facility")
    private WebElement facility;

    @FindBy(id = "chk_hospotal_readmission")
    private WebElement applyCheckbox;

    @FindBy(id = "radio_program_medicare")
    private WebElement radioMedicare;

    @FindBy(id = "radio_program_medicaid")
    private WebElement radioMedicaid;

    @FindBy(id = "radio_program_none")
    private WebElement radioNone;

    @FindBy(id = "txt_visit_date")
    private WebElement date;

    @FindBy(id = "btn-book-appointment")
    private WebElement bookButton;

    public ApointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAppointmentFormPresent() {
        return appointmentForm.isDisplayed();
    }
    public void selectFacility(String facilityName) {
        Select facilitySelect = new Select(facility);
        facilitySelect.selectByVisibleText(facilityName);
    }

    public void chooseProgram(healthcareProgram healthcareProgram) {
        switch (healthcareProgram) {
            case None:
                radioNone.click();
                break;
            case Medicaid:
                radioMedicaid.click();
                break;
            case Medicare:
                radioMedicare.click();
                break;
        }


    }
    public void makeAppointment(String facility, boolean applyCheckbox, healthcareProgram healthcareProgram, String visitDate ){

        selectFacility(facility);
        if(applyCheckbox && !this.applyCheckbox.isSelected()){
            this.applyCheckbox.click();
        }

        chooseProgram(healthcareProgram);
        this.date.sendKeys(visitDate);
        this.bookButton.click();
    }

}