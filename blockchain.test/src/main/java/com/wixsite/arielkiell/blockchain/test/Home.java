package com.wixsite.arielkiell.blockchain.test;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
	
	WebDriver driver;
	WebDriverWait wait;

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	public void NavigateToProductDetails() throws AWTException {
		// Open the site
		driver.navigate().to("https://arielkiell.wixsite.com/interview");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 50);
		//Take screenshot of the home page
		General.takeScreenShot();
		
		// Navigate to shop
		By shopNowBtn = By.xpath("//div[@id=\'comp-j4o1o5uu\']/a[@class='_1_kc0']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(shopNowBtn));
		driver.findElement(shopNowBtn).click();
		//Take screenshot of shop
		General.takeScreenShot();

		// Select the 4th product 
		By selectProduct = By.xpath("(//img[@class='_17TsC _3dS0Z _2lsYE'])[4]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectProduct));
		driver.findElement(selectProduct).click();
		
	}
}
