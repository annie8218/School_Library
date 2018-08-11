package library;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;
import java.io.BufferedReader;


public class LibraryApplication {
	public static void main(String args[]) {
		
		ReadLibrary readLib = new ReadLibrary();
		
		StringBuffer books = readFile("/Users/annie/Desktop/java/Books.txt");
		System.out.println(books);
		String[] bookLine = books.toString().split("\n");
		String[] bookID = readData(bookLine, 0);
		String[] bookName = readData(bookLine, 1);
		int[] year = convertStringArrToIntArr(readData(bookLine, 2));
		String[] author = readData(bookLine, 3);
		int[] cost = convertStringArrToIntArr(readData(bookLine, 4));
		System.out.println(Arrays.toString(cost));
		String[] type = readData(bookLine, 5);
		String[] borrowed = readData(bookLine, 6);
		int[] whoBorrowing = convertStringArrToIntArr(readData(bookLine, 7));
		
		StringBuffer students = readFile("/Users/annie/Desktop/java/Students.txt");
		System.out.println(students);
		String[] studentLine = students.toString().split("\n");
		int[] studentId = convertStringArrToIntArr(readData(studentLine, 0));
		String[] studentName = readData(studentLine, 1);
		String[] department = readData(studentLine, 2);
		double[] grade = convertStringArrToDoubleArr(readData(studentLine, 3));
		int[] scholarship = convertStringArrToIntArr(readData(studentLine, 4));
		
		// List names of books that are being borrowed
		System.out.print("1. Books borrowed: ");
		ArrayList<String> bookBorrowed = readLib.getBookBorrowedOrNot(bookName, borrowed, "yes");
		System.out.println(bookBorrowed);
		
		// List names of books that are not being borrowed.
		System.out.print("2. Books not borrowed: ");
		ArrayList<String> bookNotBorrowed = readLib.getBookBorrowedOrNot(bookName, borrowed, "no");
		System.out.println(bookNotBorrowed);
				
		// List name of the most expensive book
		System.out.print("3. Most expensive book(s): ");
		ArrayList<String> bookExp = readLib.getBookMax(bookName, cost);
		System.out.println(bookExp);
		
		// List name of the newest book (most recent ones)
		System.out.print("4. Most recent book(s): ");
		ArrayList<String> bookNew = readLib.getBookMax(bookName, year);
		System.out.println(bookNew);
		
		// List names of books with type Computer Science
		System.out.print("5. CS book(s): ");
		ArrayList<String> bookCS = readLib.getBookType(bookName, type, "computer science");
		System.out.println(bookCS);
		
		// Group books based on their types. For each type, list all book names
		System.out.println("6. Group books based on types: ");
		Map<String, ArrayList<String>> map = readLib.getBookGroup(bookName, type);
		for (Entry<String, ArrayList<String>>entry : map.entrySet()) {
		    String key = entry.getKey().toString();
		    List<String> value = entry.getValue();
		    System.out.print("\t" + key + " books:\n ");
		    for (String str: value) {
		    		System.out.println("\t\t" + str);
		    }
		}
		
		// Find how many students in Computer Engineering department
		System.out.print("7. Number of studens in Computer Engineer: ");
		Map<String, Integer> map1 = readLib.getStudentInADepartment(department);
		for (String dep : map1.keySet()) {
			if (dep.equalsIgnoreCase("computer engineering")) {
				String key = dep.toString();
				Integer value = map1.get(dep);
				System.out.println(value);
			}
		}
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
			data[i - 1] = line[i].split(", ")[index];
 		}
		return data;
	}
	
	public static int[] convertStringArrToIntArr(String[] numString) {
		int[] number = new int[numString.length];
		for (int i = 0; i < numString.length; i ++) {
			number[i] = Integer.parseInt(numString[i]);
		}
		return number;
	}
	
	public static double[] convertStringArrToDoubleArr(String[] numString) {
		double[] number = new double[numString.length];
		for (int i = 0; i < numString.length; i ++) {
			number[i] = Double.parseDouble(numString[i]);
		}
		return number;
	}
}
