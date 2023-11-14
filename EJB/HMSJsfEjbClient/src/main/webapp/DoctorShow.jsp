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
                <h2><h:outputText value="Doctor Records"/></h2>
            </center>
            
            <center>
        <h:dataTable value="#{ejbImpl.showDoctorEjb()}" var="e" border="3">
              	    <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="Dr Id" />
                    </f:facet>
                    <h:outputText value="#{e.drId}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Dr. Name" />
                    </f:facet>
                    <h:outputText value="#{e.drName}"/>
                </h:column>
                
                  <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Dr Id" />
                    </f:facet>
                    <h:outputText value="#{e.drId}"/>
                </h:column>
                
                
                     <h:column>
                <f:facet name="header">
                <h:outputLabel value="Add Patient" />
                </f:facet>
                <h:commandButton styleClass="search-button" action="Addpatient.jsp" value="Add" />
                </h:column>
                

        </h:dataTable>
        
        
        </center>
        
       
        
        </h:form>
    </body>
</html>
</f:view>