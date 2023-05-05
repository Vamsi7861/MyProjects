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
<div align="center" >
<%
User u=(User)session.getAttribute("user");
if(u!=null){
%>



 name:<h1><%=u.getName()%></h1>    
    phone:<h2><%=u.getPhone()%></h1><br>

password:<h3><%=u.getPassword()%></h3><br>

id:<h4><%=u.getId() %></h4><br>


<%}else{ 
	response.sendRedirect("login.jsp");
}

%>

</div>
</body>
</html>