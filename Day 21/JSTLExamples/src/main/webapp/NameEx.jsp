<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>		
		<form method="get" action="NameEx.jsp">
		
		<center>
		
		Name:
		<input type="text" name="sname" /><br/><br/>
		<input type="submit" value="Show" />
		
		</center>
		
		</form>
		
		<c:if test="${param.sname!=null}">
		<c:set var="sname" value="${param.sname}"/>
		Name is :
		<b>
		<c:out value="${sname }"/>
		
		</b>
		
		</c:if>

</body>
</html>