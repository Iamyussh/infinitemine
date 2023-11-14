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
        		<center>
                <h2><h:outputText value="Order History"/></h2>
            </center>
        <center>
        <h:dataTable value="#{orderList}" var="e" border="5">
        	            	   
        	            	  <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Order ID" />
        	           </f:facet>
                    <h:outputText value="#{e.ordid}"/>
                </h:column>
                
                
                
                  <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Customer ID" />
        	           </f:facet>
                    <h:outputText value="#{e.cusid}"/>
                </h:column>
                
                 
        	            	  <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Vendor ID" />
        	           </f:facet>
                    <h:outputText value="#{e.venid}"/>
                </h:column>
                
                
                  <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Wallet Source" />
        	           </f:facet>
                    <h:outputText value="#{e.walsource}"/>
                </h:column>
                
                
                  <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Menu ID" />
        	           </f:facet>
                    <h:outputText value="#{e.menid}"/>
                </h:column>
                
                
                  <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Order Date " />
        	           </f:facet>
                    <h:outputText value="#{e.orddate}"/>
                </h:column>
                
                <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Order quantity" />
        	           </f:facet>
                    <h:outputText value="#{e.ordquantity}"/>
                </h:column>
                
                
                <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Order Bill Amount" />
        	           </f:facet>
                    <h:outputText value="#{e.ordbillamount}"/>
                </h:column>
                
                  
                <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Order Status" />
        	           </f:facet>
                    <h:outputText value="#{e.ordstatus}"/>
                </h:column>
                
                 <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Order Comments" />
        	           </f:facet>
                    <h:outputText value="#{e.ordcomments}"/>
                </h:column>
                   
                   
               
        </h:dataTable>
        </h:form>
        </center>
    </body>
</html>
</f:view>