package com.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * 不使用PageObject机制
 * 
 * 场景1：打开网站；登录网站；进入“短消息”文件夹；发送两条“短消息”；退出登录
 * 场景2：打开网站；登录网站；进入“短消息”文件夹；发送一条“短消息”；进入“收件箱”文件夹；删除所有短信息；退出登录
 * 
 * @author zhongts
 * 测试网址：http://www.cnblogs.com/
 * 测试账号：webdriver2015@126.com  webdriver2015/abc1234!
 * 			webdriver2014@126.com	webdriver2014/abc1234!
 *
 */
public class TestMessageNoPageObject {	
	
	public static void main(String[] args) {
		
		//打开指定的浏览器
//		System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
//		WebDriver driver=new FirefoxDriver();
		
		WebDriver driver=new FirefoxDriver();		
		driver.get("http://www.cnblogs.com/");
		driver.findElement(By.linkText("登录")).click();
		
		By byUserName=By.cssSelector("#input1");
		By byPassWd=By.cssSelector("#input2");
		By byLoginButton=By.cssSelector("#signin");
		
		String userName1="webdriver2015";
		String userName2="webdriver2014";
		String passWd="abc1234!";
		
		//用户1登录
		login(driver, userName1, passWd, byUserName, byPassWd, byLoginButton);		
		
		//进入短信息文件夹
		driver.findElement(By.linkText("短消息")).click();
		//编写发送短信息
		driver.findElement(By.linkText("撰写新短消息")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		if(driver.getTitle().equals("撰写短消息 - 短消息 - 博客园")){
			driver.findElement(By.id("txtIncept")).sendKeys("webdriver2014");
			driver.findElement(By.name("txtTitle")).sendKeys("测试标题1");
			driver.findElement(By.id("txtContent")).sendKeys("测试内容1");
			driver.findElement(By.id("btnSend")).click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}
		
		//编写发送第2条信息
		driver.findElement(By.linkText("撰写新短消息")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		if(driver.getTitle().equals("撰写短消息 - 短消息 - 博客园")){
			driver.findElement(By.id("txtIncept")).sendKeys("webdriver2014");
			driver.findElement(By.name("txtTitle")).sendKeys("测试标题2");
			driver.findElement(By.id("txtContent")).sendKeys("测试内容2");
			driver.findElement(By.id("btnSend")).click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}		
		
		//用户1退出
		By byLogoutButton=By.linkText("退出");
		logout(driver, byLogoutButton);
//		driver.quit();//浏览器退出之后不能再次打开
		
		
		//场景2
		//用户2登录
		login(driver, userName2, passWd, byUserName, byPassWd, byLoginButton);		
		
		//编写发送短信息
		driver.findElement(By.linkText("撰写新短消息")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElement(By.id("txtIncept")).sendKeys("webdriver2015");
			driver.findElement(By.name("txtTitle")).sendKeys("测试标题3");
			driver.findElement(By.id("txtContent")).sendKeys("测试内容3");
			driver.findElement(By.id("btnSend")).click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		//进入收件箱，删除所有短信息
		driver.findElement(By.linkText("收件箱")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement selectAllBox=driver.findElement(By.id("chkSelAll"));
		if(!selectAllBox.isSelected()){
			selectAllBox.click();
		}else{
			selectAllBox.clear();
			selectAllBox.click();
		}
		
		driver.findElement(By.id("btnBatDel")).click();
		WebDriverWait waitForAlert=new WebDriverWait(driver, 2);
		waitForAlert.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();//切换到弹出框
		
		
		//用户2退出
//		logout(driver, byLogoutButton);
		

	}
	
	/**
	 * 登录
	 */
	public static void login(WebDriver driver,String userName,String passWd,By byUserName,By byPassWd,By byLoginButton){
		
		driver.findElement(byUserName).sendKeys(userName);
		driver.findElement(byPassWd).sendKeys(passWd);
		driver.findElement(byLoginButton).click();
		//加载页面,隐式等待3秒
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);		
	}
	
	/**
	 * 退出
	 */
	public static void logout(WebDriver driver,By byLogoutButton){
		WebDriverWait wait=new WebDriverWait(driver, 2);
		
		driver.findElement(byLogoutButton).click();	
		wait.until(ExpectedConditions.alertIsPresent());//直到弹出框出现
		driver.switchTo().alert().accept();
	}


}
