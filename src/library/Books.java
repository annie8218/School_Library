package library;

public class Books {
	
	private int BookId;
	private String BookName;
	private String Year;
	private String Author;
	private double Cost;
	private String Type;
	private String Borrowed;
	private int WhoBorrowing;
	
	public Books(int BookId, String BookName, String Year, String Author, double Cost,String Type) {
		this.BookId = BookId;
		this.BookName = BookName;
		this.Year = Year;
		this.Author = Author;
		this.Cost = Cost;
		this.Type = Type;
	}
	
	public int getBookId() {
		return this.BookId;
	}
	
	public String getBookName() {
		return this.BookName;
	}
	public String getYear() {
		return this.Year;
	}
	public String getAuthor() {
		return this.Author;
	}
	public double getCost() {
		return this.Cost;
	}
	public String getType() {
		return this.Type;
	}
	
	public String getBorrowed(boolean check) {
		if (check == true) 
			this.Borrowed =  "Yes";
		else
			this.Borrowed = "No";
		return Borrowed;
	}
	
	public int getWhoBorrowed(boolean check, int BookId) {
		if (check == true)
			this.WhoBorrowing = BookId;
		else
			this.WhoBorrowing = 0;
		return WhoBorrowing;
	}
}