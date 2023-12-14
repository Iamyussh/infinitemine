<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 


<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <!-- references to external JavaScript libraries (jQuery and jQuery UI) to enable datepicker functionality. -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <style>
        
        html{
        
        background : rgb{2.0,36};
        
        
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            
              background-image: url('.jpg'); /* Set the path to your background image */
                background-size: cover; /* Ensures the background image covers the entire viewport */
                background-position: center; /* Centers the background image */
                background-repeat: no-repeat; 
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
            color: #383732;
    		margin-top: 20px;
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

      

        .dataTableContainer .commandButtons {
            text-align: center;
        }
		
        
        
   .add-plan{
    background-color: #6e86a1;
    color: #fff;
    padding: 8px 11px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s;
}
.add-plan:hover {
    background-color: #3b403d;
}

.go-to-details-button:hover {
    background-color: #0056b3;
}

.go-to-details-button{
	  background-color: #6e86a1;
    color: #fff;
    padding: 12px 24px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s;
    margin-top: 90px;

}
.page-button:hover {
    background-color: #0056b3;
}

.page-button{
	  background-color: #6e86a1;
    color: #fff;
   	padding: 5px 13px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s;
    
    

}
	
	/* HTML: <div class="loader"></div> */
.loader {
  height: 60px;
  aspect-ratio: 1;
  position: relative;
 margin-left: 600px;
}
.loader::before,
.loader::after {
  content: "";
  position: absolute;
  inset: 0;
  border-radius: 50%;
  transform-origin: bottom;
}
.loader::after {
  background:
    radial-gradient(at 75% 15%,#fffb,#0000 35%),
    radial-gradient(at 80% 40%,#0000,#0008),
    radial-gradient(circle  5px,#fff 94%,#0000),
    radial-gradient(circle 10px,#000 94%,#0000),
    linear-gradient(#F93318 0 0) top   /100% calc(50% - 5px),
    linear-gradient(#fff    0 0) bottom/100% calc(50% - 5px)
    #000;
  background-repeat: no-repeat;
  animation: l20 1s infinite cubic-bezier(0.5,120,0.5,-120);
}
.loader::before {
  background:#ddd;
  filter: blur(8px);
  transform: scaleY(0.4) translate(-13px, 0px);
}
@keyframes l20 { 
 30%,70% {transform:rotate(0deg)}
 49.99%  {transform:rotate(0.2deg)}
 50%     {transform:rotate(-0.2deg)}
}





    
    
   
		
		
    </style>
    </head>
    <body>
   		<div class="loader"></div>
   			
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
				<h:commandButton action="#{insurancePlansdao.redirectToAddSubplan(e.insuranceId)}" value="Add plans" styleClass="add-plan" />
			</h:column>
			
			
        </h:dataTable>
        
        
        
       
         <!--The paging buttons-->
            <h:commandButton value="first" action="#{paginationDao.pageFirst}"
                             disabled="#{paginationDao.firstRow == 0}" styleClass="page-button"/>
            <h:commandButton value="prev" action="#{paginationDao.pagePrevious}"
                             disabled="#{paginationDao.firstRow == 0}" styleClass="page-button"/>
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="next" action="#{paginationDao.pageNext}"
                             disabled="#{paginationDao.firstRow + paginationDao.rowsPerPage >= paginationDao.totalRows}" styleClass="page-button"/>
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="last" action="#{paginationDao.pageLast}"
                             disabled="#{paginationDao.firstRow + paginationDao.rowsPerPage >= paginationDao.totalRows}" styleClass="page-button"/>
            <h:outputText value="&nbsp;" escape="false"/>
            <h:outputText value="Page #{paginationDao.currentPage} / #{paginationDao.totalPages}" />
            <br />
         
             <center>
       <h:commandButton action="InsuranceDetailsPagination.jsp" value="Go to insurance details" styleClass="go-to-details-button" /><br><br>
        
        </center>	
        </h:form>
        
       
        
       
    </body>
   		
   			<script>
    // Add this script to toggle the loader on form submission
    $(document).ready(function() {
			$(".loader").fadeOut("slow");
		});
     $(window).on('load', function() {
        $(".loader").fadeOut("very slow");
    });
		</script>
</html>
</f:view>