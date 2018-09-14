package com.jdbc;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.StudentList(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") != null) {
			try {
				this.addStudent(request,response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			this.updateStudent(request,response);
		}
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Student student = null;
		StudentDbUtil studentDb = null;
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		student = new Student(id,firstName, lastName, email);
		studentDb.updateStudent(student);
		this.StudentList(request, response);
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException {
		Student student = null;
		StudentDbUtil studentDb = new StudentDbUtil();
		
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		student = new Student(firstName, lastName, email);
		PrintWriter out = response.getWriter();
		int row = studentDb.addStudent(student,out);
		this.doGet(request, response);
	}

	public void StudentList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		try {
			StudentDbUtil studentDb = new StudentDbUtil();
			ArrayList<Student> list = studentDb.getStudentList();
			request.setAttribute("student_data", list);
			RequestDispatcher rd = request.getRequestDispatcher("student-list.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			out.println(e);
		}
	}

}
