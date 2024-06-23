<%@page import="com.example.employeecrud.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
<% 
    Employee employee = (Employee) request.getAttribute("employee");
    if (employee == null) {
        out.println("<h2>No employee details found.</h2>");
        return;
    }
%>
<h2>Update Employee Details</h2>
<form action="<%= request.getContextPath() %>/UpdateController" method="post">
    <input type="hidden" name="id" value="<%= employee.getId() %>" />
    <div class="form-input">
        <label for="name">Name:</label>
        <input type="text" name="name" value="<%= employee.getName() %>" required />
    </div>
    <div class="form-input">
        <label for="salary">Salary:</label>
        <input type="text" name="salary" value="<%= employee.getSalary() %>" required />
    </div>
    <div class="form-input">
        <label for="phone">Phone:</label>
        <input type="text" name="phone" value="<%= employee.getPhone() %>" required pattern="\d+" />
    </div>
    <input type="submit" value="Update">
    <br>
    <a href="controller">Show List of Students</a>
</form>
</body>
</html>
