package com.wixsite.arielkiell.blockchain.test;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetails {
	WebDriver driver;
	WebDriverWait wait;

	public ProductDetails(WebDriver driver) {
		this.driver = driver;
	}

	public void NavigateToCheckout() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, 50);
		Home home = new Home(driver);
		home.NavigateToProductDetails();
		Thread.sleep(5000);
		//Take screenshot of the product details page 
		General.takeScreenShot();
		
		//Hover on the quantity box 
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.className("bKBvP"))).perform();
		//Select up arrow and double click on it to add 2 more items of the product 
		By upArrow = By.className("_11lkb");
		wait.until(ExpectedConditions.visibilityOfElementLocated(upArrow));
		Actions actions = new Actions(driver);
		actions.doubleClick(driver.findElement(upArrow)).perform();
		
		// Select product color
		By colorRadioBtn = By.xpath("//input[@aria-label='Black']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(colorRadioBtn));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(colorRadioBtn));
		//Take screenshot of the product after selecting quantity and color 
		  General.takeScreenShot();

		// Add the selected items to cart
		By addToCart = By.className("buttonnext3536768744__content");
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
		driver.findElement(addToCart).click();
		//Take screenshot of the cart pop-up after adding the product 
		  General.takeScreenShot();
		  
		//Click on view cart 
		//the button is in different iframe so switch to this iframe 1st
		driver.switchTo().frame(driver.findElement(By.xpath("(.//iframe)[3]")));
		By viewCart = By.id("widget-view-cart-button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewCart));
		driver.findElement(viewCart).click();
		
	}
}
