package kr.or.iei.student.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.iei.student.model.vo.Student;

public class StudentDao implements IStudentDao{

	@Override
	public Student selectStudent(SqlSession session, int studentNo) {
		
		Student st = session.selectOne("student.selectStudent", studentNo);
		return st;
	}

	@Override
	public int insertStudent(SqlSession session, Student st) {
		int result = session.insert("student.studentOne",st);
		//session.insert는 mapper 파일에서 해당 insert 태그의 
		// namespace.id 값을 찾아 해당 sql구문을 가져와서 처리함
		
		return result;
		
	}

	@Override
	public ArrayList<Student> selectAll(SqlSession session) {
	
		List<Student>  list = session.selectList("student.selectAllStudent");

		return (ArrayList<Student>)list;
	}

	@Override
	public int updateStudent(SqlSession session, Student st) {
		int result = session.update("student.updateStudent", st);
		return result;
	}

	@Override
	public int deleteStudent(SqlSession session, int studentNo, String studentName) {
		HashMap<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("studentNo", studentNo);
		parameters.put("studentName",studentName);
		
		int result = session.delete("student.deleteStudent",parameters);

		
		return result;
	}

}

















