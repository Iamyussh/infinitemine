<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 
<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order place</title>
    </head>
    <body>
    <center>
    <h1>Place your Order</h1>
    <br/><br/><br/>
    </center>
    
   <h:form>
   <center>
   <h:outputText value="Customer Id"></h:outputText>  &nbsp; &nbsp; &nbsp;
    <h:inputText value="#{customerFound.cusid}"></h:inputText>
    <br/><br/>
    
    
    Select Vendor:
    <h:selectOneMenu id="localCode" value="#{vendorDao.localCode}" onchange="submit()"
    valueChangeListener="#{vendorDao.employLocaleCodeChanged}">
    <f:selectItems value="#{vendorDao.showVendorNames()}"/>
    </h:selectOneMenu>  
    <br/><br/>
    
      
    Select Wallet:
    <h:selectOneMenu id="walletlist" value="#{customerDao.localCode}" onchange="submit()"
    valueChangeListener="#{customerDao.employLocaleCodeChanged}">
    <f:selectItems value="#{customerDao.showWalletNames()}"/>
    </h:selectOneMenu>  
    <br/><br/>
 
 
    Selected Vendor Value is:
    	<h:outputText value="#{vendorDao.localCode}"></h:outputText>
    <br/><br/>
    
  
    Selected Vendor Id is:
    	<h:outputText value="#{vendorDao.venId}"></h:outputText>
    <br/><br/>
    
    
    Select Restaurant:
    <h:selectOneMenu id ="restaurantSelected" value="#{restaurantDao.localCode}"
    valueChangeListener="#{restaurantDao.restaurantLocaleChanged()}">
    
    <f:selectItems value="#{restaurantDao.showRestaurantNames()}"/>
    </h:selectOneMenu>
    
    
    
    </center>
   </h:form>
    </body>
</html>
</f:view>