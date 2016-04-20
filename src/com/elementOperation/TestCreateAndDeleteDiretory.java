package com.elementOperation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

public class TestCreateAndDeleteDiretory {

	public static void main(String[] args) throws IOException {
		
		FileHandler.createDir(new File("d:/c"));
		System.out.println("目录已创建");
		FileHandler.delete(new File("d:/c"));
		System.out.println("目录已删除");
	}

}
