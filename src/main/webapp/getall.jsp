<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table border="3px" style="background-color: red; margin-left: 100px">
	<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>SAL</th>
	<th>PHONE</th>
	

	</tr>
	<c:forEach var="list" items="${list}">
	<tr>
	<td>${list.getId()}</td>
	<td>${list.getName()}</td>
	<td>${list.getSal()}</td>
	<td>${list.getPhone()}</td>
	<td><a href="getbyid?id=${list.getId()}"> EDIT</a></td>
	<td> <a href="deleteemployee?id=${list.getId()}">DELETE</a></td>
	
	
	</tr>
	</c:forEach>

	</table>
	
	
	
	
	
	
	
	
</body>
</html>