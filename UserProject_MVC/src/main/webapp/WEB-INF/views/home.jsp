<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<c:if test="${us!=null }">
		<h2>
			<a href="load?choice=2">edit</a>
		</h2>
		<h2>
			<a href="display.jsp">view details</a>
		</h2>
		<h2>
			<a href="delete?id=${us.getId() }">delete</a>
		</h2>
		<h2>
			<a href="logout">logout</a>
		</h2>
	</c:if>
</div>
</body>
</html>