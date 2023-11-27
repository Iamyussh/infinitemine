<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style>

    body {
                    font-family: Arial, sans-serif;
                    background-color: #f2f2f2;
                    margin: 0;
                    padding: 0;
                }

                center {
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: center;
                    height: 100vh;
                }

                h2 {
                    color: #007bff;
                    margin-bottom: 30px;
                }

                h:form {
                    max-width: 800px;
                    margin: 0 auto;
                    padding: 20px;
                    background-color: #fff;
                    border-radius: 8px;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                }

                h:dataTable {
                    width: 150%;
                    border-collapse: collapse;
                    margin-top: 20px;
                }

                h:column {
                    padding: 50px;
                    border-bottom: 1px solid #ddd;
                }

                h:column th {
                    background-color: #f2f2f2;
                    padding: 50px;
                    text-align: left;
                    border-bottom: 1px solid #ddd;
                }

                h:column td:hover {
                    background-color: #e0e0e0;
                }

                h:commandButton {
                    display: inline-block;
                    padding: 10px 20px;
                    font-size: 16px;
                    text-align: center;
                    text-decoration: none;
                    cursor: pointer;
                    border: 1px solid #3498db;
                    color: #3498db;
                    background-color: #ffffff;
                    border-radius: 5px;
                    transition: background-color 0.3s, color 0.3s, border-color 0.3s;
                    margin-top: 10px;
                }

                h:commandButton:hover {
                    background-color: olive;
                    color: #ffffff;
                    transform: scale(1.1);
                    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
                }
</style>

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