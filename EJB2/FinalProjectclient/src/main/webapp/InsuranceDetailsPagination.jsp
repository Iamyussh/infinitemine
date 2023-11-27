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

body {
    font-family: Arial, sans-serif;
    background-color: #272728;
    margin: 0;
    padding: 0;
    background-image: url('table.jpg'); /* Replace 'your-image-url.jpg' with the path to your background image */
    background-size: cover; /* Ensure the background image covers the entire body */
    background-position: center; /* Center the background image */
}
                .my-form {
            max-width: 400px;
            margin: 20px auto;
        }

        h1 {
            text-align: center;
            background-color: #333;
            color: #fff;
            padding: 10px;
        }

        h2 {
        	margin-top: 40px;
            text-align: center;
        }
        a {
        	color: black;
        }


/* Styles for the DataTable */
.my-datatable {
    width: 100%;
    border-collapse: collapse;
    margin-top: 70px;
}

.my-datatable th {
    background-color: #f2f2f2;
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}


.my-datatable td {
    padding: 10px;
    border-bottom: 1px solid #ddd;
}

.my-datatable tbody tr:hover {
    background-color: #e0e0e0;
}

/* Styles for the button */
.my-button {
    display: inline-block;
    padding: 10px 20px;
    font-size: 16px;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border: 1px solid #3498db;
    color: #3498db;
    background-color: #ffffff;
    border-radius: 5px;
    transition: background-color 0.3s, color 0.3s, border-color 0.3s;
}

/* Additional styles for button */
.my-button-container {
    margin-top: 20px;
    text-align: center;
}

.my-button-container .my-button {
    margin-right: 10px;
}
.my-button:hover {
    background-color: olive;
    color: #ffffff;
    transform: scale(1.1); /* Adjust the scale factor as needed */
    box-shadow:0 2px 4px rgba(0,0,0,0.2);
}

.page-title {
    color: #141416; /* Set the color for the title */
    font-size: 24px; /* Set the font size */
    font-weight: bold; /* Set the font weight */
    padding: 15px; /* Add padding for better visual appearance */
    border: 4px solid #ddd; /* Increase the border width */
    background-color: #f9f9f9; /* Set a light background color */
        border-radius: 60px;
    /* Add more styles as needed */
}




    </style>
    </head>
    <body>
   
        <h:form>
        <center>
                <h2><h:outputText value="Insurance Details" styleClass="page-title"/></h2>
            </center>
        <h:dataTable value="#{paginationDao.getInsuranceList()}" var="e" border="1" styleClass="my-datatable">
        	    <h:column>
                    <f:facet name="header">
   		 <h:commandLink action="#{insuranceDetailsdao.sortorderById()}"  style="text-decoration:none">
      		  <h:outputLabel value="Insurance Id"  />
      		  </h:commandLink>
    		</f:facet>
                    <h:commandLink action="#{insuranceDetailsdao.searchInsuranceDetails(e.insuranceId)}" value="#{e.insuranceId}"  style="text-decoration:none" />
                    
                </h:column>
                
                
                   <h:column>
   		 <f:facet name="header">
   		 <h:commandLink action="#{insuranceDetailsdao.sortByinsuranceName()}" style="text-decoration:none">
      		  <h:outputLabel value="Insurance Name" />
      		  </h:commandLink>
    		</f:facet>
    		
        <h:outputText value="#{e.insuranceName}" />
    		
			</h:column>
                
                
                 <h:column>
                     <f:facet name="header">
   		 <h:commandLink action="#{insuranceDetailsdao.sortorderByType()}" style="text-decoration:none">
      		  <h:outputLabel value="Type" />
      		  </h:commandLink>
    		</f:facet>
                    <h:outputText value="#{e.type}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
   		 <h:commandLink action="#{insuranceDetailsdao.sortorderByPstart()}" style="text-decoration:none">
      		  <h:outputLabel value="Premium Start" />
      		  </h:commandLink>
    		</f:facet>
                    <h:outputText value="#{e.premiumStart}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
   		 <h:commandLink action="#{insuranceDetailsdao.sortorderByPend()}" style="text-decoration:none">
      		  <h:outputLabel value="Premium End" />
      		  </h:commandLink>
    		</f:facet>
                    <h:outputText value="#{e.premiumEnd}"/>
                </h:column>
                 
                
                 <h:column>
                     <f:facet name="header">
   		 <h:commandLink action="#{insuranceDetailsdao.sortorderByldate()}" style="text-decoration:none">
      		  <h:outputLabel value="Launch Date" />
      		  </h:commandLink>
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
					<h:outputLabel value="Show Plans" />
				</f:facet>
				<h:commandButton action="#{insurancePlansdao.redirectToInsurancePlan(e.insuranceId)}" value="show plans" styleClass="my-button"/>
			</h:column>
        </h:dataTable>
        <br/><br/>
        
         <center>
         <!--The paging buttons-->
            <h:commandButton value="first" action="#{paginationDao.pageFirst}"
                             disabled="#{paginationDao.firstRow == 0}" styleClass="my-button"/>
            <h:commandButton value="prev" action="#{paginationDao.pagePrevious}"
                             disabled="#{paginationDao.firstRow == 0}" styleClass="my-button" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="next" action="#{paginationDao.pageNext}"
                             disabled="#{paginationDao.firstRow + paginationDao.rowsPerPage >= paginationDao.totalRows}" styleClass="my-button" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="last" action="#{paginationDao.pageLast}"
                             disabled="#{paginationDao.firstRow + paginationDao.rowsPerPage >= paginationDao.totalRows}" styleClass="my-button"/>
            
            <h:outputText value="Page #{paginationDao.currentPage} / #{paginationDao.totalPages}" styleClass="my-button" />
            <br />
            
            </center>
            
            <br/><br/>
        <center>
        <h:commandButton action="AddPlan.jsp" value="Add a plan" styleClass="my-button"/><br><br>
        <h:commandButton action="ExistingPlans.jsp" value="Add subplan in existing plans" styleClass="my-button"/>
        
        </center>
        </h:form>
    </body>
</html>
</f:view>