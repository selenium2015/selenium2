package com.findElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ByTagName {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.mi.com/");
		
		List<WebElement> scriptList=driver.findElements(By.tagName("script"));
		
		System.out.println(scriptList.size());
		
		for (WebElement webElement : scriptList) {
			System.out.print(webElement);
		}
		
	}
}
