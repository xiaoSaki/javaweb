package en.edu.lingnan.Dto;

public class MajorScheduleDTO {
	String CourseID=null;
	String MajorID=null;
	String CourseName=null;
	String CourseTime=null;
	String YearTime=null;
	String TermTime=null;
	String ClassroomType=null;
	int  EveryWeekCourseTime;
	int MSflag;
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	public String getMajorID() {
		return MajorID;
	}
	public void setMajorID(String majorID) {
		MajorID = majorID;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getCourseTime() {
		return CourseTime;
	}
	public void setCourseTime(String courseTime) {
		CourseTime = courseTime;
	}
	public String getYearTime() {
		return YearTime;
	}
	public void setYearTime(String yearTime) {
		YearTime = yearTime;
	}
	public String getTermTime() {
		return TermTime;
	}
	public void setTermTime(String termTime) {
		TermTime = termTime;
	}
	public int getEveryWeekCourseTime() {
		return MSflag;
	}
	public void setEveryWeekCourseTime(int mveryWeekCourseTime) {
		MSflag = mveryWeekCourseTime;
	}
	public String getClassroomType() {
		return ClassroomType;
	}
	public void setClassroomType(String classroomType) {
		ClassroomType = classroomType;
	}
	
	public int getMSflag() {
		return MSflag;
	}
	public void setMSflag(int mSflag) {
		MSflag = mSflag;
	}

}
