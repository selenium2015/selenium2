package com.pageObject;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *@author zhongts
 *
 * page factory
 *
 *
 */
public class TestMessageWithPageObject2 {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		
		MainPage2 mainPage=PageFactory.initElements(driver, MainPage2.class);
		MessagePage2 messagePage=PageFactory.initElements(driver, MessagePage2.class);
		Date d=new Date();
		
		//场景1：打开网站；登录网站；进入“短消息”文件夹；发送两条“短消息”；退出登录
		//打开网页
		mainPage.openMainPage("http://www.cnblogs.com/");
		//登录
		mainPage.login("webdriver2015", "abc1234!");
		//进入短信息页面
		messagePage.enterMessageBox();
		//发送2条短信息
		messagePage.sendMessage("webdriver2014", d.toString(), d.toString());
		messagePage.sendMessage("webdriver2014", d.toString(), d.toString());		
		//退出
		mainPage.logout();
		
//		//场景2 ：打开网站；登录网站；进入“短消息”文件夹；发送一条“短消息”；进入“收件箱”文件夹；删除所有短信息；退出登录
//		mainPage.openMainPage("http://www.cnblogs.com/");
//		mainPage.login("webdriver2014", "abc1234!");
//		messagePage.enterMessageBox();
//		messagePage.sendMessage("webdriver2015", d.toString(), d.toString());
//		//进入收件箱，删除所有信息		
//		messagePage.deleteAllMessage();
//		mainPage.logout();
		
//		driver.quit();
		

	}

}
