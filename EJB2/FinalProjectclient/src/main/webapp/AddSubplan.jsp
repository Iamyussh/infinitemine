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
				<h:outputText value="Add a subplan" />
			</h2>
			
			
			<h:form>
			
			
			<h:outputText value="Insurance Id" />
		<h:inputText id="insid" value="#{insuranceid}" />
		<br />


		<h:outputText value="Premium Amount" />
		<h:inputText id="pamt" value="#{insuranceplan.premiumamt}" />
		<br />
		
			<h:outputText value="Coverage Amount" />
		<h:inputText id="cvgamt" value="#{insuranceplan.coverageamt}" />
		<br />

		<h:commandButton action ="#{insuranceController.addInsurancePlans(insuranceplan)}" value="Add"/>
		&nbsp;
		<h:commandButton action ="InsuranceShow.jsp" value="Insurance Details"/>
		
		
		<h:messages/>
		</h:form>
	</center>
</body>
	</html>
</f:view>