package pages;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.AddCustomersLocators;

import static pageLocators.AddCustomersLocators.*;

public class AddCustomerPage {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private AlertHelper alertHelper;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        alertHelper = new AlertHelper(driver);

    }
    public void fillFirstName(String firstNameValue){
        elementHelper.fillLocator(firstNameElement, firstNameValue);
        LoggerUtility.infoTest("The user filled first name filed with value" + firstNameValue);

    }
    public void fillLastName(String lastNameValue) {
        elementHelper.fillLocator(lastNameElement, lastNameValue);
        LoggerUtility.infoTest("The user filled last name filed with value" + lastNameValue);
    }

    public void fillPostCode(String postCodeValue) {
        elementHelper.fillLocator(postCodeElement, postCodeValue);
        LoggerUtility.infoTest("The user filled post code filed with value" + postCodeValue);
    }

    public void clickCustomerButton() {
        elementHelper.clickLocator(AddCustomersLocators.addCustomerButton);
        LoggerUtility.infoTest("The user clicked on add customer button");
        alertHelper.acceptAlert();
        LoggerUtility.infoTest("Alerta a fost acceptata");
    }

}
