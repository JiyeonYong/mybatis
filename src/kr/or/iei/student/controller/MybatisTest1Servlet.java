package kr.or.iei.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.student.model.service.StudentService;
import kr.or.iei.student.model.vo.Student;

/**
 * Servlet implementation class MybatisTest1Servlet
 */
@WebServlet(name = "MybatisTest1", urlPatterns = { "/mybatisTest1.do" })
public class MybatisTest1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTest1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		Student st = new Student();
		
		st.setStudentName(request.getParameter("studentName"));
		st.setStudentTel(request.getParameter("studentTel"));
		st.setStudentEmail(request.getParameter("studentEmail"));
		st.setStudentAddr(request.getParameter("studentAddr"));
		
		int result = new StudentService().insertStudent(st);
		
		
		if(result>0)
		{
			response.sendRedirect("/views/student/insertSuccess.jsp");
		}else
		{
			response.sendRedirect("/views/student/insertFail.jsp");
		}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}