package com.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 *@author zhongts
 *
 *	短信息页面
 *	链接：短信息、收件箱、撰写短信息、
 *
 *	page factory
 *
 */
public class MessagePage2 {
	WebDriver driver;
	@FindBy(how=How.LINK_TEXT,linkText="短消息")
	WebElement messageBox;
	@FindBy(how=How.LINK_TEXT,linkText="撰写新短消息")
	WebElement newMessage;
	@FindBy(how=How.LINK_TEXT,linkText="收件箱")
	WebElement receivedMessage;
	
	public MessagePage2(WebDriver driver){
		this.driver=driver;
	}
	
	/**
	 * 进入短消息页面
	 */
	public void enterMessageBox(){
//		messageBox=driver.findElement(By.linkText("短消息"));
		messageBox.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	/**
	 * 发送短消息
	 */
	public void sendMessage(String User,String titleContent,String txtContent){
//		newMessage=driver.findElement(By.linkText("撰写新短消息"));
		newMessage.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//		SendMessagePage1 newMessage=new SendMessagePage1(driver);
		SendMessagePage2 newMessage=PageFactory.initElements(driver, SendMessagePage2.class);
		newMessage.sendNewMessage(User, titleContent, txtContent);
	}
	
	/**
	 * 删除所有收件箱信息
	 */
	public void deleteAllMessage(){
//		receivedMessage=driver.findElement(By.linkText("收件箱"));
		receivedMessage.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//		ReceiveMessagePage1 delMessage=new ReceiveMessagePage1(driver);
		ReceiveMessagePage2 delMessage=PageFactory.initElements(driver, ReceiveMessagePage2.class);
		delMessage.deleteAllMessages();
	}
	
}
