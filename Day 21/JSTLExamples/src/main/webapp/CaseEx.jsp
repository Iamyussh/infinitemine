<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<c:set var="x" value=""/>
		<c:choose>
		<c:when test="${x==1}">
			<c:out value="SubhraPrakash"/>
			</c:when>
			
			<c:when test="${x==2}">
			<c:out value="Rajesh"/>
			</c:when>
			
			
			<c:when test="${x==3}">
			<c:out value="Shirisha"/>
			</c:when>
			
			<c:when test="${x==4}">
			<c:out value="Anirudh"/>
			</c:when>
			
			<c:when test="${x==5}">
			<c:out value="Shivangi"/>
			</c:when>
			
			<c:otherwise>
			<c:out value="Sonali"/>
			</c:otherwise>
			
		</c:choose>
</body>
</html>