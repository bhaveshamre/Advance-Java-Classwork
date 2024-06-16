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
</head>
<body>
<h2>Student List</h2>
<%
	if(request.getAttribute("list")!=null){
		
		%>
		<table border="1" cellspacing="0" cellpadding="10">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>MARKS</th>
			<th>PHONE</th>
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