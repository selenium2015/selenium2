package com.elementOperation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestDialogs {
	WebDriver driver=new FirefoxDriver();
	@Before
	public void setUp() throws Exception {
		driver.get("http://sislands.com/coin70/week1/dialogbox.htm");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testAlertDialog() {
		WebElement alertButton=driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr/td/form[1]/p/input"));
		alertButton.click();
		
		Alert javaScriptAlert=driver.switchTo().alert();//切换到警告框
		System.out.println(javaScriptAlert.getText());//获取警告框的内容
		javaScriptAlert.accept();//接受警告框，即确定		
	}
	
	@Test
	public void testConfirmDialog() {
		WebElement confirmButton=driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr/td/form[3]/p/input"));
		
		//测试确定选项
		confirmButton.click();		
		Alert javaScriptConfirm=driver.switchTo().alert();//切换到确认框
		System.out.println("确认框的内容："+javaScriptConfirm.getText());
		javaScriptConfirm.accept();//确定
		
		javaScriptConfirm=driver.switchTo().alert();//切换到警告框
		System.out.println("警告框的内容："+javaScriptConfirm.getText());
		javaScriptConfirm.accept();
		
		//测试取消选项
		confirmButton.click();		
		javaScriptConfirm=driver.switchTo().alert();//切换到确认框
		System.out.println("确认框的内容2："+javaScriptConfirm.getText());
		javaScriptConfirm.dismiss();//取消
		
		javaScriptConfirm=driver.switchTo().alert();//切换到警告框
		System.out.println("警告框的内容2："+javaScriptConfirm.getText());
		javaScriptConfirm.accept();		
	}
	
	@Test
	public void testPromptDialog() {
		WebElement promptButton=driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr/td/form[2]/p/input"));
		
		promptButton.click();
		Alert javascriptPrompt=driver.switchTo().alert();
		javascriptPrompt.sendKeys("测试提示框，选择确定按钮");
		System.out.println("提示框内容："+javascriptPrompt.getText());
		javascriptPrompt.accept();
		
		javascriptPrompt=driver.switchTo().alert();
		System.out.println("警告框内容："+javascriptPrompt.getText());
		javascriptPrompt.accept();
		
		promptButton.click();
		javascriptPrompt=driver.switchTo().alert();
		javascriptPrompt.sendKeys("测试提示框，选择取消按钮");
		System.out.println("提示框内容2："+javascriptPrompt.getText());
		javascriptPrompt.dismiss();;
		
		javascriptPrompt=driver.switchTo().alert();
		System.out.println("警告框内容2："+javascriptPrompt.getText());
		javascriptPrompt.accept();
		
		
	}

}
