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
       <h:outputText value="#{employFound.empno }" style="font-size: 16px; color: #007bff;"></h:outputText><br/><br/>
<h:outputText value="#{employFound.name }" style="font-size: 16px; color: #333;"></h:outputText><br/><br/>
<h:outputText value="#{employFound.gender }" style="font-size: 16px; color: #555;"></h:outputText><br/><br/>
<h:outputText value="#{employFound.dept }" style="font-size: 16px; color: #888;"></h:outputText><br/><br/>
<h:outputText value="#{employFound.desig }" style="font-size: 16px; color: #555;"></h:outputText><br/><br/>
<h:outputText value="#{employFound.basic }" style="font-size: 16px; color: #007bff;"></h:outputText><br/><br/>
       
       
               </center>
        </h:form>
    </body>
</html>
</f:view>