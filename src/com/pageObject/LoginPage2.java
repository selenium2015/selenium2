package com.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *@author zhongts
 *
 *登录页面 
 *	page factory
 *
 *
 */
public class LoginPage2 {
	WebDriver driver;
	
	@FindBy(how=How.ID,id="input1")
	WebElement userName;
	@FindBy(how=How.ID,id="input2")
	WebElement passWd;
	@FindBy(how=How.ID,id="signin")
	WebElement loginButton;
	
	public LoginPage2(WebDriver driver){
		this.driver=driver;		
		//此处可省去driver.findElement方法
	}
	
	public void login(String username,String passwd){
		userName.sendKeys(username);
		passWd.sendKeys(passwd);
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}

}
