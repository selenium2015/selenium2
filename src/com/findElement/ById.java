package com.findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;




public class ById {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();//实例化浏览器，这里使用的是Firefox浏览器
		driver.get("http://www.baidu.com");//打开网页
		
		WebElement searchBox=driver.findElement(By.id("kw"));//通过ID定位元素，此处是百度的输入框
		searchBox.sendKeys("UI自动化测试");//发送内容到输入框，即输入内容为：UI自动化测试
//		searchBox.sendKeys(Keys.SHIFT,"webdriver");//输入特殊字符
//		searchBox.clear();
		

//		System.out.println(searchBox.isDisplayed());
		
		WebElement searchButton=driver.findElement(By.id("su"));
		searchButton.submit();//提交查询

		driver.close();//关闭浏览器
	
	}

}
