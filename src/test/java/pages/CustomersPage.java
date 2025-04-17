package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.CustomersLocators;

import static pageLocators.CustomersLocators.customerRow;

public class CustomersPage {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public CustomersPage (WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }
    public void searchCustomers (String lasNameValue){
        elementHelper.fillLocator(CustomersLocators.customerName,lasNameValue);
        LoggerUtility.infoTest("The user filled first name filed with value");
    }

    public void validateCustomer (String firstNameValue, String lastNameValue, String postCodeValue){
        elementHelper.validateContainTextLocator(customerRow, firstNameValue);
        LoggerUtility.infoTest("The user validates the presence of" + firstNameValue);
        elementHelper.validateContainTextLocator(CustomersLocators.customerRow, lastNameValue);
        LoggerUtility.infoTest("The user validates the presence of" + lastNameValue);
        elementHelper.validateContainTextLocator(CustomersLocators.customerRow, postCodeValue);
        LoggerUtility.infoTest("The user validates the presence of" + postCodeValue);
    }

    public void deleteCustomer(){
        elementHelper.clickJSLocator(CustomersLocators.deleteButton);
        LoggerUtility.infoTest("The user is deleted");

    }

}
