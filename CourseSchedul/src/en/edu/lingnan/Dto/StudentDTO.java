package en.edu.lingnan.Dto;

public class StudentDTO {
	private String StudentID;
	private String StudentName;
	private String StudentSex;
	private String ClassID;
	private int StudentAge;
	private int SIflag;
	public String getStudentID() {
		return StudentID;
	}
	public void setStudentID(String studentID) {
		StudentID = studentID;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentSex() {
		return StudentSex;
	}
	public void setStudentSex(String studentSex) {
		StudentSex = studentSex;
	}
	public String getClassID() {
		return ClassID;
	}
	public void setClassID(String classID) {
		ClassID = classID;
	}
	public int getStudentAge() {
		return StudentAge;
	}
	public void setStudentAge(int studentAge) {
		StudentAge = studentAge;
	}
	public int getSIflag() {
		return SIflag;
	}
	public void setSIflag(int sIflag) {
		SIflag = sIflag;
	}
	

}
