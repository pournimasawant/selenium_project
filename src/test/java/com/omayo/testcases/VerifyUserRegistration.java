package com.omayo.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codemind.utility.Utility;
import com.omayo.pages.NewToursHomePage;
import com.omayo.pages.NewToursRegisterPage;



public class VerifyUserRegistration {
	
	WebDriver edgedriver;
	NewToursHomePage newToursHomePage;
    NewToursRegisterPage newToursRegisterPage;
    List<String> userData;
	
	
	@BeforeMethod
	public void setUp() throws IOException {
		this.edgedriver = Utility.getWebDriver();
		edgedriver.get(Utility.getProperty("newtoururl"));
		edgedriver.manage().window().maximize();
		edgedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		edgedriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		newToursHomePage = new NewToursHomePage(edgedriver);
		newToursRegisterPage = new NewToursRegisterPage(edgedriver);
		userData = Utility.readExcel();
	}


	@Test
	   public void verifyUserRegistration() throws IOException {
		newToursHomePage.clickOnRegisterLink();
		Utility.waitForElementToBeAvailable(edgedriver, 30, "//input[@name='firstName']");
		newToursRegisterPage.getFirstNameTextBox().sendKeys(userData.get(0));
		newToursRegisterPage.getLastNameTextBox().sendKeys(userData.get(1));
		newToursRegisterPage.getPhoneTextBox().sendKeys(userData.get(2));
		newToursRegisterPage.getEmailTextBox().sendKeys(userData.get(3));
		newToursRegisterPage.getSubmitButton().click();
		Utility.waitForElementToBeAvailable(edgedriver, 30, "//b[contains(text(),'Dear')]");
		System.out.println(newToursRegisterPage.getDearUserLabel().getText());
		assertEquals(newToursRegisterPage.getDearUserLabel().getText(), "Dear " + userData.get(0)+ " " + userData.get(1)+",");
		//assertTrue(newToursRegisterPage.getDearUserLabel().getText().contains(userData.get(0)));
	   }
	@AfterMethod
	public void tearDown(){
		edgedriver.quit();
	}
}
