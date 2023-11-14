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
	<h:form>
		<center>
			<h2>
				<h:outputText value="Insurance Records" />
			</h2>
		<h:dataTable value="#{insuranceDetailsdao.showInsuranceDetails()}" var="e"
			border="3">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance Id" />
				</f:facet>
				<h:outputText value="#{e.insuranceId}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance Name" />
				</f:facet>
				<h:outputText value="#{e.insuranceName}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Type" />
				</f:facet>
				<h:outputText value="#{e.type}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="PremiumStart" />
				</f:facet>
				<h:outputText value="#{e.premiumStart}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Premium End" />
				</f:facet>
				<h:outputText value="#{e.premiumEnd}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Min Period" />
				</f:facet>
				<h:outputText value="#{e.minPeriod}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Max Period" />
				</f:facet>
				<h:outputText value="#{e.maxPeriod}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Launch Date" />
				</f:facet>
				<h:outputText value="#{e.launchDate}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Status" />
				</f:facet>
				<h:outputText value="#{e.status}" />
			</h:column>
			
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Add Subplan" />
				</f:facet>
				<h:commandButton action="#{insurancePlansdao.redirectToAddSubplan(e.insuranceId)}" value="Add plans" />
			</h:column>
			</h:dataTable>
			
			
		</center>
	</h:form>
</body>
	</html>
</f:view>
