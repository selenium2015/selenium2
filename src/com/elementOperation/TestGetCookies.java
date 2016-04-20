package com.elementOperation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/* @author zhongts
 *  4.5.7 功能：操作浏览器cookies之获取cookies
 * 步骤：
 * 	1）打开知乎，切换到登录页面
 * 	2）填写账户密码，点击登录
 * 	3）新建一个本地文件zhihu.cookie.txt，用于存储后续获取的cookies信息
 * 	4）通过driver.manage().getCookies()获取cookies信息并通过缓存和文件写操作，保存到zhihu.cookie.txt文件中。
 * 	
 * 
 * 测试账号:webdriver2015@126.com,abc123;
 * 			知乎：webdriver2015,webdriver2015@126.com,abc123;
 * 
 * 
 */
public class TestGetCookies {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.zhihu.com/#signin");
		
		WebElement userName=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div[1]/div[1]/input"));
		userName.sendKeys("webdriver2015@126.com");
		
		WebElement password=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div[1]/div[2]/input"));
		password.sendKeys("abc123");
		
		WebElement loginButton=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		loginButton.click();
		
		File cookiesTxt=new File("d:/cookies.txt");
		
		try {
			cookiesTxt.delete();//如果存在就先删除
			cookiesTxt.createNewFile();
			
			FileWriter fileWriter=new FileWriter(cookiesTxt);
			BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
			
			for (Cookie cookie : driver.manage().getCookies()) {
				bufferedWriter.write(cookie.getName()+";"+cookie.getValue()+";"+cookie.getDomain()+";"+cookie.getPath()+";"+cookie.getExpiry()+";"+cookie.isSecure());
				bufferedWriter.newLine();				
			}
			bufferedWriter.flush();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		driver.quit();
	}

}
