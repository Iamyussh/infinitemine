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

<style>


body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    
    
   center {
        margin-top: 50px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        padding: 20px;
        border-radius: 5px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
    }

    input[type="text"],
    input[type="password"] {
        width: 50%;
        padding: 5px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="submit"] {
        background-color: #333;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #555;
    }

    .error {
        color: red;
        text-align: center;
        margin-top: 10px;
    }
</style>

</head>
<body>
<form method="post" action="login.jsp">
<center>
<h2>Please Login :</h2>
Username : <input type="text" name="userName" size="50"> <br/><br/>
Password : <input type="password" name="passWord" size="50"> <br/><br/>
<input type="submit" value="login">
</center>
</form>
		<c:if test="${param.userName!=null && param.passWord!=null}">
	<jsp:useBean id="login" class="com.java.lib.LibUsers"/>
	<jsp:setProperty property="*" name="login"/>
	<jsp:useBean id="dao" class="com.java.lib.LibraryDaoImpl"/>
	<c:set var="count" value="${dao.authenticate(login)}"/>
	<c:if test="${count==1}">
		<%
			session.setAttribute("user", request.getParameter("userName"));
		%>
		<jsp:forward page="Menu.jsp"/>
	</c:if>
	<c:if test="${count==0}">
		<c:out value="Invalid Credentials..."/>
	</c:if>
	
</c:if>
		
		
		
</body>
</html>