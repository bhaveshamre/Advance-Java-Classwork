<%@page import="java.util.Iterator"%>
<%@page import="com.student.model.StudentModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
a {
  text-decoration: none;
}
</style>
</head>

<body>
<h1>Welcome Home</h1>
<%
	if(request.getAttribute("msg")!=null){
		%>
		<h3> <%=request.getAttribute("msg") %></h3>
		<%
	}
%>

<form action="StudentSave" method="post">
<input type="text" placeholder="Enter ID" name="id" >
<br><br>
<input type="text" placeholder="Enter Name" name="name" >
<br><br>
<input type="text" placeholder="Enter Marks" name="marks" >
<br><br>
<input type="text" placeholder="Enter Phone Number" name="phone" >
<br><br>
<input type="text" placeholder="Enter Phone Number" name="phone" >
<br><br>
<input class="form-check-input" type="radio" name="gender" id="gender" value="male">
<label class="form-check-label" for="gender">Male</label>
<input class="form-check-input" type="radio" name="gender" id="gender-f" value="female">
<label class="form-check-label" for="female">Female</label>
<br><br>
<label for="city">Select a city:</label>
                <select class="form-select" aria-label="City select menu" name="city" id="city">
                    <option selected>Open this select menu</option>
                    <option value="Mumbai">Mumbai</option>
                    <option value="Pune">Pune</option>
                    <option value="Nagpur">Nagpur</option>
                </select>
<br><br>

<input type="submit" placeholder="Submit" >
<br><br>

</form>     

<br>
<button><a href="StudentSave" text-decoration: "none">Show List</a></button>

<%
	if(request.getAttribute("list")!=null){
		
		%>
		<h2>Student List</h2>
		<br>
		<table border="1" cellspacing="0" cellpadding="10">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>MARKS</th>
			<th>PHONE</th>
			<th>GENDER</th>
			<th>CITY</th>
			<th>ACTION1</th>
			<th>ACTION2</th>
		</tr>
		<%
				List<StudentModel> stdlist = (List<StudentModel>)request.getAttribute("list");
				Iterator itr = stdlist.iterator();
				while(itr.hasNext()){
					StudentModel std = (StudentModel) itr.next();
					%>
					
					<tr>
						<td><%=std.getId() %></td>
						<td><%=std.getName() %></td>
						<td><%=std.getMarks() %></td>   
						<td><%=std.getPhone() %></td>
						<td><%=std.getGender() %></td>
						<td><%=std.getCity() %></td>
						<td><a href="DeleteStudent?id=<%=std.getId()%>">Delete</a></td>
						<td><a href="UpdateStudent?id=<%=std.getId()%>">Update</a></td>
					</tr>
					<%
				}
		%>
		
		</table>
		<%
	}

%>

</body>
</html>