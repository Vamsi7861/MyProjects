<%@page import="org.jsp.demo.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%User u=(User)session.getAttribute("user");
if(u!=null){
%>
<h1>Welcome..<%=u.getName()%> your account create successfully</h1> 
<h2><a href="display.jsp">click here for details</a></h2>
<%}else
	response.sendRedirect("register.jsp");
	%>
</div>
</body>
</html>