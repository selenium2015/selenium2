package com.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * 
 * @author zhongts
 * 
 * 登录页面
 * 
 *
 */
public class LoginPage1 {
	
	WebDriver driver;
	WebElement userName,passWd,loginButton;
	
	public LoginPage1(WebDriver driver){//传参一般都是传：变化的，即根据实际情况而变化的
		this.driver=driver;
		userName=driver.findElement(By.id("input1"));
		passWd=driver.findElement(By.id("input2"));
		loginButton=driver.findElement(By.id("signin"));
	}
	
	public void login(String username,String passwd){
		userName.sendKeys(username);
		passWd.sendKeys(passwd);
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
}
