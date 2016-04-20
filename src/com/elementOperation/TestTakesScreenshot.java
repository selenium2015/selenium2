package com.elementOperation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestTakesScreenshot {
	
	WebDriver driver =new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
		driver.get("http://192.168.3.10:9230/ysth-traffic-oms/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws IOException {
		//登录操作
		driver.findElement(By.name("loginName")).sendKeys("zhongts");
		driver.findElement(By.name("loginPwd")).sendKeys("123321");
		driver.findElement(By.id("btnLogin")).click();
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("d:/a.png"));
		
	}

}
