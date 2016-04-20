package com.elementOperation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestMaxSizeBrower {
	WebDriver driver=new FirefoxDriver();

	@Before
	public void setUp() throws Exception {
		driver.get("http://www.baidu.com");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		driver.manage().window().maximize();
		
	}

}
