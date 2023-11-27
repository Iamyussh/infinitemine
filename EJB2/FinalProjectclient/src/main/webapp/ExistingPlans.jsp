<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 


<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        
        html{
        
        background : rgb{2.0,36};
        
        
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            background-color: #333;
            color: #fff;
            padding: 10px;
        }

        h2 {
            text-align: center;
        }

        .dataTableContainer {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            border-spacing: 0;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #333;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .dataTableContainer .commandButtons {
            text-align: center;
        }

        .commandButtons button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 5px 10px;
            margin: 5px;
            border-radius: 3px;
            cursor: pointer;
        }

        .commandButtons button:disabled {
            background-color: #ccc;
            cursor: not-allowed;
        }
    </style>
    </head>
    <body>
   
        <h:form>
        <center>
                <h2><h:outputText value="Existing Plans"/></h2>
                
            </center>
        <h:dataTable value="#{paginationDao.getInsuranceList()}" var="e" border="3">
        	    <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="Insurance id" />
                    </f:facet>
                    <h:outputText value="#{e.insuranceId}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Insurance Name" />
                    </f:facet>
                    <h:outputText value="#{e.insuranceName}"/>
                </h:column>
                 <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Type" />
                    </f:facet>
                    <h:outputText value="#{e.type}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Premium Start" />
                    </f:facet>
                    <h:outputText value="#{e.premiumStart}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Premium End" />
                    </f:facet>
                    <h:outputText value="#{e.premiumEnd}"/>
                </h:column>
                 
                
                 <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Launch Date" />
                    </f:facet>
                    <h:outputText value="#{e.launchDate}"/>
                </h:column>
                
                  <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Status" />
                    </f:facet>
                    <h:outputText value="#{e.status}"/>
                </h:column>
                
               
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Add Subplan" />
				</f:facet>
				<h:commandButton action="#{insurancePlansdao.redirectToAddSubplan(e.insuranceId)}" value="Add plans" />
			</h:column>
			
			
        </h:dataTable>
        <br/><br/>
        <center>
        <h:commandButton action="InsuranceDetailsPagination.jsp" value="Go to insurance details" /><br><br>
       
        
        </center>
         <!--The paging buttons-->
            <h:commandButton value="first" action="#{paginationDao.pageFirst}"
                             disabled="#{paginationDao.firstRow == 0}" />
            <h:commandButton value="prev" action="#{paginationDao.pagePrevious}"
                             disabled="#{paginationDao.firstRow == 0}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="next" action="#{paginationDao.pageNext}"
                             disabled="#{paginationDao.firstRow + paginationDao.rowsPerPage >= paginationDao.totalRows}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="last" action="#{paginationDao.pageLast}"
                             disabled="#{paginationDao.firstRow + paginationDao.rowsPerPage >= paginationDao.totalRows}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:outputText value="Page #{paginationDao.currentPage} / #{paginationDao.totalPages}" />
            <br />
            
        </h:form>
    </body>
</html>
</f:view>
