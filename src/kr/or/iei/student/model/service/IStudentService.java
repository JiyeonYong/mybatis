package kr.or.iei.student.model.service;

import java.util.ArrayList;

import kr.or.iei.student.model.vo.Student;

public interface IStudentService {
	public Student selectStudent(int studentNo); //1명이 정보를 리턴하는 메소드
	public int insertStudent(Student st); //1명의 정보를 추가(삽입)하는 메소드
	public ArrayList<Student> selectAll();
	public int updateStudent(Student st); //1명의 정보를 수정하는 메소드
	public int deleteStudent(int studentNo, String studentName);
	
}
