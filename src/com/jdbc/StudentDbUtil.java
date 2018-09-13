package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

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
}
