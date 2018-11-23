package kr.or.iei.student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.student.model.service.StudentService;
import kr.or.iei.student.model.vo.Student;

/**
 * Servlet implementation class MybatisTest2Servlet
 */
@WebServlet(name = "MybatisTest2", urlPatterns = { "/mybatisTest2.do" })
public class MybatisTest2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTest2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		
		Student st = new StudentService().selectStudent(studentNo);
		
		if(st !=null)
		{
			RequestDispatcher view = request.getRequestDispatcher("views/student/selectOneSuccess.jsp");
			request.setAttribute("student", st);
			view.forward(request, response);
		}
		else
		{
			response.sendRedirect("/views/student/selectOneFail.jsp");
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







