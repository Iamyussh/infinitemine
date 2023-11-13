<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginS</title>
</head>
<body>

		<form method = "post" action = "Login.jsp">
		<center>
		User Name:
		<input type ="text" name ="userName" /><br/><br/>
		Password:
		<input type ="password" name="passWord"><br/><br/>
		<input type ="submit"  value = "Login" />
		</center></form>
		
		<%
		
		if(request.getParameter("userName")!=null &&
		request.getParameter("passWord")!=null){
			
			String userName = request.getParameter("userName");
			String pwd = request.getParameter("passWord");
			
			if(userName.equals("infinite") && pwd.equals("infinite")){
				out.println("Correct credentials");
				
				%>
				
				<jsp:forward page ="Menu.jsp"/>
				
				<%
			}
			else{
				out.println("invalid Credentials");
			}
		}
		
		%>

</body>
</html>