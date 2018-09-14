<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="col-sm-6">
		<h2>Add Student</h2>
		<form action="StudentController" method="post">
				<input type="hidden" name="id" id="id" />
				<div class="form-group">
					<label for="fname">First Name:</label> <input type="text"
						class="form-control" id="fname" placeholder="Enter First Name"
						name="fname">
				</div>
				<div class="form-group">
					<label for="lname">Last Name:</label> <input type="text"
						class="form-control" id="lname" placeholder="Enter Last Name"
						name="lname">
				</div>
				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" id="email" placeholder="Enter email"
						name="email">
				</div>
				<a class="btn btn-default pull-left" href="StudentController" >Back</a>
				<input type="submit" class="btn btn-success pull-right" value="Submit">
		</form>
	</div>
	</div>

</body>
</html>
