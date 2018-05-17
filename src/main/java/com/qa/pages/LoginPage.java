package com.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.qa.base.TestBase;
import com.qa.utils.TestUtil;



public class LoginPage extends TestBase {
	
	
	public LoginPage() {
		System.out.println("we are in LoginPage cunstructor");
	PageFactory.initElements(driver,this);
	
	}
	
	//Elements
	@FindBy(id="ch_login_icon")
	WebElement loginButton_Image;
	
	
	@FindBy(id="ch_login_email")
	WebElement UserIdInput;
	
	@FindBy(id="ch_login_password")
	WebElement userPasswordInput;
	
	@FindBy(id="ch_login_btn")
	WebElement loginButton;
	
	//Actions
	
	public void ValidatePageTital() {
		
		String titalOfPage = driver.getTitle();
		Assert.assertEquals(titalOfPage, "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday","Tital of the page does not matched");
				 
	}

	public void login(String userId, String pswd) throws InterruptedException {
		
		
		loginButton_Image.click();
		//Thread.sleep(4000);
		TestUtil.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ch_login_email")));
		UserIdInput.sendKeys(userId);
		userPasswordInput.sendKeys(pswd);
		loginButton.click();
		//return new HomePage();
		
		
	}
	
	public void tearDown() {
		
		driver.close();
	}
	
	
	
}
