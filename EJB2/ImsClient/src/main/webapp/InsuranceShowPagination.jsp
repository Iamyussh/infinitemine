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
                <h2><h:outputText value="Select Insurance"/></h2>
            </center>
    <h:dataTable value="#{inspaginationDao.getEmployList()}" var="e"
			border="3">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance Id" />
				</f:facet>
				<h:outputText value="#{e.insuranceId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance Name" />
				</f:facet>
				<h:outputText value="#{e.insuranceName}" />
			</h:column>
			
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Show Plan"/>
				</f:facet>
				<h:commandButton action="#{insuranceplandao.redirectToInsurancePlan(e.insuranceId)}" value="show PLAN" />
			</h:column>
			
			
			</h:dataTable>
			
         <!--The paging buttons-->
            <h:commandButton value="first" action="#{inspaginationDao.pageFirst}"
                             disabled="#{inspaginationDao.firstRow == 0}" />
            <h:commandButton value="prev" action="#{inspaginationDao.pagePrevious}"
                             disabled="#{inspaginationDao.firstRow == 0}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="next" action="#{inspaginationDao.pageNext}"
                             disabled="#{inspaginationDao.firstRow + inspaginationDao.rowsPerPage >= inspaginationDao.totalRows}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="last" action="#{inspaginationDao.pageLast}"
                             disabled="#{inspaginationDao.firstRow + inspaginationDao.rowsPerPage >= inspaginationDao.totalRows}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:outputText value="Page #{inspaginationDao.currentPage} / #{inspaginationDao.totalPages}" />
            <br />
        </h:form>
    </body>
</html>
</f:view>