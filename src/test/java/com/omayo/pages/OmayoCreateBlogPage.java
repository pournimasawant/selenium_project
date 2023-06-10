package com.omayo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OmayoCreateBlogPage {
	//Create blog page related locators
	WebDriver edgedriver;
	WebElement createBlogLink;
	
	
	public OmayoCreateBlogPage(WebDriver edgedriver) {
		this.edgedriver=edgedriver;

	}
    
	public WebElement getCreateBlogLink() {
		setCreateBlogLink();
		return createBlogLink;
	}


	public void setCreateBlogLink() {
		this.createBlogLink = edgedriver.findElement(By.xpath("//a[text()='Create your blog']"));
	}
}
