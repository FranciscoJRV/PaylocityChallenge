package org.example;

import Pages.AddPopup;
import org.openqa.selenium.WebDriver;

import Pages.LoginPage;
import Pages.MainPage;
import Utilities.Browser;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Main {
    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    AddPopup addPopup;

    @Test
    public void Login(){
        driver = Browser.StartBrowser(driver,"https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login");

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUsername("TestUser876"); // Set your own username
        loginPage.setPassword("'}X6jClT!Q9c");// Set your own password
        loginPage.clickLoginButton();

        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickAddButton();

        addPopup = PageFactory.initElements(driver, AddPopup.class);
        addPopup.setFirstName("Frank"); // Choose the first name of the employee to added
        addPopup.setLastName("Sinatra");// Choose the last name of the employee to be added
        addPopup.setDependants("3");    // Choose the number of dependants of the employee to be added
        addPopup.clickAddButton();

        mainPage.clickEditIcon("Frank");// Choose the first name of the employee to be edited
        addPopup.setFirstName("Francis");  // Update the first name of the employee
        addPopup.setLastName("Hernandez"); // Update the last name of the employee
        addPopup.setDependants("2");    // Update the number of dependants of the employee
        addPopup.clickUpdateButton();
        mainPage.clickDeleteIcon("Francis");// Choose the first name of the employee to be deleted
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Browser.closeBrowser(driver);
    }
    }