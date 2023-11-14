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
   <h:dataTable value="#{customerDao.showCustomerDao()}" var="e" border="3">
   
   		<h:column>
   			<f:facet name="header">
   					<h:outputLabel value="Customer Id" />
   			</f:facet>
   			<h:outputText value="#{e.cusid}"/>
   		</h:column>
   		
   		
   		<h:column>
   			<f:facet name="header">
   					<h:outputLabel value="Customer Name" />
   			</f:facet>
   			<h:outputText value="#{e.cusname}"/>
   		</h:column>
   		
   		
   		<h:column>
   			<f:facet name="header">
   					<h:outputLabel value="Customer Phone Number" />
   			</f:facet>
   			<h:outputText value="#{e.phoneno}"/>
   		</h:column>
   		
   		
   		<h:column>
   			<f:facet name="header">
   					<h:outputLabel value="Customer Username" />
   			</f:facet>
   			<h:outputText value="#{e.cusname}"/>
   		</h:column>
   		
   		<h:column>
   			<f:facet name="header">
   					<h:outputLabel value="Customer Password" />
   			</f:facet>
   			<h:outputText value="#{e.cuspassword}"/>
   		</h:column>
   		
   		<h:column>
   			<f:facet name="header">
   					<h:outputLabel value="Customer Email" />
   			</f:facet>
   			<h:outputText value="#{e.cusemail}"/>
   		</h:column>
   		
   		
   </h:dataTable>
   
   <h:commandButton action="AddCustomer.jsp" value="Add Customer" />
   </h:form>
    </body>
</html>
</f:view>