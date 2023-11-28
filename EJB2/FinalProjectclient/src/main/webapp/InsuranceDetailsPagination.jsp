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
        border-radius: 19px;
    /* Add more styles as needed */
}

		.loader-container {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background: rgba(255, 255, 255, 0.8);
                display: flex;
                justify-content: center;
                align-items: center;
                z-index: 1000;
            }

            .loader {
                border: 8px solid #f3f3f3;
                border-top: 8px solid #3498db;
                border-radius: 50%;
                width: 50px;
                height: 50px;
                animation: spin 3s linear infinite;
            }

            @keyframes spin {
                0% { transform: rotate(0deg); }
                100% { transform: rotate(360deg); }
            }
		
		
	
			
			.lds-hourglass {
  display: inline-block;
  position: relative;
  width: 80px;
  height: 80px;
}
.lds-hourglass:after {
  content: " ";
  display: block;
  border-radius: 50%;
  width: 0;
  height: 0;
  margin: 8px;
  box-sizing: border-box;
  border: 32px solid #fff;
  border-color: #fff transparent #fff transparent;
  animation: lds-hourglass 1.2s infinite;
}
@keyframes lds-hourglass {
  0% {
    transform: rotate(0);
    animation-timing-function: cubic-bezier(0.55, 0.055, 0.675, 0.19);
  }
  50% {
    transform: rotate(900deg);
    animation-timing-function: cubic-bezier(0.215, 0.61, 0.355, 1);
  }
  100% {
    transform: rotate(1800deg);
  }
}
			



    </style>
    </head>
    <body>
    
    	<div class="lds-hourglass"></div>
   
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
        
        
        
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    // Add this script to toggle the loader on form submission
     $(window).on('load', function() {
        $(".lds-hourglass").fadeOut("very slow");
    });


    
</script>
    </body>
</html>
</f:view>