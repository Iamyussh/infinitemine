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
            .add-button {
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
                <h2><h:outputText value="Patient records"/></h2>
            </center>
        <h:dataTable value="#{ejbImpl.showPatientsEjb()}" var="e" border="3">
        <center>
              	    <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="PId" />
                    </f:facet>
                    <h:outputText value="#{e.pid}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Name" />
                    </f:facet>
                    <h:outputText value="#{e.name}"/>
                </h:column>
                                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Age" />
                    </f:facet>
                    <h:outputText value="#{e.age}"/>
                </h:column>
                
                                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Weight" />
                    </f:facet>
                    <h:outputText value="#{e.weight}"/>
                </h:column>
                                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Gender" />
                    </f:facet>
                    <h:outputText value="#{e.gender}"/>
                </h:column>
                                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Address" />
                    </f:facet>
                    <h:outputText value="#{e.address}"/>
                </h:column>
                
                  <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="PHone no" />
                    </f:facet>
                    <h:outputText value="#{e.phoneno}"/>
                </h:column>
                
                  <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Disease" />
                    </f:facet>
                    <h:outputText value="#{e.disease}"/>
                </h:column>
                
                  <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="doctor id" />
                    </f:facet>
                    <h:outputText value="#{e.doctorId}"/>
                </h:column>
                
                
                 <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Username" />
                    </f:facet>
                    <h:outputText value="#{e.username}"/>
                </h:column>
                
                
                <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="E-mail" />
                    </f:facet>
                    <h:outputText value="#{e.email}"/>
                </h:column>
                
                
                 
             
                
        </h:dataTable>
        
        <center>
        <h:commandButton action="addPatient.jsp?faces-redirect=true"	styleClass="add-button"
        	 value="Add Patient" /> 
        	 
        	 
       </center>
        
        </h:form>
    </body>
</html>
</f:view>