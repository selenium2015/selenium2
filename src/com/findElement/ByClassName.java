package com.findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ByClassName {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();//实例化浏览器，这里使用的是Firefox浏览器
		driver.get("http://www.douban.com");//打开网页
		
		WebElement searchBox=driver.findElement(By.className("inp"));//通过name定位元素
		searchBox.sendKeys("UI自动化测试");//发送内容到输入框，即输入内容为：UI自动化测试
		searchBox.submit();
		
	}
}
