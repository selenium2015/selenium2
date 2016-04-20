package com.findElement;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ByJQuery {

	public static void main(String[] args) {
		
		String url="https://jquery.org/";
		WebDriver driver=new ChromeDriver();//实例化浏览器，这里使用的是Firefox浏览器
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		driver.get(url);//打开网页				
	
//		List<WebElement> elememts=(List<WebElement>) jse.executeScript("return jQuery.find('.menu-item')");
//		List<WebElement> elememts=(List<WebElement>) jse.executeScript(arg0, 1);
//		assertEquals(10,elememts.size());
//		
		
	}

}
