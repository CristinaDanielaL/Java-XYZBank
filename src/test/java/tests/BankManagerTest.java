package tests;

import org.testng.annotations.Test;
import pageLocators.AddCustomersLocators;
import pages.*;
import sharedData.SharedData;

public class BankManagerTest extends SharedData {

    @Test
            public void testMethod () {


        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickManagerLoginMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.clickAddCustomerElement();


        String firstNameValue = "Lazar";
        String lastNameValue = "Dana";
        String postCodeValue = "123";
        String fullNameValue = firstNameValue +" "+ lastNameValue;
        String currencyValue = "Dollar";

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.fillFirstName(firstNameValue);
        addCustomerPage.fillLastName(lastNameValue);
        addCustomerPage.fillPostCode(postCodeValue);
        addCustomerPage.clickCustomerButton();

        bankManagerPage.clickOpenAccountElement();

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.selectCustomerName(fullNameValue);
        openAccountPage.selectCurrency(currencyValue);
        openAccountPage.clickProcess();

        bankManagerPage.clickCustomersElement();
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.searchCustomers(lastNameValue);

        customersPage.validateCustomer(firstNameValue, lastNameValue, postCodeValue);

        customersPage.deleteCustomer();
    }

}

