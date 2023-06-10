package com.omayo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewToursRegisterPage {
  WebDriver edgedriver;
  WebElement firstNameTextBox;
  WebElement lastNameTextBox;
  WebElement phoneTextBox;
  WebElement emailTextBox;
  WebElement submitButton;
  WebElement dearUserLabel;
  
  public NewToursRegisterPage(WebDriver edgedriver) {
	  this.edgedriver = edgedriver;
  }
  
  public WebElement getFirstNameTextBox() {
	  setFirstNameTextBox();
	return firstNameTextBox;
}

   public void setFirstNameTextBox() {
	this.firstNameTextBox = edgedriver.findElement(By.xpath("//input[@name='firstName']"));
}

public WebElement getLastNameTextBox() {
	setLastNameTextBox();
	return lastNameTextBox;
}

public void setLastNameTextBox() {
	this.lastNameTextBox =  edgedriver.findElement(By.xpath("//input[@name='lastName']"));
}

public WebElement getPhoneTextBox() {
	setPhoneTextBox();
	return phoneTextBox;
}

public void setPhoneTextBox() {
	this.phoneTextBox =  edgedriver.findElement(By.xpath("//input[@name='phone']"));
}

public WebElement getEmailTextBox() {
	setEmailTextBox();
	return emailTextBox;
}

public void setEmailTextBox() {
	this.emailTextBox =  edgedriver.findElement(By.xpath("//input[@id='userName']"));
}

public WebElement getSubmitButton() {
	setSubmitButton();
	return submitButton;
}

public void setSubmitButton() {
	this.submitButton = edgedriver.findElement(By.xpath("//input[@name='submit']"));
}

public WebElement getDearUserLabel() {
	setDearUserLabel();
	return dearUserLabel;
}

public void setDearUserLabel() {
	this.dearUserLabel = edgedriver.findElement(By.xpath("//b[contains(text(),'Dear')]"));
}




	
}
