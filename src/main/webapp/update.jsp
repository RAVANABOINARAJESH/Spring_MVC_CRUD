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
	<form:form action="updateemployee" modelAttribute="list">
	<h1>UPDATE THE VALUES</h1>
   ID :<form:input path="id"/> <br>
   NAME:<form:input path="name"/> <br>
   SAL:<form:input path="sal"/> <br>
   PHONE :<form:input path="phone"/> <br>
   <form:button>SUBMIT</form:button>


</form:form>
</body>
</html>