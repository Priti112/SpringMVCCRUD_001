<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Entry Page</title>
</head>
<body>
<h2>
   <a href="new">Add New Employee</a>
   &nbsp;&nbsp;&nbsp;
   <a href="list">List All Employee</a>
</h2>
<form:form action="/SpringMVCCRUD_001/save" method="post">
  <form:hidden path="id"/>
<table border="1">
<tr>
   <th>Name:</th>
   <td><form:input path="name"/></td>
</tr>   
<tr>
   <th>Salary:</th>
   <td><form:input path="salary"/></td>
</tr>
<tr>
   <th>Designation:</th>
   <td><form:input path="designation"/></td>
</tr>   
<tr>
   <td></td>
   <td><input type="submit" name="submit" value="submit"/></td>
</tr>   
</table>
</form:form>
</body>
</html>