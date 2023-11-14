<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
		<h2>
	<h:outputText value="Add Report" />
	</h2>
	<h:form id="form">
	
	
	<h:outputText value="Patient Id" />
	<h:inputText id="pid" value="#{patientReport.pid}" /><br/> 
	
	<h:outputText value="Test Code " />
	<h:inputText id="testcode" value="#{patientReport.testcode}" /><br/> 
	
	<h:outputText value="Test Name" />
	<h:inputText id="testname" value="#{patientReport.testName}" /><br/> 

	<h:outputText value="Test Description " />
	<h:inputText id="testdesc" value="#{patientReport.testdesc}" /><br/> 

	<h:outputText value="Cost" />
	<h:inputText id="cost" value="#{patientReport.cost}" /><br/> 

	<h:outputText value="comments" />
	<h:inputText id="comments" value="#{patientReport.comments}" /><br/> 

	
	
	<br/><br/>
	<h:commandButton action="#{reportController.addReport(patientReport)}" value="Create Report" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	<h:messages/>
	</h:form>
</center>
    </body>
</html>

</f:view>