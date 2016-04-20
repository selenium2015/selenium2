package com.dataDrivingTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestLogin {
	WebDriver driver=new FirefoxDriver();
	WebElement userName;
	WebElement passWd;
	WebElement loginButton;	
	
	
	@Test
	@Parameters("username")
	public void testLogin(String uName) {
		userName=driver.findElement(By.id("input1"));
		passWd=driver.findElement(By.id("input2"));
		loginButton=driver.findElement(By.id("signin"));		
		
		userName.sendKeys(uName);
		passWd.sendKeys("abc1234!");
		loginButton.click();		
	}

	@BeforeClass
	public void beforeClass() {
		driver.get("http://passport.cnblogs.com/user/signin");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
