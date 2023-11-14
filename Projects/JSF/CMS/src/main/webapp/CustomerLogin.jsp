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
   <h1>Customer Login:</h1>
   <label>Customer Name:</label>
   <h:inputText value="#{customer.cususername}" /><br/><br/>
 
    <label>	Password</label>
   <h:inputText value="#{customer.cuspassword}" /><br/><br/>
   
   
   <h:commandButton action="#{customerDao.Loginvalidate(customer)}" value="Login" />
   
   
   </h:form>
    </body>
</html>
</f:view>