package com.selenium.basic;

import java.io.File;
import java.io.FileFilter;

public class FileContains {


	public static void main(String[] args) {

		File path = new File(System.getProperty("user.dir") + "\\src\\main\\resources");
		File[] listFiles = path.listFiles(new FileFilter() {

		    public boolean accept(File file) {

		        String name = file.getName().toLowerCase();
		        return name.startsWith("202310");
		    }

		});

		if (listFiles.length == 0) {

		    // File does not exit

		} else {

		    // File exists
			System.out.println(listFiles.toString());

		}

	}

}
