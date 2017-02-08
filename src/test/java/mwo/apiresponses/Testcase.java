package mwo.apiresponses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Testcase {
	
	public static void main(String args[]) throws FileNotFoundException {
		String content = new Scanner(new File("C:\\Users\\srinivas.bavirisetti\\Desktop\\IFS\\PL_SQL_scripts\\create_wo.sql")).useDelimiter("\\Z").next();
		System.out.println(content);
	}

}
