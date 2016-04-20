package com.elementOperation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author zhongts
 * 
 * 4.5.7.2 功能：展示如何读取之前保存的cookies信息（4.5.7），并用于自动填充到新打开的浏览器cookies中，然后直接进入登录状态后的页面。
 * 步骤：
 * 	1）打开登录页面
 * 	2）读取之前保存cookies信息的文件zhihu.cookie.txt，并通过缓存操作和driver.manage().addCookies()操作将登录信息填充到浏览器的cookies中
 * 	3）打开知乎主页，就可看到直接进入登录状态后的页面。
 * 
 * 备注：需在TestGetCookies运行成功的基础上运行。
 *
 */
public class TestAddCookies {
	private static BufferedReader bufferedReader;
	
	public static void main(String[] args) {
		WebDriver driver =new FirefoxDriver();
		driver.get("http://www.zhihu.com/#signin");
		
		try{
			File cookieFile=new File("d:/cookies.txt");
			FileReader fr=new FileReader(cookieFile);
			bufferedReader=new BufferedReader(fr);
			
			String line;
			
			while((line=bufferedReader.readLine())!=null){
				StringTokenizer stringTokenizer=new StringTokenizer(line,";");
				
				while(stringTokenizer.hasMoreTokens()){
					String name=stringTokenizer.nextToken();
					String value=stringTokenizer.nextToken();
					String domain=stringTokenizer.nextToken();
					String path=stringTokenizer.nextToken();
					
					Date expiry=null;
					String dt;
					
					if(!(dt=stringTokenizer.nextToken()).equals("null")){
						expiry=new Date(dt);
					}
					
					boolean isSecure=new Boolean(stringTokenizer.nextToken()).booleanValue();
					
					Cookie cookie=new Cookie(name,value,domain,path,expiry,isSecure);
					driver.manage().addCookie(cookie);
				}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();			
		}
		driver.get("http://www.zhihu.com/");
		
	}

}
