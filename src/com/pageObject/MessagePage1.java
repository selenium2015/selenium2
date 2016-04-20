package com.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *@author zhongts
 *
 *	短信息页面
 *	链接：短信息、收件箱、撰写短信息、
 *
 *
 */
public class MessagePage1 {
	WebDriver driver;
	WebElement messageBox;
	WebElement newMessage;
	WebElement receivedMessage;
	
	public MessagePage1(WebDriver driver){
		this.driver=driver;
	}
	
	/**
	 * 进入短消息页面
	 */
	public void enterMessageBox(){
		messageBox=driver.findElement(By.linkText("短消息"));
		messageBox.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	/**
	 * 发送短消息
	 */
	public void sendMessage(String User,String titleContent,String txtContent){
		newMessage=driver.findElement(By.linkText("撰写新短消息"));
		newMessage.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		SendMessagePage1 newMessage=new SendMessagePage1(driver);
		newMessage.sendNewMessage(User, titleContent, txtContent);
	}
	
	/**
	 * 删除所有收件箱信息
	 */
	public void deleteAllMessage(){
		receivedMessage=driver.findElement(By.linkText("收件箱"));
		receivedMessage.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		ReceiveMessagePage1 delMessage=new ReceiveMessagePage1(driver);
		delMessage.deleteAllMessages();
	}
	
}
