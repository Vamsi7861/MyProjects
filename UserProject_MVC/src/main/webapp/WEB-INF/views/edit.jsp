<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

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

<form:form modelAttribute="user" action="edit" method="post">

<form:label path="id" >id</form:label>
<form:input path="id" value="${us.getId()}"  readonly="true"/><br>
<form:label path="name" >Name</form:label>
<form:input path="name"  value="${us.getName()}"/><br>

<form:label path="phone">Phone</form:label>
<form:input path="phone"  value="${us.getPhone()}"/><br>
<form:label path="age" >Age</form:label>
<form:input path="age" value="${us.getAge()}"/><br>
<form:label path="password" >Password</form:label>
<form:input path="password" value="${us.getPassword()}"/><br>
<form:button>update</form:button>
</form:form>
</c:if>
</div>

</body>
</html>