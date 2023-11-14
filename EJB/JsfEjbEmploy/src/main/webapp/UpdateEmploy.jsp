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
            Employ no:
            <h:inputText value="#{editEmploy.empno}" />
            
            <br/><br/>
            
            Employ Name:
            <h:inputText value="#{editEmploy.name}" />
             <br/><br/>
            
            Department:
            <h:inputText value="#{editEmploy.dept}" />
             <br/><br/>
            
            Designation:
            <h:inputText value="#{editEmploy.desig}" />
             <br/><br/>
            
            Salary:
            <h:inputText value="#{editEmploy.basic}" />
             <br/><br/>
            
            
               
                <h:commandButton styleClass="update-button" action="#{ejbImpl.updateEmployEjb(editEmploy)}" value="Update" />
               
        
        </center>
        </h:form>
    </body>
</html>
</f:view>