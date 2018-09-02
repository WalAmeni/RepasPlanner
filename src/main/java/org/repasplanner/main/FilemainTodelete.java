package org.repasplanner.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilemainTodelete {

	public FilemainTodelete() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Get the file reference
		Path path = Paths.get("D:\\JAVA\\listeDeCourse.txt");
		 
		//Use try-with-resource to get auto-closeable writer instance
		try (BufferedWriter writer = Files.newBufferedWriter(path))
		{
		    writer.write("Hello World !!");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
