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
                <h2><h:outputText value="Customer Detail Records"/></h2>
            </center>
        <h:dataTable value="#{paginationDao.getcustomerDetailsList()}" var="e" border="3">
        	    <h:column>
				<f:facet name="header">
					<h:outputLabel value="Customer Id" />
				</f:facet>
				<h:outputText value="#{e.custId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="First Name" />
				</f:facet>
				<h:outputText value="#{e.firstName}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Last Name" />
				</f:facet>
				<h:outputText value="#{e.lastName}" />
			</h:column>
			
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Gender" />
				</f:facet>
				<h:outputText value="#{e.gender}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Username" />
				</f:facet>
				<h:outputText value="#{e.userName}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="email" />
				</f:facet>
				<h:outputText value="#{e.email}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Date of Birth" />
				</f:facet>
				<h:outputText value="#{e.dateofbirth}" />
			</h:column>
        </h:dataTable>
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
            <!-- Set rows per page -->
            <h:outputLabel for="rowsPerPage" value="Rows per page" />
            <h:inputText id="rowsPerPage" value="#{paginationDao.rowsPerPage}" size="3" maxlength="3" />
            <h:commandButton value="Set" action="#{paginationDao.pageFirst}" />
            <h:message for="rowsPerPage" errorStyle="color: red;" />
        </h:form>
    </body>
</html>
</f:view>
