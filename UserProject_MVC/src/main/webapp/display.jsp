<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<c:if test="${us!=null }">

<h4>id:${us.getId()}</h4><br>
 <h1>name:${us.getName()}</h1>  <br>  
    <h2>phone:${us.getPhone()}</h2><br>
<h3>password:${us.getPassword()}</h3><br>
</c:if>
</div>

</body>
</html>