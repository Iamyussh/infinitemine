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
				<h:outputText value="Insurance Plans" />
			</h2>
		<h:dataTable value="#{insurancePlansdao.showPlans(insuranceid)}" var="e"
			border="3">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Plan id" />
				</f:facet>
				<h:outputText value="#{e.planid}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance id" />
				</f:facet>
				<h:outputText value="#{e.insuranceid}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Premium Amount" />
				</f:facet>
				<h:outputText value="#{e.premiumamt}" />
			</h:column>
			
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Coverage Amount" />
				</f:facet>
				<h:outputText value="#{e.coverageamt}" />
			</h:column>
			
			
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Diseases Covered" />
				</f:facet>
				<h:outputText value="#{e.discov}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Claim Policy" />
				</f:facet>
				<h:commandButton action="#{insurancePlansdao.showPlans(e.insuranceid)}" value="Take Policy" />
			</h:column>
			
			
			
			</h:dataTable>
		</center>
	</h:form>
</body>
	</html>
</f:view>