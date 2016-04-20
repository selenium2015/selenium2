package com.eventDeal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/*
 * @author zhongts
 * 5.3.2 功能：事件处理实例
 * 	在5.3.1自定义了事件侦听后，实例演示
 * 
 * 步骤：
 * 1）用FirefoxDriver实例化webdriver对象
 * 2）实例化EventFiringWebDriver对象，并将webdriver对象实例传递给eventFiringDriver
 * 3)实例化自定义事件侦听对象MyEventListener，并将MyEventListener对象注册到EventFiringWebDriver对象中
 * 4)使用EventFiringWebDriver对象打开搜狗主页，此时会触发自定义事件侦听中的afterNavigateTo()方法，并打印日志。
 * 5）使用EventFiringWebDriver对象执行浏览器回退操作，此时会触发自定义事件侦听中的afterNavigateAfter()方法，并打印日志。
 * 6）使用EventFiringWebDriver对象查找搜狗主页上的搜索按钮，并进行单击，此时会触发自定义事件侦听中的afterClickOn()方法，并打印日志。
 * 7）
 * 8）
 * 
 * 备注：
 * 	通过自定义事件侦听，可以更方便地记录测试代码的执行与各种页面操作的预期步骤是否一致；
 * 也可以很方便地在某件事件发生后，添加一些辅助代码来协助后续测试用例的执行。
 * 
 * 
 */
public class TestWedDriverEvent {

	public static void main(String[] args) {

		WebDriver driver=new FirefoxDriver();		
		EventFiringWebDriver eventFiringDriver=new EventFiringWebDriver(driver);
		
		MyEventListener myEventListener=new MyEventListener();		
		eventFiringDriver.register(myEventListener);
		
		eventFiringDriver.get("https://www.sogou.com/");
		eventFiringDriver.get("https://www.baidu.com/");
		
		eventFiringDriver.navigate().back();		
		eventFiringDriver.findElement(By.id("stb")).click();
		
		driver.quit();


	}

}
