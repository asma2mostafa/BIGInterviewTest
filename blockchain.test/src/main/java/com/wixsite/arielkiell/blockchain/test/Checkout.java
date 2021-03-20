
package com.wixsite.arielkiell.blockchain.test;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {

	WebDriver driver;
	WebDriverWait wait;


	public Checkout(WebDriver driver) {
		this.driver = driver;
	}

	
    // this function returns the total price and click on checkout button 
	public String GetTotalPrice() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, 50);
		
		//Navigate to checkout screen
		ProductDetails productDetails = new ProductDetails(driver);
		productDetails.NavigateToCheckout();
		Thread.sleep(5000);
		//Take screenshot of the cart screen (checkout screen showing the total price)
		  General.takeScreenShot();
		  
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@title='Cart Page']")));
		
        //Get the total price 
		By estimatedTotal = By.xpath("//dd[@data-hook='estimated-total']");
		String toltalPrice;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(estimatedTotal));
			toltalPrice = driver.findElement(estimatedTotal).getText();
			toltalPrice = toltalPrice.replace("C$", "");
		} catch (Exception e) {
			toltalPrice = "0";
		}
		//Click on checkout button
		By checkOutBtn = By.xpath("//button[@data-hook='checkout-button-button']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutBtn));
		driver.findElement(checkOutBtn).click();
		//Take screenshot after clicking on checkout button
		 General.takeScreenShot();
		 return toltalPrice;

	}

}
