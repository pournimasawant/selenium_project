package com.omayo.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.codemind.utility.Utility;
import com.omayo.pages.OmayoHomePage;


public class VerifyHomePage {
	WebDriver edgedriver;
    OmayoHomePage omayoHomePage;
    SoftAssert softAssert;
	
    @BeforeMethod
	public void setUp() throws IOException {
		this.edgedriver = Utility.getWebDriver();
		edgedriver.get(Utility.getProperty("url"));
		edgedriver.manage().window().maximize();
		omayoHomePage = new OmayoHomePage(edgedriver);
	    softAssert = new SoftAssert();
    }
    
    @Test(priority = 0)
    public void verifyUserAbleToSelectOptionsFromDropdown() {
    	// hard assertion
    	/*assertEquals(omayoHomePage.getHomePageTitle(), "omayo (QAFox.com)");
    	*
    	*assertTrue(omayoHomePage.getHomePageTitle().equals("omayo (QAFox.com)"));
    	*
    	*assertNotEquals(omayoHomePage.getHomePageTitle(), "omayo (QAFox.com");
    	*
    	*System.out.println("After assertion failure");
    	*
    	*assertFalse(omayoHomePage.getHomePageTitle().equals("omayo (QAFox"));
    	*/
    	
    	//soft assertion
    	softAssert.assertEquals(omayoHomePage.getHomePageTitle(), "omayo (QAFox.com)");
    	
    	softAssert.assertTrue(omayoHomePage.getHomePageTitle().equals("omayo (QAFox.com)"));
    	
    	//softAssert.assertNotEquals(omayoHomePage.getHomePageTitle(), "omayo (QAFox.com");
    	
    	System.out.println("After assertion failure");
    	
    	softAssert.assertFalse(omayoHomePage.getHomePageTitle().equals("omayo (QAFox"));
       
    	// verify page url
    	softAssert.assertEquals(omayoHomePage.getHomePageUrl(), "http://omayo.blogspot.com/");
    	
    	assertEquals(omayoHomePage.getOnePageLink().getText(), "Page One");
    	
    	softAssert.assertFalse(omayoHomePage.getMaleRadioButton().isSelected());
    	
    	softAssert.assertAll();
    	
   
    
    }
    @AfterMethod
    public void tearDown() {
    	edgedriver.quit();
    }

}
