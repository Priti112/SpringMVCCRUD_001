<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List Page</title>
</head>
<body>
<h1>Employee List Page</h1>
<h2>
   <a href="new">Add New Employee</a>
   &nbsp;&nbsp;&nbsp;
   <a href="list">List All Employee</a>
</h2>
<table border="1">
<tr>
  <th>ID</th>
  <th>Name</th>
  <th>Salary</th>
  <th>Designation</th>
  <th colspan="2">Action</th>
  
<c:forEach var="e1" items="${list}">
<tr>
   <td>${e1.id}</td>
   <td>${e1.name}</td>
   <td>${e1.salary}</td>
   <td>${e1.designation}</td>
   <td>
   <a href="edit/${e1.id}">Edit</a>
   &nbsp;&nbsp;&nbsp;
   <a onclick="return confirm('Are you sure you want to delete')" href="delete/${e1.id}">Delete</a>
   </td>  
</tr>
</c:forEach>      
</table>
</body>
</html>