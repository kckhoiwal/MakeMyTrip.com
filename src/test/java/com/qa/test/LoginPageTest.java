package com.qa.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtil;



public class LoginPageTest extends TestBase{
	public  LoginPage loginPage;
	public  TestUtil testUtils;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeSuite
	public void test1() {
	initialization();
	testUtils = new TestUtil();
	loginPage = new LoginPage();
	}
	
	@Test
	public void test2() {
		System.out.println("We are in test 1");
		loginPage.ValidatePageTital();
			}
	
	@Test
	public void test3() throws InterruptedException  {
		System.out.println("We are in test 2");
		System.out.println(prop.getProperty("useerId"));
		System.out.println(prop.getProperty("password"));
		//Thread.sleep(10000);
		loginPage.login(prop.getProperty("useerId"), prop.getProperty("password"));
	}
	
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
	}
}
