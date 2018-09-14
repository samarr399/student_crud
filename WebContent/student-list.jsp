<%-- <%@ page import="java.util.*, com.jdbc.* " %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Student List</h2>
		
		<a href="add-student.jsp" class="btn btn-success pull-right">Add Student</a>
		<br><br>
		<table class="table table-bordered table-stripped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<%
					//     ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("student_data");
					//     for(Student student : students){ 
					//out.print(student);
				%>
				<!--       <tr class="success"> -->
				<%--       	<td><%= student.getId() %></td> --%>
				<%--         <td><%= student.getFirstName() %></td> --%>
				<%--         <td><%= student.getLastName() %></td> --%>
				<%--         <td><%= student.getEmail() %></td> --%>
				<!--       </tr> -->
				<%--       <% } %> --%>
				<c:forEach var="student" items="${student_data}">
					<tr class="success">
						<td>${student.id}</td>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
						<td>${student.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>

