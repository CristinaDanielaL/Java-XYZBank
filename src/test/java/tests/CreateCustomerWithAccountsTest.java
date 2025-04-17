package tests;

import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

public class CreateCustomerWithAccountsTest extends SharedData {

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
        String[] currencies = {"Dollar", "Pound", "Rupee"};

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.fillFirstName(firstNameValue);
        addCustomerPage.fillLastName(lastNameValue);
        addCustomerPage.fillPostCode(postCodeValue);
        addCustomerPage.clickCustomerButton();

        bankManagerPage.clickOpenAccountElement();

        for (int i = 0; i < currencies.length; i++) {
            OpenAccountPage openAccountPage = new OpenAccountPage(driver);
            openAccountPage.selectCustomerName(fullNameValue);
            openAccountPage.selectCurrency(currencies[i]);
            openAccountPage.clickProcess();
        }
    }

}

