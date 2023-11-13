<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Agent Management</title>
</head>
<body>
    <h1>Agent Search</h1>
    <form method="get" action="SearchAgent.jsp">
        Search Agent by Id: <input type="id" name="searchId" />
        <input type="submit" value="Search" />
    </form>

    <c:if test="${not empty param.searchId}">
    
        <sql:setDataSource var="connection" driver="com.mysql.cj.jdbc.Driver"
        
            url="jdbc:mysql://localhost:3306/Agent" 
            user="root"
            
             password="india@123" />
             
             
        <sql:query var="agents" dataSource="${connection}">
            SELECT * FROM Agent WHERE agentid LIKE ?;
            <sql:param value="%${param.searchId}%"/>
        </sql:query>

        <c:choose>
            <c:when test="${not empty agents.rows}">
                <h2>Search Results:</h2>
                <table>
                    <tr>
                        <th>Agent ID</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Gender</th>
                        <th>Marital Status</th>
                        <th>Premium</th>
                    </tr>
                    <c:forEach var="agent" items="${agents.rows}">
                        <tr>
                            <td>${agent.agentid}</td>
                            <td>${agent.name}</td>
                            <td>${agent.city}</td>
                            <td>${agent.gender}</td>
                            <td>${agent.maritalstatus}</td>
                            <td>${agent.premium}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <p>Agent not Found</p>
            </c:otherwise>
        </c:choose>
    </c:if>
</body>
</html>
