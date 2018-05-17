package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utils.TestUtil;
import com.qa.utils.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
 	public  static Properties prop;
 	public  static EventFiringWebDriver e_driver;
 	public static WebDriverEventListener eventListener;
 	
 	
 	
 	public TestBase(){
 		
 		try {
 			prop = new Properties();
 			FileInputStream ip = new FileInputStream("D:\\Users\\khoiwalk\\eclipse-workspace\\"
 					+ "SeleniumFramework\\src\\config\\config.properties");
 					
 			prop.load(ip);
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 	}
 	
 	public static void initialization(){
 		String browserName = prop.getProperty("browser");
 	
 		
 		if(browserName.equals("chrome")){
 			//System.setProperty("webdriver.chrome.driver", "/Users/naveenkhunteta/Downloads/chromedriver");	
 			driver = new ChromeDriver(); 
 		}
 		else if(browserName.equals("FF")){
 			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Downloads/geckodriver");	
			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
 			driver = new FirefoxDriver(); 
 		}
 		
 	// Now create object of EventListerHandler to register it with EventFiringWebDriver
 	 		eventListener = new WebEventListener();
 	 		e_driver = new EventFiringWebDriver(driver);
 	 		e_driver.register(eventListener);
 	 		
 	 		driver = e_driver;
 			
 		
 		
 		
 		driver.manage().window().maximize();
 		driver.manage().deleteAllCookies();
 		
 		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
 		driver.get("https://www.makemytrip.com/");
 		
 		
}
 	
}
