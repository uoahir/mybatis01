package com.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.dto.Student;
import com.mybatis.model.service.StudentService;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/updatestudent.do")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s = 
				Student.builder()
				.studentNo(Integer.parseInt(request.getParameter("no")))
				.studentTel(request.getParameter("phone"))
				.studentAddress(request.getParameter("address"))
				.studentEmail(request.getParameter("email")).build();
		
		int result = new StudentService().updateStudent(s);
		
		response.getWriter().write(result>0?"success":"fail");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
