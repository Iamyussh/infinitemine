<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<html xmlns="http://www.w3c.org/1999/xhtml"
 xmlns:h="http://java.sun.com/jsf/html"
 xmlns:p="http://primefaces.prime.com.tr/ui">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>

<h:outputText value="Premium Start" />
                    &nbsp;&nbsp;
                  
                    <p:calendar id="pstart" value="#{insuranceDetails.premiumStart}" pattern="yyyy-MM-dd" /> <!-- Use PrimeFaces p:calendar -->
                    <br /><br />


</f:view>
</body>
</html>