package com.jdbc;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

public class StudentDbUtil {
	private Connection conn;

	public StudentDbUtil() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_crud", "msamar", "root");
	}

	public ArrayList<Student> getStudentList() {
		ArrayList<Student> students = new ArrayList<Student>();
		String sql = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			sql = "SELECT * FROM student ORDER BY first_name";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				Student student = new Student(id, first_name, last_name, email);
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return students;
	}

	private void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int addStudent(Student student, PrintWriter out) {
		PreparedStatement prdstmt = null;
		String sql = null;
		ResultSet rs = null;
		int i = 0;
		try {
			sql = "INSERT INTO student (first_name,last_name,email) values (?, ? ,?)";
			prdstmt = (PreparedStatement) conn.prepareStatement(sql);
			prdstmt.setString(1, student.getFirstName());
			prdstmt.setString(2, student.getLastName());
			prdstmt.setString(3, student.getEmail());
			i = prdstmt.executeUpdate(); 
		}catch(Exception e) {
			out.print(e);
		}
		return i;
	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	public Student setStudent(int id) {
		String sql = null;
		Statement stmt = null;
		ResultSet rs = null;
		Student student = null;
		try {
			sql = "SELECT * FROM student WHERE id = 2";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");
			String email = rs.getString("email");
			student = new Student(id, first_name, last_name, email);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
}
