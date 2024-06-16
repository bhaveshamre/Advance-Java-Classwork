<%@page import="com.student.model.StudentModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Update Form</title>
</head>
<body>
	<h1>Welcome Home</h1>
	<%
	if (request.getAttribute("obj") != null) {
		StudentModel std = (StudentModel) request.getAttribute("obj");
	%>
	<form action="UpdateStudent" method="post">
		<input type="text" placeholder="Enter ID" name="id" value="<%= std.getId() %>" readonly="readonly"> <br><br>
		<input type="text" placeholder="Enter Name" name="name" value="<%= std.getName() %>"> <br><br>
		<input type="text" placeholder="Enter Marks" name="marks" value="<%= std.getMarks() %>"> <br><br>
		<input type="text" placeholder="Enter Phone Number" name="phone" value="<%= std.getPhone() %>"> <br><br>

		<label>Gender:</label><br>
		<input class="form-check-input" type="radio" name="gender" value="male" <%= "male".equals(std.getGender()) ? "checked" : "" %>>
		<label class="form-check-label" for="gender">Male</label><br>
		<input class="form-check-input" type="radio" name="gender" value="female" <%= "female".equals(std.getGender()) ? "checked" : "" %>>
		<label class="form-check-label" for="gender-f">Female</label><br><br>

		<label for="city">Select a city:</label>
		<select class="form-select" aria-label="City select menu" name="city" id="city">
			<option value="Mumbai" <%= "Mumbai".equals(std.getCity()) ? "selected" : "" %>>Mumbai</option>
			<option value="Pune" <%= "Pune".equals(std.getCity()) ? "selected" : "" %>>Pune</option>
			<option value="Nagpur" <%= "Nagpur".equals(std.getCity()) ? "selected" : "" %>>Nagpur</option>
		</select><br><br>

		<input type="submit" value="Submit">
	</form>
	<%
	} else {
	%>
	<p>No student data available.</p>
	<%
	}
	%>
	<a href="StudentSave">Show List of Students</a>
</body>
</html>
