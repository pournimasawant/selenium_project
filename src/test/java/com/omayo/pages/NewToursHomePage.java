package com.omayo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewToursHomePage {
	
	WebDriver edgedriver;
	WebElement registerLink;
	

	public NewToursHomePage(WebDriver edgedriver) {
		this.edgedriver = edgedriver;
	}


	public WebElement getRegisterLink() {
        setRegisterLink();
		return registerLink;
	}


	public void setRegisterLink() {
		this.registerLink = edgedriver.findElement(By.xpath("//a[text()='REGISTER']"));
	}
	public void clickOnRegisterLink() {
		getRegisterLink().click();
	}
	
}
