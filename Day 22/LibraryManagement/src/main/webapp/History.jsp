<%@page import="com.java.lib.LibraryDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.java.lib.Tranbook" %>
<%@ page import="com.java.lib.LibraryDAO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library Transaction History</title>
</head>
<body>
    

    <%
        String username = (String) session.getAttribute("user");
        LibraryDAO dao = new LibraryDaoImpl();
        List<Tranbook> tran = dao.userhistory(username);
    %>

    <table border="3px">
        <tr>
            <th>UserName</th>
            <th>BookId</th>
            <th>Fromdate</th>
        </tr>
        <c:forEach var="history" items="<%= tran %>">
            <tr>
                <td>${history.username}</td>
                <td>${history.bookId}</td>
                <td>${history.fromdate}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

