<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>


		<h1>Login Page</h1>		
			
			<h:form>
			<center>
			
			 <h:outputText value="UserName" />
            <h:inputText id="uname" value="#{pat.username}" /><br/>

            <h:outputText value="Enter password" />
            <h:inputText id="val" value="#{pat.password}" /><br/><br/>
            
           <h:commandButton action="#{patientdao.loginvalidate(pat)}" value="Login"/>
            
			</center>
		</h:form>
</f:view>
</body>
</html>