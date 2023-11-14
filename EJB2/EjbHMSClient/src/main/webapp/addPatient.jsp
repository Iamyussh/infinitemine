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
	<h:outputText value="Add Patient" />
	</h2>
	<h:form id="form">
	<h:outputText value="Patient Id " />
	<h:inputText id="pid" value="#{pat.pid}" /><br/> 
	
	<h:outputText value="Patient Name " />
	<h:inputText id="name" value="#{pat.name}" /><br/> 
	
	<h:outputText value="Age " />
	<h:inputText id="age" value="#{pat.age}" /><br/> 
	
	<h:outputText value="Weight " />
	<h:inputText id="Weight" value="#{pat.weight}" /><br/> 

	<h:outputText value="gender " />
	<h:inputText id="gender" value="#{pat.gender}" /><br/> 

	<h:outputText value="address " />
	<h:inputText id="address" value="#{pat.address}" /><br/> 

	<h:outputText value="phoneno " />
	<h:inputText id="phoneno" value="#{pat.phoneno}" /><br/> 

	<h:outputText value="disease " />
	<h:inputText id="disease" value="#{pat.disease}" /><br/> 

	<h:outputText value="Doctor Id " />
	<h:inputText id="Doctorid" value="#{pat.doctorId}" /><br/> 
	<h:outputText value=" Username" />
	<h:inputText id="uname" value="#{pat.username}" /><br/> 
	
	<h:outputText value="Email" />
	<h:inputText id="email" value="#{pat.email}" /><br/> 
	
	<br/><br/>
	<h:commandButton action="#{patientdao.addPatient(pat)}" value="Send Otp" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	
	</h:form>
</center>
    </body>
</html>

</f:view>