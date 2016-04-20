package com.elementOperation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 页面元素的超时时间
 * @author zhongts
 *
 */
public class TestWait {

	public static void main(String[] args) {

		WebDriver driver =new FirefoxDriver();
		driver.get("http://www.baidu.com");
		
		WebElement searchBox=driver.findElement(By.name("wd"));
		searchBox.sendKeys("WebDriver");
		driver.findElement(By.id("su")).click();		
		
		//显式等待explicit
		//等待条件为，直到浏览器标题为以WebDriver为开头出现后才进行后续操作。
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d){
				return d.getTitle().toLowerCase().startsWith("webdriver");				
			}
		});
		System.out.println("Page title is:"+driver.getTitle());
		
		driver.navigate().back();//为下面隐式等待的条件
		
		//隐式等待implicit
		//等待条件为，最长等待10秒，如果在10秒内就回退到前一个页面，则执行后续操作。
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
//		driver.quit();

	}

}
