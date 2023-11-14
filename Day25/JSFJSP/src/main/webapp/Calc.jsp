<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <f:view>
    <body>
    <h:form>

       Please enter numbers:<br/>

       First number:

       <h:inputText id="num1" value="#{calculation.firstno}" /><br/>    

       Second number:

       <h:inputText id="num2" value="#{calculation.secondno}" /><br/>

       Result is:

       <h:outputText value="#{calculation.result}" /><br/>

       <h:commandButton actionListener="#{calculation.addition}" value="Sum" />

    </h:form>
   
       
        

    </body>
    </f:view>
</html>
