package com.eventDeal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/*
 * @author zhongts
 * 
 * 5.3 webdriver的事件处理
 * 	在webdriver存在两个事件处理的类：一个是EventFiringWebDriver，另一个是WebDriverEventListener。所有的WebDriverEventListener对象都需要注册到EventFiringWebDriver上。
 * 
 * 5.3.1 功能：自定义事件侦听
 * 自定义事件侦听有两种方法，一种是实现WebDriverEventListener接口，在实现中添加自定义的逻辑；由于是接口，所以需要用户将所有的接口方法全部实现一遍。
 * 另外一种是通过继承AbstractWebDriverEventListener抽象类来自定义事件侦听并添加自定义的逻辑，只需要对有必要添加自定义逻辑的方法编写覆盖的逻辑代码即可。
 * 
 * 此处以AbstractWebDriverEventListener为例
 * 步骤：
 * 1）通过继承AbstractWebDriverEventListener抽象类，只需覆盖其中需要添加自定义逻辑的方法
 * 2）覆盖afterNavigateTo()方法，表示需要侦听到浏览器到某个页面后触发的事件。
 * 3）覆盖afterNavigateBack()方法，表示需要侦听到浏览器回退浏览某个页面后触发的事件。
 * 4）覆盖afterClickOn()方法，表示需要侦听鼠标单击页面上某个元素后触发的事件。
 * 
 *  
 * 
 * 
 */

public class MyEventListener extends AbstractWebDriverEventListener{
	
	@Override
	public void afterNavigateTo(String url,WebDriver driver){
		System.out.println("after navigate to ： "+url);
	}
	
	@Override
	public void afterNavigateBack(WebDriver driver){
		System.out.println("after navigate back to： "+driver.getCurrentUrl());
	}
	
	@Override
	public void afterClickOn(WebElement webElement,WebDriver driver){
		System.out.println("after click on "+webElement.getTagName());
	}

}
