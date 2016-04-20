package com.findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ByLinkTextAndPartialLinkText {

	public static void main(String[] args) {

		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.winshines.com.cn/");
		
//		WebElement textElement=driver.findElement(By.linkText("联系我们"));
		WebElement textElement=driver.findElement(By.partialLinkText("联系"));
		textElement.click();
		

	}

}
