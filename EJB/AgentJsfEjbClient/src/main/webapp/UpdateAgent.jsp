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
            
            .update-button {
                background-color: #007bff;
                color: #fff;
                padding: 5px 10px;
                border: none;
                cursor: pointer;
            }
            
            .update-button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <h:form>
        		<center>
                <h2><h:outputText value="Update Record"/></h2>
            </center>
            
            <center>
           Agent ID
            <h:inputText value="#{editAgent.agentID}" />
            
            <br/><br/>
            
            Agent Name:
            <h:inputText value="#{editAgent.name}" />
             <br/><br/>
            
            Agent City:
            <h:inputText value="#{editAgent.city}" />
             <br/><br/>
             
              Agent Gender:
            <h:inputText value="#{editAgent.GENDER}" />
             <br/><br/>
            
          Agent Marital Status
            <h:inputText value="#{editAgent.maritalStatus}" />
             <br/><br/>
            
            Premium:
            <h:inputText value="#{editAgent.premium}" />
             <br/><br/>
            
            
               
                <h:commandButton styleClass="update-button" action="#{ejbImpl.updateAgentEjb(editAgent)}" value="Update" />
               
        
        </center>
        </h:form>
    </body>
</html>
</f:view>