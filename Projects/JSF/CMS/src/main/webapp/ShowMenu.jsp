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
		<h:dataTable value="#{menuList}" var="e" border="3">
			<h:column>
				<f:facet name="header">
					<h:outputText value="Menu Id"/>
				</f:facet>
				<h:outputText value="#{e.menuid}" />
			</h:column>
				<h:column>
				<f:facet name="header">
					<h:outputText value="Item Name"/>
				</f:facet>
				<h:outputText value="#{e.menuItem}" />
			</h:column>
				<h:column>
				<f:facet name="header">
					<h:outputText value="Menu Price"/>
				</f:facet>
				<h:outputText value="#{e.menuPrice}" />
			</h:column>
			<h:column>
			<f:facet name="header">
					<h:outputText value="Restaurant Id"/>
				</f:facet>
				<h:outputText value="#{e.restaurant_ID}" />
			</h:column>
			<h:column>
			<f:facet name="header">
					<h:outputText value="Menu Calories"/>
				</f:facet>
				<h:outputText value="#{e.menucalories}" />
			</h:column>
			<h:column>
			<f:facet name="header">
					<h:outputText value="Menu Speciality"/>
				</f:facet>
				<h:outputText value="#{e.menuSpeciality}" />
			</h:column>
		</h:dataTable>
	</h:form>
	
	
    </body>
</html>
</f:view>