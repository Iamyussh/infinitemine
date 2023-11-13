<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="beanGreeting"  class="com.java.jspbeans.Greeting"/>

		Default Greeting:
		<b>
	<jsp:getProperty property="message" name ="beanGreeting"/>
		</b>
		
	<jsp:setProperty property ="message" name="beanGreeting" value="Good Afternoon" />
	<br/></br>
	
	Updated Value:
	<jsp:getProperty property="message" name="beanGreeting"/>


</body>
</html>