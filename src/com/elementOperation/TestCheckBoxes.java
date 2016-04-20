package com.elementOperation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCheckBoxes {
	WebDriver driver=new FirefoxDriver();
	String url="http://www.w3school.com.cn/html/html_forms.asp";
	
	@Before
	public void setUp() throws Exception {
		driver.get(url);
	}

	@After
	public void tearDown() throws Exception {
//		driver.quit();
	}

	@Test
	public void test() {
		WebElement bike=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[5]/form[3]/input[1]"));
//		WebElement bike=driver.findElement(By.cssSelector("#maincontent > div:nth-child(6) > form:nth-child(19) > input[type=\"checkbox\"]:nth-child(1)"));
		if(!bike.isSelected()){
			bike.click();
		}else{
			System.out.println(bike.getAttribute("value")+"已经处于被选中状态！");
		}
		
		assertTrue(bike.isSelected());
		
	}

}
