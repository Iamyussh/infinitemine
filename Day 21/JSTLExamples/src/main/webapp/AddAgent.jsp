<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="AddAgent.jsp">
		<center>
			Agent Id : 
			<input type="number" name="agentid" /> <br/><br/>
			Agent Name : 
			<input type="text" name="name" /> <br/><br/> 
			City : 
			<input type="text" name="city" /> <br/><br/>
			Gender :
			<select name="gender">
				<option value="MALE">Male</option>
				<option value="FEMALE">Female</option>
			</select> <br/><br/> 
			MaritalStatus : 
			<input type="text" name="maritalstatus" /> <br/><br/>
			 Premium : 
			<input type="number" name="premium" /> <br/><br/> 
			<input type="submit" value="Add Agent" />
		</center>
	</form>
	<c:if test="${param.agentid!=null && param.premium!=null}">
		<sql:setDataSource var="connection"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/Agent"
	user="root"
	password="india@123" />
			<sql:update var="agentUpdate" dataSource="${connection}">
		Insert into Agent(agentid,name,city,gender,maritalstatus,premium) values(?,?,?,?,?,?)
		<sql:param value="${param.agentid}" />
		<sql:param value="${param.name}" />
		<sql:param value="${param.city}"/>
		<sql:param value="${param.gender}" />
		<sql:param value="${param.maritalstatus}" />
		<sql:param value="${param.premium}" />
	</sql:update>
	<c:out value="Agent was added..." />
		
	</c:if>
</body>
</html>