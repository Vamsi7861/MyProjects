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

<form action="edit" method="post">

 id:<input type="number" name="id" value="<%=u.getId() %>"  readonly="true"><br>
phone:<input type="tel" name="ph" value="<%=u.getPhone()%>"><br>

password:<input type="password" name="ps" value="<%=u.getPassword()%>"><br>

Name:<input type="text" name="nm" value="<%=u.getName()%>"><br>

<input type="submit" value="update">
</form>
<%}else{ 
	response.sendRedirect("login.jsp");
}

%>

</div>
</body>
</html>