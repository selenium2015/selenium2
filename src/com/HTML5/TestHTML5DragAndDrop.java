package com.HTML5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


/*
 * @authorzhongts
 * 5.1.3功能：HTML5中的Drag和Drop
 * 步骤：
 * 1）打开jqueryui官方可拖拽例子的页面
 * 2）使用switchTo().frame切换焦点到iFrame上，并定位该元素
 * 3）确认需要移动的元素（矩形方框），其id为draggable：
 * 		一、确认该矩形方框在当前页面为可见；
 * 		二、确认该矩形方框存在后，通过actions来拖拽该矩形方框放置到新的位置。
 * 
 * 
 * 
 * 备注：
 * 	iFrame用来表示文档中的浮动框架。本例主要展示如何在selenium webdriver中操作iFrame。
 * 
 * http://jqueryui.com/draggable/
 * 
 */


public class TestHTML5DragAndDrop {

	WebDriver driver =new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
		driver.get("http://jqueryui.com/draggable/");
	}

	@After
	public void tearDown() throws Exception {
//		driver.quit();
	}

	@Test
	public void testHTML5DragAndDrop()throws Exception {
		//切换到可移动的iFrame，定位到该元素
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		Thread.sleep(5000);
		
		if(!isElementPresent(By.xpath("/html/body/div"))){
			Thread.sleep(3000);
		}
		WebElement draggable=driver.findElement(By.xpath("/html/body/div"));
		
		new Actions(driver).dragAndDropBy(draggable, 200, 10).build().perform();
				
		Thread.sleep(10000);
	}

	private boolean isElementPresent(By by) {
				
		try{
			driver.findElement(by);
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
		return false;
	}

}
