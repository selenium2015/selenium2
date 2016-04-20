package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *@author zhongts
 *
 *撰写短信页面
 *	输入框：收件人、主题、内容
 *	按钮：发送
 *
 *
 */
public class SendMessagePage1 {
	WebDriver driver;
	WebElement toUser;
	WebElement title;
	WebElement content;
	WebElement sendButton;
	
	public SendMessagePage1(WebDriver driver){
		this.driver=driver;
		toUser=driver.findElement(By.name("txtIncept"));
		title=driver.findElement(By.name("txtTitle"));
		content=driver.findElement(By.id("txtContent"));
		sendButton=driver.findElement(By.id("btnSend"));
	}
	
	public void sendNewMessage(String User,String titleContent,String txtContent){
		toUser.sendKeys(User);
		title.sendKeys(titleContent);
		content.sendKeys(txtContent);
		sendButton.click();		
	}
	
	
}
