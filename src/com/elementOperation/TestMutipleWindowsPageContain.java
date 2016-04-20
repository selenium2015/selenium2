package com.elementOperation;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestMutipleWindowsPageContain {
	WebDriver driver=new FirefoxDriver();

	@Before
	public void setUp() throws Exception {
		driver.get("http://www.w3school.com.cn/jsref/met_win_open.asp");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		String parentId=driver.getWindowHandle();
		assertEquals("HTML DOM open() 方法", driver.getTitle());
		WebElement ele=driver.findElement(By.linkText("打开一个新窗口"));
		ele.click();
		
		Set<String> windowIds=driver.getWindowHandles();
		for (String id : windowIds) {
			if(driver.switchTo().window(id).getPageSource().contains("查看结果")){
				driver.switchTo().window(id);
				break;
			}
		}
		assertEquals("W3School在线测试工具 V2", driver.getTitle());
		
		driver.switchTo().window(parentId);
		assertEquals("HTML DOM open() 方法", driver.getTitle());
		
		
		
	}

}
