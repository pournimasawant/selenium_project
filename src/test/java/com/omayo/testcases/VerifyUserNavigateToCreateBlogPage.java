package com.omayo.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codemind.utility.Utility;
import com.omayo.pages.OmayoCreateBlogPage;
import com.omayo.pages.OmayoHomePage;


public class VerifyUserNavigateToCreateBlogPage {
     
	WebDriver edgedriver;
	OmayoHomePage omayoHomePage;
	OmayoCreateBlogPage omayoCreateBlogPage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		this.edgedriver = Utility.getWebDriver();
		edgedriver.get(Utility.getProperty("url"));
		edgedriver.manage().window().maximize();
		omayoHomePage = new OmayoHomePage(edgedriver);
		omayoCreateBlogPage = new OmayoCreateBlogPage(edgedriver);
		edgedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		edgedriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
	}
	
	@Test
	public void verifyUserAbleToSelectOptionsFromDropdown()
	{
		Utility.switchToFrame(edgedriver, omayoHomePage.getFrame1());
	    omayoHomePage.getCreateBlog().click();
	    Utility.switchBackToDefaultContent(edgedriver);
	    Utility.waitForElementToBeAvailable(edgedriver, 60, "//a[text()='Create your blog']");
	    omayoCreateBlogPage.getCreateBlogLink().click();
	    
	}
	
	@AfterMethod
	public void tearDown(){
		//edgedriver.quit();
	}


}
