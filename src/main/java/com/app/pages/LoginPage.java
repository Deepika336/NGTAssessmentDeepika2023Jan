package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;		
	}
	
	public void Login(String username,String pswrd) {
		driver.findElement(By.xpath("//input[@id='mobileNumberPass']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@class='form-control has-feedback']")).sendKeys(pswrd);
		
	}
	
	public void loginClick() {
		driver.findElement(By.xpath("//button[@class='btn primary  lg block submitButton']")).click();
	}

}
