package com.HTML5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @authorzhongts
 * 5.1.2功能：HTML5中的Canvas
 * 步骤：
 * 1）打开literallycanvas主页
 * 2）定位到绘图区域元素canvas
 * 3）通过actions在canvas上绘制一个封闭图形。
 * 
 *
 * 
 * 
 * 备注：
 * 	Canvas提供了通过JavaScript绘制图形的方法。在HTML页面上是以一块<canvas>为标签的矩形区域。其具有多种绘制图形方法，包括直线，圆圈，字符及绘制图片等。
 * 
 * 
 */

public class TestHTML5Canvas {
	
	WebDriver driver=new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
					
		driver.get("http://literallycanvas.com/");
	}

	@After
	public void tearDown() throws Exception {
//		driver.quit();
	}

	@Test
	public void testHTML5Canvas() throws Exception{
		
		//定位到绘图区域
		WebElement canvas=driver.findElement(By.xpath("//*[@id=\"literally-canvas\"]/div[1]/div[1]/canvas[2]"));		
		Actions drawing=new Actions(driver);		
		drawing.clickAndHold(canvas).moveByOffset(10, 50).moveByOffset(50, 10).moveByOffset(-10, -50).moveByOffset(-50, -10).release().perform();
	}

}
