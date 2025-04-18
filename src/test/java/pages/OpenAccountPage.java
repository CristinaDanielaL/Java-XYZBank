package pages;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.OpenAccountLocators;

public class OpenAccountPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private AlertHelper alertHelper;

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        alertHelper = new AlertHelper(driver);
    }
    public void selectCustomerName(String fullNameValue){
        elementHelper.selectLocator(OpenAccountLocators.customerNameElement, fullNameValue);
        LoggerUtility.infoTest("The user selects from customer value:" + fullNameValue);
    }

    public void selectCurrency(String currencyValue){
        elementHelper.selectLocator(OpenAccountLocators.currentElement, currencyValue);
        LoggerUtility.infoTest("The user selects from currency value:" + currencyValue);
    }

    public void clickProcess () {
        elementHelper.clickLocator(OpenAccountLocators.processButton);
        LoggerUtility.infoTest("The user clicked on process button");

        alertHelper.acceptAlert();
        LoggerUtility.infoTest("Alerta a fost acceptata");

    }


}