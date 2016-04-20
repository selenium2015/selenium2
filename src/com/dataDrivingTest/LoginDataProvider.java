package com.dataDrivingTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginDataProvider {

	WebDriver driver = new FirefoxDriver();
	WebElement userName;
	WebElement passWd;
	WebElement loginButton;

	@Test(dataProvider = "userName")
	public void login(String uName, String passwd) {
		userName=driver.findElement(By.id("input1"));
		passWd=driver.findElement(By.id("input2"));
		loginButton=driver.findElement(By.id("signin"));		
		
		userName.sendKeys(uName);
		passWd.sendKeys(passwd);
		loginButton.click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.linkText("退出")).click();
		WebDriverWait wait=new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		driver.findElement(By.linkText("登录")).click();
	}
	
	@DataProvider
	public Object[][] userName() {
		return new Object[][] { new Object[] { "webdriver2015", "abc1234!" },
				new Object[] { "webdriver2014", "abc1234!" }
				};
	}

	@BeforeTest
	public void beforeTest() {
		driver.get("http://passport.cnblogs.com/user/signin");
	}

	@AfterTest
	public void afterTest() {
//		driver.quit();		
	}

}
