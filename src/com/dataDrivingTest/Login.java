package com.dataDrivingTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *@author zhongts
 *
 * 演示数据驱动测试
 * junit 不支持数据参数化测试
 *
 */
public class Login {
	WebDriver driver=new FirefoxDriver();
	WebElement userName;
	WebElement passWd;
	WebElement loginButton;
	
	@Before
	public void setUp() throws Exception {
		driver.get("http://passport.cnblogs.com/user/signin");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testLogin() {
		
		userName=driver.findElement(By.id("input1"));
		passWd=driver.findElement(By.id("input2"));
		loginButton=driver.findElement(By.id("signin"));		
		
		List<String> list=new ArrayList<String>();
		
		try {
			BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream("d:/userName.txt")));
			String password;
			while((password=in.readLine())!=null){
				list.add(password);
				for(int i=0;i<list.size()-1;i++){
					userName.sendKeys(list.get(i));
					passWd.sendKeys("abc1234!");
					loginButton.click();					
					
					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//					boolean result=driver.getPageSource().contains(list.get(i));//断言：出现用户名	
//					Assert.assertTrue(result);

					driver.findElement(By.linkText("退出")).click();
					WebDriverWait wait=new WebDriverWait(driver, 3);
					wait.until(ExpectedConditions.alertIsPresent());
					driver.switchTo().alert().accept();	
					
					System.out.println(driver.getCurrentUrl());
					driver.findElement(By.xpath("//*[@id=\"header_user_right\"]/a[1]")).click();
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				}
			}
		} catch (IOException  e) {
			e.printStackTrace();
		}		
	}
}
