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
    <center>
        <h:form>
                <h2 style="text-align: center" class="col-sm-4">Edit Your Record</h2>
            <hr/>
Employ No
                    <h:inputText id="empno" value="#{editEmploy.empno}" /> <br/>
Employ Name
                    <h:inputText id="name" value="#{editEmploy.name}" /> <br/>
Gender 
                    <h:inputText id="gender" value="#{editEmploy.gender}" /> <br/>                    
Department 
                    <h:inputText id="dept" value="#{editEmploy.dept}" /> <br/>
Designation
                    <h:inputText id="desig" value="#{editEmploy.desig}" /> <br/>
Basic
                    <h:inputText id="basic" value="#{editEmploy.basic}"/> <br/>
                    <h:commandButton value="Update" 
                    	action="#{ejbImpl.updateEmployEjb(editEmploy)}" />
        </center>
        </h:form>
    </body>
</html>
</f:view>