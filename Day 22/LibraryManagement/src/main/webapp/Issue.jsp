<%@page import="java.util.List"%>
<%@page import="com.java.lib.LibraryDaoImpl"%>
<%@page import="com.java.lib.LibraryDAO"%>
<%@page import="com.java.lib.Books"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Issue Books</title>
</head>
<body>
  		<jsp:include page="Menu.jsp"/>

	<%

	String user = (String)session.getAttribute("user");

	LibraryDAO dao = new LibraryDaoImpl();

	String[] str = request.getParameterValues("lib");

	if (str != null) {

    for (String bookId : str) {

    		out.println(dao.issueBook(user, bookId));

     }

}

%>
</body>
</html>
