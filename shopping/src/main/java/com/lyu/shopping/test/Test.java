package com.lyu.shopping.test;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("D:/lala/xcxc");
		
		if (!file.exists()) {
			file.mkdirs();
		}
		File f = new File(file, "a.txt");
		f.createNewFile();
		
	}

}
