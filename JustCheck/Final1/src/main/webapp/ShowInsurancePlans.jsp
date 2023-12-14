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
    font-family: 'lato', sans-serif;
    background-image: url('show.jpg');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    background-color: #f2f2f2;
    margin: -89px;
    padding: 0;
    margin-right: -147px;
}

center {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
}

h2 {
    color: #007bff;
    margin-bottom: 10px;
}

h:form {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.

h:column {
    padding: 20px;
    border-bottom: 1px solid #ddd;
}

h:column th {
    background-color: #555; /* Darker background color for table header */
    color: #fff; /* Text color for table header */
    padding: 20px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

h:column td:hover {
    background-color: #444; /* Darker background color on hover */
}

/* Rest of your styles... */

                
                
           tab {
    border-collapse: collapse;
    margin-top: 250px;
    
    border-collapse: separate;
    
    margin-top: 20px;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
    border-radius: 10px;
    overflow: hidden;
    
    font-size: 16px; /* Set your desired font size */
    color: #fff; /* Text color for table */
}

.tab th, .tab td {
    padding: 10px;
    border-bottom: 1px solid ;
}



.tab td:hover {
    background-color: #80abe0; /* Darker background color on hover */
}

/* HTML: <div class="loader"></div> */
.loader {
  width: 50px;
  aspect-ratio: 1;
  display: grid;
  border: 4px solid #0000;
  border-radius: 50%;
  border-color: #ccc #0000;
  animation: l16 1s infinite linear;
}
.loader::before,
.loader::after {    
  content: "";
  grid-area: 1/1;
  margin: 2px;
  border: inherit;
  border-radius: 50%;
}
.loader::before {
  border-color: #f03355 #0000;
  animation: inherit; 
  animation-duration: .5s;
  animation-direction: reverse;
}
.loader::after {
  margin: 8px;
}
@keyframes l16 { 
  100%{transform: rotate(1turn)}
}
                
                
                
</style>

</head>
<body>
	<h:form>
		<center>
		
		<div class="loader"></div>
		<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
		<script>
    // Add this script to toggle the loader on form submission
    $(document).ready(function() {
			$(".loader").fadeOut("slow");
		});
     $(window).on('load', function() {
        $(".loader").fadeOut("very slow");
    });
		</script>
			<h2>
				<h:outputText value="Insurance Plans" />
			</h2>
		<h:dataTable value="#{insurancePlansdao.showPlans(insuranceid)}" var="e"
			border="3" styleClass="tab">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Plan id" />
				</f:facet>
				<h:outputText value="#{e.planid}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance id" />
				</f:facet>
				<h:outputText value="#{e.insuranceid}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Premium Amount" />
				</f:facet>
				<h:outputText value="#{e.premiumamt}" />
			</h:column>
			
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Coverage Amount" />
				</f:facet>
				<h:outputText value="#{e.coverageamt}" />
			</h:column>
			
			
			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Diseases Covered" />
				</f:facet>
				<h:outputText value="#{e.discov}" />
			</h:column>
			
			
			
		
			</h:dataTable>
			
			
		</center>
	</h:form>
</body>
	</html>
</f:view>