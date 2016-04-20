package com.RemoteWebDriver;


import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/*
 * @auther zhongts
 * 
 * 5.2.4功能：remote webdriver客户端
 * 步骤：
 * 1）以Firefox浏览器为driver，启动本地的Remote WebDriver
 * 2）打开百度主页
 * 3）由于Firefox driver本身具备截屏功能，所以可通过Augmenter来增强Remote WebDriver的功能，完成之前不具备的截屏功能。
 * 4）保存截图到具体文件中。
 * 5）
 * 
 * 备注：
 * 	remote webdriver不能直接使用takesscreenshot接口来进行截屏。但如果浏览器本身的driver具备截屏的功能，
 * 	就可以通过takesscreenshot接口的augmenter类来间接完成在	remote webdriver中截取屏幕的操作。
 * 	
 * 
 */

public class TestRemoteWebDriverTakesScreenshot {
	
	WebDriver driver;
	//URL 是什么？
	//http://www.cnblogs.com/tobecrazy/p/4564902.html
	@Before
	public void setUp() throws Exception {

		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.firefox());			
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testRemoteWebDriverTakesScreenshot() throws Exception{
		driver.get("http://www.baidu.com");		
		WebDriver augmentedDriver=new Augmenter().augment(driver);		
		File Screenshot=((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(Screenshot, new File("/Selenium 2/remotewebdriver_screenshot.png"));
	}
}
