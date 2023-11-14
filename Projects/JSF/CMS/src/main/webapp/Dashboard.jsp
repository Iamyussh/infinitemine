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
            /* Additional CSS styles */
            .additional-style {
                font-weight: bold;
                color: #27ae60;
            }

            /* Add more styles as needed */
        </style>
    </head>
    <body>
        <h:form>
            <h1>Welcome to the DashBoard:</h1>
            <h2><h:outputText value="#{loggedCustomer}" class="additional-style" /></h2>
            <br/><br/>
            <h:commandButton action="#{customerController.SearchCustomer()}" value="Show Customer details" />
            &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
            <h:commandButton action="#{customerController.ShowCustomerWallet()}"  value="Show Wallets"/>
            &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
            <h:commandButton action="ShowRestaurant.jsp" value="Show Restaurants"/>
            &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
            <h:commandButton action="PlaceOrder.jsp" value="Place Order"/>
        </h:form>
    </body>
</html>
</f:view>
