package com.Model;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private Integer id;
	private String name;
	// 课程可以被多个学生选择:
	private Set<Student> students = new HashSet<Student>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	
	

}
