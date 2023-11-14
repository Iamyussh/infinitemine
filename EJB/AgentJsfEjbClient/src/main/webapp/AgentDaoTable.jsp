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
            /* Define your CSS styles here */
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
            }
            
            h2 {
                text-align: center;
                color: #333;
            }
            
            .table-container {
                width: 80%;
                margin: 0 auto;
                border: 1px solid #ccc;
                border-collapse: collapse;
            }
            
            .table-container th, .table-container td {
                padding: 8px;
                text-align: center;
                border: 1px solid #ccc;
            }
            
            .table-container th {
                background-color: #333;
                color: #fff;
            }
            
            .search-button {
                background-color: #007bff;
                color: #fff;
                padding: 5px 10px;
                border: none;
                cursor: pointer;
            }
             .delete-button {
                background-color: #007bff;
                color: #fff;
                padding: 5px 10px;
                border: none;
                cursor: pointer;
            }
            
            .search-button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <h:form>
        		<center>
                <h2><h:outputText value="Agent Records"/></h2>
            </center>
            
            <center>
        <h:dataTable value="#{ejbImpl.showAgentEjb()}" var="e" border="3">
              	    <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="Agent ID" />
                    </f:facet>
                    <h:outputText value="#{e.agentID}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Agent Name" />
                    </f:facet>
                    <h:outputText value="#{e.name}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="City" />
                    </f:facet>
                    <h:outputText value="#{e.city}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Gender" />
                    </f:facet>
                    <h:outputText value="#{e.GENDER}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Marital Status" />
                    </f:facet>
                    <h:outputText value="#{e.maritalStatus}"/>
                </h:column>
                
                 <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Premium" />
                    </f:facet>
                    <h:outputText value="#{e.premium}"/>
                </h:column>
                
                
                <h:column>
                <f:facet name="header">
                <h:outputLabel value="Search" />
                </f:facet>
                <h:commandButton styleClass="search-button" action="#{ejbImpl.searchAgentEjb(e.agentID)}" value="Search" />
                </h:column>
                
                 <h:column>
                <f:facet name="header">
                <h:outputLabel value="Delete" />
                </f:facet>
                <h:commandButton styleClass="delete-button" action="#{ejbImpl.deleteAgentEjb(e.agentID)}" value="Delete" />
                </h:column>

        </h:dataTable>
        
        
        </center>
        
        <center>
        
        <h:commandButton action="CreateAgent.jsp?faces-redirect=true"
        value="Add Agent"/>
        </center>
        
        </h:form>
    </body>
</html>
</f:view>