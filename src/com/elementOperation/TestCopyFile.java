package com.elementOperation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

public class TestCopyFile {

	public static void main(String[] args) {

		try{
			//将源目录下的所有文件复制到目的目录
			FileHandler.copy(new File("d:/a"), new File("d:/b"));
			//将指定的文件从源目录复制到目的目录
			FileHandler.copy(new File("d:/a/a.txt"), new File("d:/b/a.txt"));
			//将以suffix.txt为扩展名的所有文件从源目录复制到目的目录
			FileHandler.copy(new File("d:/a/"), new File("d:/b/"),".txt");			
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
