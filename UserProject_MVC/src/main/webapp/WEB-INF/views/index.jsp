<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<div align="center" >
<c:if test="${message!=null }">
<h2>${message}</h2>
</c:if>
<form action="log" method="post">
phone:<input type="tel" name="phone"  placeholder="enter phonenumber"><br>
password:<input type="password" name="password" placeholder="enter password"><br>
<input type="submit" value="LOGIN">
</form>
<h3><a href="load?choice=1">click here to  register</a></h3>
</div>
</body>
</html>