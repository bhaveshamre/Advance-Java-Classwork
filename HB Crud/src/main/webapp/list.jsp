<%@page import="java.util.Iterator"%>
<%@page import="com.example.employeecrud.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.example.employeecrud.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <style>
        a { text-decoration: none; }
        table { border-collapse: collapse; }
        th, td { border: 1px solid black; padding: 10px; }
        .form-input { margin-bottom: 10px; }
    </style>
</head>
<body>
<%    Employee employee = (Employee) request.getAttribute("employee");

 if(request.getAttribute("msg")!=null){ %>
    <h2><%=request.getAttribute("msg") %></h2>
<% } %>

<h2>Registration form</h2>
<% 
if (employee==null || employee.getId()==null){
		
	%>

<form action="controller" method="post">
    <div class="form-input">
        <input type="text" placeholder="Enter ID" name="id" required>
    </div>
    <div class="form-input">
        <input type="text" placeholder="Enter Name" name="name" required>
    </div>
    <div class="form-input">
        <input type="text" placeholder="Enter Salary" name="salary" required>
    </div>
    <div class="form-input">
        <input type="text" placeholder="Enter Phone Number" name="phone" required pattern="\d+">
    </div>
    <input type="submit" value="Submit">
</form>
<% } else{%>
<form action="<%= request.getContextPath() %>/UpdateController" method="post">
<div class="form-input">
        <input type="text"  name="id" value="<%= employee.getId() %>" readonly>
    </div>
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
 </form>
<% } %>
<br>
 <!-- <a href="controller" style="text-decoration: none; background-color: #4CAF50; color: white; padding: 10px; border-radius: 5px;">Show List</a>
  -->
<% if(request.getAttribute("list")!=null){ %>
    <br>
    <h2>Employee List</h2>
    <br>
    <table>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>SALARY</th>
            <th>PHONE</th>
            <th>ACTION1</th>
            <th>ACTION2</th>
        </tr>
        <% List<Employee> list = (List<Employee>) request.getAttribute("list");
           for(Employee std : list) { %>
               <tr>
                   <td><%= std.getId() %></td>
                   <td><%= std.getName() %></td>
                   <td><%= std.getSalary() %></td>
                   <td><%= std.getPhone() %></td>
                   <td><a href="<%= request.getContextPath() %>/DeleteController?id=<%= std.getId() %>">Delete</a></td>

                   <td><a href="UpdateController?id=<%= std.getId() %>">Update</a></td>
               </tr>
        <% } %>
    </table>
<% } %>

</body>
</html>
