package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *@author zhongts
 *
 *主页面：包括打开URL，点击登录链接进入登录页面，点击退出链接进入退出确认框
 *
 *
 */
public class MainPage1 {

	WebDriver driver;
	WebElement loginLink;
	WebElement logoutLink;
	
	public MainPage1(WebDriver driver){
		this.driver=driver;		
	}
	
	/**
	 * 打开主页
	 */
	public void openMainPage(String URL){
		driver.get(URL);
		loginLink=driver.findElement(By.linkText("登录"));
	}
	
	/**
	 * 登录
	 */
	public void login(String username,String passwd){
		loginLink.click();
		WebDriverWait wait=new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin")));//显式等待，直到能定位待该元素
		
		LoginPage1 loginPage=new LoginPage1(driver);
		loginPage.login(username, passwd);
	}
	
	/**
	 * 退出
	 */
	public void logout(){
		logoutLink=driver.findElement(By.linkText("退出"));
		logoutLink.click();
		
		LogoutPage1 logoutPage=new LogoutPage1(driver);
		logoutPage.logout();
	}
	
	
}
