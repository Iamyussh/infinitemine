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
   <label>Customer Name:</label>
   <h:inputText value="#{customer.cusname}" /><br/><br/>
   
   
    <label>Phone Number</label>
   <h:inputText value="#{customer.phoneno}" /><br/><br/>
   
   
    <label>UserName</label>
   <h:inputText value="#{customer.cususername}" /><br/><br/>
   
   
    <label>	Password</label>
   <h:inputText value="#{customer.cuspassword}" /><br/><br/>
   
    <label>	Email</label>
   <h:inputText value="#{customer.cusemail}" /><br/><br/>
   
   <h:commandButton action="#{customerController.addCustomer()}" value="Add Customer" />
  <h:messages/>
   
   </h:form>
    </body>
</html>
</f:view>