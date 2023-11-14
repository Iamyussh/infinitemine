
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>



<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style type="text/css">
/* styles.css */
body {
  font-family: Arial, sans-serif;
  background-color: #f0f0f0;
  text-align: center;
}

h2 {
  color: #333;
}



.center {
  text-align: center;
}


#addbutton {
  background-color: #007bff; /* Change the color to your preference */
  color: #fff;
  padding: 10px 20px;
  border: none;
  cursor: pointer;
}


</style>
</head>
<body>
  <center>
	<h2>
		<h:outputText value="Create a new plan" />
	</h2>
	<h:form id="form">
	<div id="form">
		
	
		<h:outputText value="Insurance name" />
		&nbsp;&nbsp;
		<h:inputText id="iname" value="#{insuranceDetails.insuranceName}" />
		<br /><br />

		<h:outputText value="Types " />
		<h:selectOneMenu value="#{insuranceDetails.type}">
			<f:selectItem itemValue="Government" itemLabel="Government" />
			<f:selectItem itemValue="Private" itemLabel="Private" />
		
		</h:selectOneMenu>
		<br/><br/>
		<h:outputText value="Premium Start" />
		&nbsp;&nbsp;
		<h:inputText id="pstart" value="#{insuranceDetails.premiumStart}" >
		<f:convertDateTime pattern="yyyy-MM-dd"/>
		</h:inputText>
		<br /><br />
		
		<h:outputText value="Premium End" />
		&nbsp;&nbsp;
		<h:inputText id="pend" value="#{insuranceDetails.premiumEnd}" >
		<f:convertDateTime pattern="yyyy-MM-dd"/>
		
		</h:inputText>
		<br /><br />
		
	
		
		<h:outputText value="Launch Date" />
		&nbsp;&nbsp;
		<h:inputText id="ldate" value="#{insuranceDetails.launchDate}" >
		<f:convertDateTime pattern="yyyy-MM-dd"/>
		</h:inputText>
		<br /><br />
		
		
		<h:selectOneMenu value="#{insuranceDetails.status}">
			<f:selectItem itemValue="Active" itemLabel="Active" />
			<f:selectItem itemValue="Pending" itemLabel="Pending" />
		
		</h:selectOneMenu>
	</div>
		<h:commandButton id="addbutton" action ="#{insuranceController.addInsurance(insuranceDetails)}" value="Add a plan"/>
		</center>


		<h:messages />
	</h:form>
</body>
</html>
</f:view>
