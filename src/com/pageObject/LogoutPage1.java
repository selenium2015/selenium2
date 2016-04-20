package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *@author zhongts
 *
 *	退出：这里只包含退出确认框
 *
 */
public class LogoutPage1 {

	WebDriver driver;
	
	public LogoutPage1(WebDriver driver){
		this.driver=driver;
	}
	
	public void logout(){
//		logoutLink.click();
		WebDriverWait wait=new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.alertIsPresent());//显式等待确认框出现
		driver.switchTo().alert().accept();
	}
}
