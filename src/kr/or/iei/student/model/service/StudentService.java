package kr.or.iei.student.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.iei.student.model.dao.StudentDao;
import kr.or.iei.student.model.vo.Student;

public class StudentService implements IStudentService {

	

	@Override
	public int insertStudent(Student st) {
		SqlSession session = getSqlSession(); // Connection
		int result = new StudentDao().insertStudent(session,st);
		
		if(result>0)
		{
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
	// 기존에는 JDBC 코드 혹은 JDBCTemplate를 통하여 Connection 정보를 가져왔음
	// 이번에는 Mybatis를 통하여 Connection 정보를 가져오도록 하겠음
	// 기존 코드에서는 Connection 객체 였지만 Mybatis에서는 Session이라고 부름
	// (주의할점 : WebSession과는 전혀 다른 의미입니다.)
	// SqlSessionFactoryBuilder, SqlSessionFactory 객체를 통해
	// SqlSession객체를 제공할 메소드를 생성함
	// mybatis-config.xml을 읽어와서 
	// SqlSessionFactoryBuilder객체의 build 메소드의 인자로 전달함
	// 이후 해당 메소드는 SqlSession 객체를 리턴
	
	private SqlSession getSqlSession()
	{
		SqlSession session = null;
		String resource = "/mybatis-config.xml";
		
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(is);
			session = factory.openSession(false);
			//false값은 auto Commit에 대하여 꺼짐을 의미함
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}

	@Override
	public Student selectStudent(int studentNo) {
		SqlSession session = getSqlSession(); // Connection 가져오기
		
		Student st = new StudentDao().selectStudent(session,studentNo);
		session.close();
		return st;
	}

	@Override
	public ArrayList<Student> selectAll() {
		SqlSession session = getSqlSession(); //Connection 
		ArrayList<Student> list = new StudentDao().selectAll(session);
		session.close();
		return list;
	}

	@Override
	public int updateStudent(Student st) {
		SqlSession session = getSqlSession(); //Connection
		int result = new StudentDao().updateStudent(session, st);
		if(result>0)
		{
			session.commit();
		}else
		{
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	@Override
	public int deleteStudent(int studentNo, String studentName) {
		SqlSession session = getSqlSession();
		int result = new StudentDao().deleteStudent(session, studentNo, studentName);
		if(result>0)
		{
			session.commit();
		}
		else
		{
			session.rollback();
		}
		
		session.close();
		
		
		return result;
	}

}















