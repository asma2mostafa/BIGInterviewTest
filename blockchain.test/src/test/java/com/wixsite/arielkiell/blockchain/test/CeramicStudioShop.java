package com.wixsite.arielkiell.blockchain.test;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CeramicStudioShop {

	WebDriver driver;
	WebDriverWait wait;
	

	@Test
	public void addProductstoCart() throws InterruptedException, AWTException {

		 
		Checkout checkout = new Checkout(driver);
		//check if the total amount at the checkout time = 75 CAD
		Assert.assertEquals("75.00", checkout.GetTotalPrice());
		
		
	}

	@BeforeClass
	public void BeforeClass() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

	}

	@BeforeMethod
	public void BeforeMethod() {
		driver = new ChromeDriver();

	}

	@AfterMethod
	public void AfterMethod() {
		
		driver.quit();

	}
	
	

}
