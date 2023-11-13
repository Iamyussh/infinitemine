<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo</title>
</head>
<body>

<form method="get" action = "Demo.jsp">

<center>
		NAME:
	<input type = "text" name = "sname" /><br/><br/>
	<input type = "submit" value = "Show" />
</center>
</form>
			
			
			<%-- JAVA Code comments --%>
			
			
			<%
			if(request.getParameter("sname")!=null){
				String sname = request.getParameter("sname");
				out.println("Student Name is " +sname);
			}
			%>
</body>
</html>