<%@page import="com.java.lib.LibUsers"%>
<%@page import="com.java.lib.LibraryDaoImpl"%>
<%@page import="com.java.lib.LibraryDAO"%>
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
	<form method="post" action="AddUser.jsp">
		User Name : 
		<input type="text" name="userName" /> <br/><br/>
		Password : 
		<input type="password" name="passWord" /> <br/><br/>
		Re-Type Password : 
		<input type="password" name="retypePassCode" /> <br/><br/> 
		<input type="submit" value="Create Account" />
	</form>
	<c:if test="${param.userName!=null  && param.passWord!=null}">
	<c:if test="${param.passWord == param.retypePassCode}">
	<jsp:useBean id="libUsers" class="com.java.lib.LibUsers"/>
	<jsp:setProperty property="*" name="libUsers" />
	<jsp:useBean id="beanDao" class="com.java.lib.LibraryDaoImpl" />
	
	<%=beanDao.createUser(libUsers) %>
	</c:if>
	</c:if>
	
</body>
</html>