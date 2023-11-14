<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 

<f:view>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style type="text/css">
        /* style.css */

/* Header styles */
b {
    font-size: 24px;
    color: #e74c3c;
    text-align: center;
}

/* Navigation link styles */
h:commandLink {
    background-color: #e74c3c;
    color: #fff;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 0 20px;
    cursor: pointer;
}

/* General styles */
body {
    background-color: #f2f2f2;
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}
        
    </style>
</head>
<body>
<h:form>
        Welcome to : <b>
        	<h:outputText value="#{loggedVendor}" /> <br/><br/>
        </b>
        
       
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <h:commandLink action="ShowRestaurant">
        	<h:outputLabel value="Show Restaurant's" />
        </h:commandLink>
       
        
        
        
        
        
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <h:commandLink action="#{vendorDao.showPendingOrders()}">
        	<h:outputLabel value="Pending Orders" />
        </h:commandLink>
     </h:form>
     </body>
</html>
</f:view>