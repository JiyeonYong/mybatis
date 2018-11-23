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
 * Servlet implementation class MybatisTest4Servlet
 */
@WebServlet(name = "MybatisTest4", urlPatterns = { "/mybatisTest4.do" })
public class MybatisTest4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTest4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		Student st = new Student();
		st.setStudentNo(Integer.parseInt(request.getParameter("studentNo")));
		st.setStudentName(request.getParameter("studentName"));
		st.setStudentTel(request.getParameter("studentTel"));
		st.setStudentEmail(request.getParameter("studentEmail"));
		st.setStudentAddr(request.getParameter("studentAddr"));
		
		
		System.out.println(st.getStudentTel());
		System.out.println(st.getStudentEmail());
		System.out.println(st.getStudentAddr());
		
		
		int result = new StudentService().updateStudent(st);
		
		if(result>0)
		{
			response.sendRedirect("/views/student/updateSuccess.jsp");
		}
		else
		{
			response.sendRedirect("/views/student/updateFail.jsp");
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





