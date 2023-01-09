package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver=driver;		
	}
	
	public void addItem() throws Exception {
WebElement search=driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]"));
search.sendKeys("redmi");
search.sendKeys(Keys.ENTER);
Thread.sleep(2000);
driver.findElement(By.xpath("//img[@title=\"DressBerry Lavender Textured Structured Mobile Pouch\"]")).click();
String currentHandle = driver.getWindowHandle();
for (String handle : driver.getWindowHandles()) {
    if (!handle.equalsIgnoreCase(currentHandle)) {
        driver.switchTo().window(handle);
    }
}

Thread.sleep(2000);
//WebElement addToBagButton= driver.findElement(By.cssSelector("div.pdp-add-to-bag"));
WebElement addToBagButton= driver.findElement(By.cssSelector("div.pdp-add-to-bag"));
addToBagButton.click();



		
		
	}
}
