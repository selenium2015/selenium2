package com.elementOperation;

import java.io.File;

import org.openqa.selenium.io.TemporaryFilesystem;

/**
 * 
 * 4.6.7 功能：临时目录操作
 * 步骤：
 * 	1）实例化TemporaryFilesystem对象
 * 	2）获取目录的绝对路径
 * 	3）获得临时目录可用空间
 * 
 * 备注：
 * prefix：前缀
 * suffix：后缀
 * 备注：
 * 	WebDriver提供了一个操作临时文件系统的类TemporaryFilesystem。
 *  
 */

public class TestTemporaryFileSystem {
	public static void main(String...args){
		//创建临时目录
		File tempDiretory=TemporaryFilesystem.getDefaultTmpFS().createTempDir("prefix", "suffix");
		//绝对路径
		System.out.println(tempDiretory.getAbsolutePath());
		//可用空间
		System.out.println("Free Space of Temporary Directory is "+tempDiretory.getFreeSpace());
	}

}
