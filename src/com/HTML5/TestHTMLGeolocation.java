package com.HTML5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

/**
 * @authorzhongts 
 * 5.1.4 功能：HTML5中的Geolocation 步骤：
 *  1）选取geolocation Profile
 *  2）通过location.json文件配置Geolocation信息
 *  3）通过制定的profile信息启动Firefox浏览器 
 *  4)通过Firefox浏览器打开HTML5 Geolocation演示页面 
 *  5)通过CSS选择器定位try it 按钮并通过webdriver接口单击该按钮
 *  6）可看到地图上会显示当前用户的位置信息。
 * 
 *  备注： selenium webdriver程序每次重新运行都是新的会话进程。
 *  故无法获取之前的用户设置信息，解决方案为：每次执行selenium
 *  webdriver测试程序时，依旧加载之前的用户设置即可。
 * 
 *  打开用户proflie管理器：运行>firefox -ProfileManager，回车即可。
 * 
 * 
 */

public class TestHTMLGeolocation {

	private static WebDriver driver;

	@Test
	public void testGetLocation() throws Exception {

		driver.findElement(By.cssSelector("html body.html div#wrapper div#maincontent div p.tiy a")).click();

	}

	@BeforeClass
	public void beforeClass() throws Exception {

		FirefoxProfile profile = new ProfilesIni().getProfile("geolocation");
		// 这里配置有问题。。。。。待研究解决
		profile.setPreference("geo.wifi.url","/com.webdriver.selenium/src/webdriver5/location.json");//json需提前创建
		driver.get("http://www.w3school.com.cn/html5/html_5_geolocation.asp");

	}

	@AfterClass
	public void afterClass() throws Exception {
		// driver.quit();
	}

}
