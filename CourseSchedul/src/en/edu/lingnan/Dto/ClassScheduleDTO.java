package en.edu.lingnan.Dto;

public class ClassScheduleDTO {
	private String ClassScheduleID;
	private String ClassID;
	private String CourseID;
	private String Weekday;
	private String ClassTime;
	private String TeacherId;
	private String ClassroomID;
	private int CSflag;
	public String getClassScheduleID() {
		return ClassScheduleID;
	}
	public void setClassScheduleID(String classScheduleID) {
		ClassScheduleID = classScheduleID;
	}
	public String getClassID() {
		return ClassID;
	}
	public void setClassID(String classID) {
		ClassID = classID;
	}
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	public String getWeekday() {
		return Weekday;
	}
	public void setWeekday(String weekday) {
		Weekday = weekday;
	}
	public String getClassTime() {
		return ClassTime;
	}
	public void setClassTime(String classTime) {
		ClassTime = classTime;
	}
	public String getTeacherId() {
		return TeacherId;
	}
	public void setTeacherId(String teacherId) {
		TeacherId = teacherId;
	}
	public String getClassroomID() {
		return ClassroomID;
	}
	public void setClassroomID(String classroomID) {
		ClassroomID = classroomID;
	}
	public int getCSflag() {
		return CSflag;
	}
	public void setCSflag(int cSflag) {
		CSflag = cSflag;
	}

}
