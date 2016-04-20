package com.elementOperation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.io.Zip;

public class TestZip {
	
	public static void main(String[] args) throws IOException {
		Zip zip=new Zip();
		zip.zip(new File("d:/a/a.txt"), new File("d:/a/a.zip"));
		
		System.out.println(FileHandler.isZipped("d:/a/a.zip"));
		
		zip.unzip(new File("d:/a/a.zip"), new File("d:/b/a.txt"));
		
	}
}
