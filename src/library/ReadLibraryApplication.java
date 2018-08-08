package library;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;


public class ReadLibraryApplication {
	public static void main(String args[]) {
		StringBuffer books = readFile("/Users/annie/Desktop/java/Books.txt");
		StringBuffer students = readFile("/Users/annie/Desktop/java/Students.txt");
		
		String bookLine[] = books.toString().split("\n");
		String bookID[] = readData(bookLine, 0);
		String bookName[] = readData(bookLine, 1);
		String borrowed[] = readData(bookLine, 6);
		System.out.println(Arrays.toString(borrowed));
		
		// List names of books that are being borrowed
		System.out.print("Books borrowed: ");
		for (int i = 0; i < borrowed.length; i ++) {
			if (borrowed[i].equalsIgnoreCase("yes")) {
				System.out.print(bookName[i] + ", ");
			} 
		}
		
		
		// List names of books that are not being borrowed.
		
				

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
	
	public static String[] readData(String[] line, int index) {
		String[] data =  new String[line.length - 1];
		for (int i = 1; i < line.length; i ++) {
//			System.out.println(line[i]);
			data[i - 1] = line[i].split(", ")[index];
//			System.out.println(data[i - 1]);
		}
		return data;
	}
}
