<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    
    <style type="text/css">
    
    
   
    body {
        font-family: 'Roboto', sans-serif;
        background-color: #f8f9fa;
        
        background-image: url('edt.jpg');
        text-align: center;
        margin: 0;
        padding: 0;
    }

    h2 {
        color: cornsilk;
        margin-bottom: 30px;
        font-weight: bold;
        margin-top: 20px;
    }

    #form {
        max-width: 600px;
        margin: 0 auto;
        padding: 20px;
       background-color: rgba(245, 245, 245, 0.8);	
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        height: 321px;
        
         
            
    }
    
    .inpbox{
     border: 2px solid red;
  border-radius: 4px;
    }

    .form-group,
    .form-group2 {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-bottom: 20px;
    }

    .form-group label,
    .form-group2 label {
        margin-bottom: 8px;
        font-weight: bold;
        color: #007bff;
    }

    .form-group select,
    .form-group2 select,
    .form-group input,
    .form-group2 input {
        width: 19%%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ced4da;
        border-radius: 4px;
        box-sizing: border-box;
        display: inline-block;
        background-color: #f8f9fa;
        color: #495057;
    }

    .form-group select:hover,
    .form-group2 select:hover,
    .form-group input:hover,
    .form-group2 input:hover {
        border-color: #007bff;
    }

    .save-button {
        background-color: #28a745;
        color: #fff;
        padding: 12px 24px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s;
            margin: 41px;
    }

    .save-button:hover {
        background-color: #218838;
    }

    .save-button:active {
        background-color: #1e7e34;
    }

    /* Add more styles as needed */
    
		
		
 
    
    /* Style for the datepicker container */
    .ui-datepicker {
        font-size: 14px; /* Set the font size */
    }
 
    /* Style for the datepicker header */
    .ui-datepicker-header {
        background-color: #4c5daf; /* Set the background color */
        color: white; /* Set the text color */
        border: none; /* Remove the border */
    }
 
    /* Style for the title in the header */
    .ui-datepicker-title {
        font-weight: bold; /* Make the title bold */
    }
 
    /* Style for the datepicker calendar */
    .ui-datepicker-calendar {
        background-color: #f0f0f0; /* Set the background color for the calendar */
        border: 1px solid #ccc; /* Add a border */
        border-radius: 4px; /* Add border radius */
        padding: 2px; /* Add some padding */
    }
 
    /* Style for the datepicker days */
    .ui-datepicker-calendar td {
        padding: 1px; /* Add some padding to the individual days */
        border: 3px solid #ddd; /* Add border to create grid lines */
    }
 
    /* Style for the selected date */
    .ui-datepicker-calendar .ui-state-highlight {
        background-color: #20ad2b; /* Set the background color for the selected date */
        color: white; /* Set the text color for the selected date */
    }
 
    /* Style for the datepicker input field */
    .datepicker {
        padding: 5px; /* Add some padding */
        border: 2px solid #577b97;; /* Add a border */
        border-radius: 4px; /* Add border radius */
        margin-right: -22px;
    }
 
    /* Style for the previous and next month buttons */
    .ui-datepicker-prev,
    .ui-datepicker-next {
        background-color: #3a408f; /* Set the background color for the buttons */
        color: white; /* Set the text color for the buttons */
        border: none; /* Remove the border */
        padding: 0px 10px; /* Add padding */
        border-radius: 4px; /* Add border radius */
        cursor: pointer; /* Change cursor to pointer on hover */
    }
 
</style>
    

    </head>
    <body>
        <h2>
            <h:outputText value="Edit Insurance" />
        </h2>
        
         <!-- DatePicker JavaScript & CSS -->
    <!-- references to external JavaScript libraries (jQuery and jQuery UI) to enable datepicker functionality. -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	
	<script>
 
	$(document).ready(function() {
		$( ".datepicker" ).datepicker({
			dateFormat: 'yy-mm-dd',  <!--set the date format-->
			changeMonth: true,   <!--  allows users to change the month -->
			changeYear: true,  <!--  allows users to change the year -->
			yearRange: "1960:2060"  <!--restrict the selectable yrs -->
		});
	});
        
        
        </script>
        
        
        <h:form id="form">
           <div class="form-group">
    <h:outputText value="Types" />
    <h:selectOneMenu value="#{insuranceFound.type}">
        <f:selectItem itemValue="Government" itemLabel="Government" />
        <f:selectItem itemValue="Private" itemLabel="Private" />
    </h:selectOneMenu>

    <h:outputText value="Status" />
    <h:selectOneMenu value="#{insuranceFound.status}">
        <f:selectItem itemValue="Active" itemLabel="Active" />
        <f:selectItem itemValue="Pending" itemLabel="Pending" />
    </h:selectOneMenu>
</div>



    <h:outputText value="Premium Start" />
    <h:inputText id="pstart" value="#{insuranceFound.premiumStart}"  styleClass="form-control datepicker">
        <f:convertDateTime pattern="yyyy-MM-dd"/>
    </h:inputText>

		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <h:outputText value="Premium End"/>
    <h:inputText id="pend" value="#{insuranceFound.premiumEnd}"  styleClass="form-control datepicker">
        <f:convertDateTime pattern="yyyy-MM-dd"/>
    </h:inputText>
    
 
           
            <h:messages/>
         <br><br>
            <h:commandButton id="addbutton" action="#{insuranceDetailsdao.UpdateInsurance(insuranceFound)}" value="Save Changes" styleClass="save-button"/>
        </h:form>
    </body>
    </html>
</f:view>
