package en.edu.lingnan.Dto;

public class teacherCourseDTO {

	private String TeacherCourseID;
	private String TeacherID;
	private String CourseID;
	private String ClassID;
	private String WeekDay ;
	private String ClassTime;
	private String ClassroomID;
	private int TCflag;
	
	public String getTeacherCourseID() {
		return TeacherCourseID;
	}
	public void setTeacherCourseID(String TeacherCourseID) {
		this.TeacherCourseID = TeacherCourseID;
	}
	
	public String getTeacherID() {
		return TeacherID;
	}
	public void setTeacherID(String TeacherID) {
		this.TeacherID = TeacherID;
	}
	
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String CourseID) {
		this.CourseID = CourseID;
	}
	
	public String getClassID() {
		return ClassID;
	}
	public void setClassID(String ClassID) {
		this.ClassID = ClassID;
	}
	
	public String getWeekDay() {
		return WeekDay;
	}
	public void setWeekDay(String WeekDay) {
		this.WeekDay = WeekDay;
	}
	
	public String getClassroomID() {
		return ClassroomID;
	}
	public void setClassroomID(String ClassroomID) {
		this.ClassroomID = ClassroomID;
	}
	
	public String getClassTime() {
		return ClassTime;
	}
	public void setClassTime(String ClassTime) {
		this.ClassTime = ClassTime;
	}
	
	public int getTCflag() {
		return TCflag;
	}
	public void setTCflag(int TCflag) {
		this.TCflag = TCflag;
	}
	
}
