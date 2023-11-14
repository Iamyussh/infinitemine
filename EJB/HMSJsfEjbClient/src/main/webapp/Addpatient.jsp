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
         <h2 style="text-align: center" class="col-sm-4">Add Your Record</h2>
            <hr/>

Pid
                    <h:inputText id="pid" value="#{patient.pid}" /> <br/>
 name                  
                    <h:inputText id="name" value="#{patient.name}" /> <br/>
                    
                    age
                    <h:inputText id="age" value="#{patient.weight}" /> <br/>
                    
                    weight
                    <h:inputText id="weight" value="#{patient.weight}" /> <br/>
                    
                   
                    

Gender 
	<h:selectOneMenu value="#{patient.gender}">
		<f:selectItem itemValue="MALE" itemLabel="Male" />
    <f:selectItem itemValue="FEMALE" itemLabel="Female" />
</h:selectOneMenu>


 address
                    <h:inputText id="address" value="#{patient.address}" /> <br/>                   
                    phoneno
                    <h:inputText id="phoneno" value="#{patient.phoneno}" /> <br/>
                    
                     Disease
                    <h:inputText id="Disease" value="#{patient.disease}" /> <br/>
                    
                    Doctor id
                    <h:inputText id="did" value="#{patient.doctorId}" /> <br/>
                    
                    
                    <h:commandButton value="Insert" 	
                    	action="#{pejbImpl.addPatientEjb(patient)}" />
        
        </h:form>
    </body>
</html>
</f:view>