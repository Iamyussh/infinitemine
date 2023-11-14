<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Password</title>
</head>
<body>
<f:view>
    <h:form>
        <center>
            <h1>Create Password</h1>

            <h:outputText value="UserName" />
            <h:inputText id="uname" value="#{pat.username}" /><br/>

            <h:outputText value="Enter password" />
            <h:inputText id="create" value="#{pat.password}" /><br/>

            <h:outputText value="Enter Otp" />
            <h:inputText id="otp" value="#{pat.otp}" /><br/>

            <h:commandButton action="#{patientdao.setPatientPassword(pat)}" value="submit" />
        </center>
    </h:form>
</f:view>

</body>
</html>