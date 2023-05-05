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
<%User u=(User)session.getAttribute("user");
if(u!=null){
%>
<h1>wellcome..<%=u.getName()%></h1>
<h2><a href="logout" >logout</a></h2>
<h2><a href="delete?id=<%=u.getId()%>">delete</a></h2>
<h2><a href="edit.jsp">edit</a></h2>
<h2><a href="display.jsp">view details</a></h2>
<%
}else{
	response.sendRedirect("login.jsp");
}
%>
</body>
</html>