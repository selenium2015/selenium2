package com.elementOperation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * 操作页面元素：单选按钮
 * @author zhongts
 *
 */
public class TestRadioButton {
	WebDriver driver=new FirefoxDriver();
	String url="http://www.w3school.com.cn/html/html_forms.asp";
	
	@Before
	public void setUp() throws Exception {
		driver.get(url);
	}

	@After
	public void tearDown() throws Exception {
//		driver.close();
		driver.quit();
	}

	@Test
	public void test() {
		/**
		 * 判断是否选中状态
		 * 如果没有就选中
		 * 断言对应按钮被选中
		 */
		WebElement maleRadioButton=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[5]/form[2]/input[1]"));
		
		if(!maleRadioButton.isSelected()){
			maleRadioButton.click();
		}else{
			System.out.println(maleRadioButton.getAttribute("value")+"已经是选中状态");
		}
		
		assertTrue(maleRadioButton.isSelected());		
		
	}

}
