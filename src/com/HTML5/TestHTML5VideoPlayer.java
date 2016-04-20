package com.HTML5;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * @author zhongts
 * 
 * 5.1.1 功能：HTML5中的Video
 * 步骤：
 * 1）打开videojs主页
 * 2）通过视频播放元素的id定位到该元素
 * 3）通过HTML代码获取视频的播放源，并进行确认
 * 4）通过JavaScript代码播放视频
 * 5）睡眠5秒
 * 6）通过JavaScript代码暂停视频的播放
 * 
 * 
 * 备注：需具有JavaScript基础知识
 * 
 */


public class TestHTML5VideoPlayer {
	
	WebDriver driver =new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
		driver.get("http://www.videojs.com/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testHTML5VideoPlayer() throws InterruptedException {
		//通过id定位到播放元素
		WebElement video=driver.findElement(By.id("preview-player_html5_api"));
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;		
		//通过HTML代码获取视频播放源
		String source=(String)jse.executeScript("return arguments[0].currentSrc;", video);		
		assertEquals("http://vjs.zencdn.net/v/oceans.mp4",source);
		
		//通过JavaScript代码播放视频
		jse.executeScript("return arguments[0].play()", video);
		Thread.sleep(5000);//休眠5秒
		
		//通过JavaScript代码暂停视频
		jse.executeScript("return arguments[0].pause()", video);
	}

}
