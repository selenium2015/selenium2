package com.RemoteWebDriver;

import java.io.File;

import org.openqa.grid.web.servlet.DriverServlet;
import org.seleniumhq.jetty7.server.Server;
import org.seleniumhq.jetty7.server.nio.SelectChannelConnector;
import org.seleniumhq.jetty7.webapp.WebAppContext;

/*
 *@authorzhongts
 *5.2.3功能：在代码中配置Remote webdriver服务器端
 *步骤：
 *1）Remote webdriver的DriverServlet可封装在一个轻量级的servlet容器中，如jetty。
 *2）将下载的selenium-server.jar放置到系统的classpath下
 *3）创建一个新的类JettyEmbeddedSeleniumServer
 *4）
 *5） 
 * 
 * 备注：
 * 	需安装jetty的eclipse插件，在eclipse marketplace中搜索安装即可。
 * 
 * 
 */

public class JettyEmbeddedSeleniumServer {

	public static void main(String s[]) throws Exception {

		Server server=new Server();		
		WebAppContext context=new WebAppContext();		
		context.setContextPath("");		
		File st=new File(".");		
		context.setWar(st.getPath());		
		context.addServlet(DriverServlet.class, "/wd/*");		
		SelectChannelConnector connector=new SelectChannelConnector();		
		connector.setPort(3002);		
		server.addConnector(connector);		
		server.start();
	
	}

}
