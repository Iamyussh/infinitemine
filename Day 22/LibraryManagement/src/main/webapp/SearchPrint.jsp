<%@page import="com.java.lib.Books"%>
<%@page import="java.util.List"%>
<%@page import="com.java.lib.LibraryDaoImpl"%>
<%@page import="com.java.lib.LibraryDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>SearchPrint</title>

    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<c:if test="${param.searchtype != null && param.searchvalue != null}">
    <jsp:useBean id="show" class="com.java.lib.Books"/>
    <jsp:setProperty property="*" name="show"/>
    <jsp:useBean id="dao" class="com.java.lib.LibraryDaoImpl"/>
    <c:set var="booksList" value="${dao.searchBooks(param.searchtype, param.searchvalue)}"/>
</c:if>
<form action="Issue.jsp">
    <table border="3" align="center">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Author</th>
            <th>Edition</th>
            <th>Department</th>
            <th>Total Books</th>
            <th>CheckBox</th>
        </tr>
        <c:forEach var="book" items="${booksList}">
            <tr>
                <td><c:out value="${book.id}" /></td>
                <td><c:out value="${book.name}" /></td>
                <td><c:out value="${book.author}" /></td>
                <td><c:out value="${book.edition}" /></td>
                <td><c:out value="${book.dept}" /></td>
                <td><c:out value="${book.noOfBooks}" /></td>
                <c:if test="${book.noOfBooks != 0}">
                    <td><input type="checkbox" name="lib" value="${book.id}"/></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Issue Book" />
</form>
</body>
</html>
