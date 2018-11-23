package kr.or.iei.student.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import kr.or.iei.student.model.vo.Student;

public interface IStudentDao {
	public Student selectStudent(SqlSession session, int studentNo);
	public int insertStudent(SqlSession session, Student st);
	public ArrayList<Student> selectAll(SqlSession session);
	public int updateStudent(SqlSession session,Student st);
	public int deleteStudent(SqlSession session, int studentNo, String studentName);
}
