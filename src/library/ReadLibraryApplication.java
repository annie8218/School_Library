package library;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class ReadLibraryApplication {
	public static void main(String args[]) {
		StringBuffer books = readFile("/Users/annie/Desktop/java/Books.txt");
		StringBuffer students = readFile("/Users/annie/Desktop/java/Students.txt");
		System.out.println(books);
		System.out.println(students);
		
		
	}
	
	public static StringBuffer readFile(String FilePath) {
		StringBuffer stringBuffer = new StringBuffer();
		try {
			File file = new File(FilePath);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuffer;
	}
	
}
