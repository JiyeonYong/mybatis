package kr.or.iei.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.student.model.service.StudentService;
import kr.or.iei.student.model.vo.Student;

/**
 * Servlet implementation class MybatisTest3Servlet
 */
@WebServlet(name = "MybatisTest3", urlPatterns = { "/mybatisTest3.do" })
public class MybatisTest3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTest3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		ArrayList<Student> list = new StudentService().selectAll();
		
		if(!list.isEmpty())
		{
			RequestDispatcher view = request.getRequestDispatcher("views/student/selectAllSuccess.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		}
		else
		{
			response.sendRedirect("/views/student/selectAllFail.jsp");
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








