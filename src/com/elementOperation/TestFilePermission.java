package com.elementOperation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

/**
 * 
 * @author zhongts
 * 4.6.8 功能：文件权限操作
 * 步骤：
 * 	1）判断文件本身是否是可执行文件
 * 	2）修改文件的权限，使得变成可执行文件
 * 	3）修改权限为可写文件
 *  
 * 
 * 备注：
 * 	适用场景为需要调整文件的权限。
 * 
 */

public class TestFilePermission {

	public static void main(String[] args) {
		// 判断文件是否可执行
		if (!FileHandler.canExecute(new File("/directory/file1.sh"))) {
			try {
				// 修改文件权限为可执行
				FileHandler.makeExecutable(new File("/diretory/file1.sh"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			// 修改文件权限为可写
			FileHandler.makeWritable(new File("/diretory/file2.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
