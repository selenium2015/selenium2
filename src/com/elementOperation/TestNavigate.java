package com.elementOperation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 浏览器的前进、后退、刷新操作
 * @author zhongts
 *
 */
public class TestNavigate {
/**
 * 打开网址：http://www.baidu.com
 * 跳转到网址：http://www.zhihu.com
 * 刷新
 * 后退
 * 前进
 * @param args
 */
	public static void main(String[] args) {
		WebDriver driver =new FirefoxDriver();
		driver.get("http://www.baidu.com");
		
		driver.navigate().to("http://www.zhihu.com");
		System.out.println("go to URL："+driver.getCurrentUrl());
		
		driver.navigate().refresh();
		
		driver.navigate().back();
		System.out.println("back to URL："+driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println("forward to URL："+driver.getCurrentUrl());
		
		driver.quit();
	}

}
