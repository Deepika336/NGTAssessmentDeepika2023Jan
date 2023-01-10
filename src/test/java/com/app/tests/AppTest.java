package com.app.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.pages.HomePage;
import com.app.pages.LoginPage;


public class AppTest {
	WebDriver driver;
	LoginPage loginPage;
    Properties obj;
    HomePage homePage;

    

	
	@BeforeMethod(alwaysRun=true)
	public void setUp() throws InterruptedException, Exception {	
		String rootFolder = System.getProperty("user.dir");
		obj=new Properties();
		obj.load(new FileInputStream(rootFolder+"//src//test//resources//App.properties"));
		
	    System.setProperty("webdriver.chrome.driver", rootFolder+"//src//test//resources//chromedriver.exe");
	    
	    String url=obj.getProperty("Url");
	    driver=new ChromeDriver(); 	    
	    driver.get(url);
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	    
		
	}
  @Test
  public void tc1() throws InterruptedException {
	  
	  String uname=obj.getProperty("username");
	  String pswrd=obj.getProperty("pswrd");
	  loginPage=new LoginPage(driver);	 
	  
	 
	  
	  loginPage.Login(uname, pswrd);
	  loginPage.loginClick();
	  Thread.sleep(34000);
	  loginPage.loginClick();
	  Thread.sleep(4000);
	  Assert.assertEquals(driver.findElement(By.xpath("//span[.=\"Profile\"]")).isDisplayed(), true);
	  
  }
  
  @Test 
  public void tc2() throws Exception {
	 
	  String uname=obj.getProperty("username");
	  String pswrd=obj.getProperty("pswrd");
	  homePage=new HomePage(driver);
	  loginPage=new LoginPage(driver);	
	  
	  loginPage.Login(uname, pswrd);
	  loginPage.loginClick();
	  Thread.sleep(34000);
	  loginPage.loginClick();
	  Thread.sleep(4000);
	  
	  
	  WebElement count1=driver.findElement(By.xpath("//span[@data-reactid=\"904\"]"));
	  Assert.assertEquals(count1.getText(),"");
	  Thread.sleep(2000);
	  homePage.addItem();
	  Thread.sleep(2000);
	  WebElement count2=driver.findElement(By.xpath("//span[@data-reactid=\"904\"]"));	 
	  Assert.assertEquals(count2.getText(),"1");
	  
	  
	  
  }
  
  
 
  
  
  @AfterMethod(alwaysRun=true)
  public void tearDown() {
	  driver.quit();
  }
}
