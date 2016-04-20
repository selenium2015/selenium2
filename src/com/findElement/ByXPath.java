package com.findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ByXPath {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();//实例化浏览器，这里使用的是Firefox浏览器
		driver.get("http://www.baidu.com");//打开网页
		
		//*[@id="kw"]
		WebElement searchBox=driver.findElement(By.xpath("//*[@id=\"kw\"]"));
		searchBox.sendKeys("webdriver");
		WebElement searchButton=driver.findElement(By.cssSelector("//*[@id=\"su\"]")); 
		searchButton.submit();

	}
}
