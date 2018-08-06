package library;

public class Students {

	private int StudentId;
	private String StudentName;
	private String Department;
	private double TotalGrade;
	private int ScholarshipGranted;
	
	public Students(int StudentId, String StudentName, String Department, double TotalGrade, int ScholarshipGranted) {
		this.StudentId = StudentId;
		this.StudentName = StudentName;
		this.Department = Department;
		this.TotalGrade = TotalGrade;
		this.ScholarshipGranted = ScholarshipGranted;
	}
	
	public int getStudentId() {
		return this.StudentId;
	}
	public String getStudentName() {
		return this.StudentName;
	}
	public String getDepartment() {
		return this.Department;
	}
	public double getTotalGrade() {
		return this.TotalGrade;
	}
	public int getScholarshipGranted() {
		return this.ScholarshipGranted;
	}
}
