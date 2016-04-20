package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *@author zhongts
 *
 *撰写短信页面
 *	输入框：收件人、主题、内容
 *	按钮：发送
 *	page factory
 *
 */
public class SendMessagePage2 {
	WebDriver driver;
	@FindBy(how=How.NAME,name="txtIncept")
	WebElement toUser;
	@FindBy(how=How.NAME,name="txtTitle")
	WebElement title;
	@FindBy(how=How.ID,id="txtContent")
	WebElement content;
	@FindBy(how=How.ID,id="btnSend")
	WebElement sendButton;
	
	public SendMessagePage2(WebDriver driver){
		this.driver=driver;
//		toUser=driver.findElement(By.name("txtIncept"));
//		title=driver.findElement(By.name("txtTitle"));
//		content=driver.findElement(By.id("txtContent"));
//		sendButton=driver.findElement(By.id("btnSend"));
	}
	
	public void sendNewMessage(String User,String titleContent,String txtContent){
		toUser.sendKeys(User);
		title.sendKeys(titleContent);
		content.sendKeys(txtContent);
		sendButton.click();		
	}
	
	
}
