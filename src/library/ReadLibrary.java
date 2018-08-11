package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ReadLibrary {
	
	// List names of books that are being borrowed or not being borrowed
	public ArrayList<String> getBookBorrowedOrNot(String[] bookName, String[] borrowed, String check) {
		ArrayList<String> bookBorrowed = new ArrayList<String>();
		for (int i = 0; i < borrowed.length; i ++) {
			if (borrowed[i].equalsIgnoreCase(check)) {
				bookBorrowed.add(bookName[i]);
			}
		}
		return bookBorrowed;
	}
		
	// List name of the most expensive or recent books
	public ArrayList<String> getBookMax(String[] bookName, int[] info) {
		ArrayList<String> bookExp = new ArrayList<String>();
		int max = 0;
		for (int i = 0; i < info.length; i ++) {
			if (info[i] > max) {
				max = info[i];
				bookExp.clear();
				bookExp.add(bookName[i]);
			} else if (info[i] == max) {
				bookExp.add(bookName[i]);
			}
		}
		return bookExp;
	}
	
	// List names of books with type Computer Science
	public ArrayList<String> getBookType(String[] bookName, String[] type, String typeInput) {
		ArrayList<String> bookType = new ArrayList<String>();
		for (int i = 0; i < type.length; i ++) {
			if (type[i].equalsIgnoreCase(typeInput)) {
				bookType.add(bookName[i]);
			}
		}
		return bookType;
	}

	//	Group books based on their types. For each type, list all book names
	public Map<String, ArrayList<String>> getBookGroup(String[] bookName, String[] type) {
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < type.length; i++) {
			if (!map.containsKey(type[i])) {
				ArrayList<String> list = new ArrayList <String>();
				list.add(bookName[i]);
				map.put(type[i], list);
			} else {
				ArrayList<String> list = map.get(type[i]);
				list.add(bookName[i]);
			}
		}
		return map;
	}

	// Find how many students in each department
	public Map<String, Integer> getStudentInADepartment(String[] department) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < department.length; i ++) {
			if (!map.containsKey(department[i])) {
				map.put(department[i], 1);
			} else {
				int stuNo = map.get(department[i]);
				map.put(department[i], ++ stuNo);
			}
		}
		return map;
	}
	
	// Find student who has highest TotalGrade and student who has lowest TotalGrade
	
	
	// List name of student who has highest scholarship amount
	
	
	// For each student who is borrowing books, list student name, number of books they are borrowing and their names (book).
	
	
	// List name of students who don't borrow books.

	
	// Print all student names in StudentId order (increasing)
	
	
	// Print all student names in TotalGrade order (decreasing)
		
}	
