package kr.or.iei.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.student.model.service.StudentService;

/**
 * Servlet implementation class MybatisTest5Servlet
 */
@WebServlet(name = "MybatisTest5", urlPatterns = { "/mybatisTest5.do" })
public class MybatisTest5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTest5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String studentName = request.getParameter("studentName");
		
		int result = new StudentService().deleteStudent(studentNo,studentName);
		
		if(result>0)
		{
			response.sendRedirect("/views/student/deleteStudentSuccess.jsp");
		}
		else
		{
			response.sendRedirect("/views/student/deleteStudentFail.jsp");
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








