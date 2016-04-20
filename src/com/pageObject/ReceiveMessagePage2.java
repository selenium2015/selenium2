package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *@author zhongts
 *
 * 收件箱页面
 * 	复选框；
 * 	删除按钮；
 *	
 *	page factory
 *
 */
public class ReceiveMessagePage2 {
	WebDriver driver;
	@FindBy(how=How.ID,id="chkSelAll")
	WebElement checkBoxForSelectAll;
	@FindBy(how=How.ID,id="btnBatDel")
	WebElement deleteAllButton;
	
	public ReceiveMessagePage2(WebDriver driver){
		this.driver=driver;
//		checkBoxForSelectAll=driver.findElement(By.id("chkSelAll"));
//		deleteAllButton=driver.findElement(By.id("btnBatDel"));
	}
	
	/**
	 * 删除所有收件箱的信息
	 */
	public void deleteAllMessages(){
		//检查收件箱是否为空，空则没checkBoxForSelectAll
		if(!driver.getPageSource().contains("选中所有")){
			System.out.println("收件箱为空，不用进行删除操作！");
		}else{
			
			//检查复选框是否处于选中状态
			if(!checkBoxForSelectAll.isSelected()){
				checkBoxForSelectAll.click();
			}
			//删除所有信息
			deleteAllButton.click();
			
			WebDriverWait wait=new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());			
			driver.switchTo().alert().accept();
		}
	}
}
