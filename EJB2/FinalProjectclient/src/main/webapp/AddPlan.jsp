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
                 background-image: url('add1.jpg'); /* Set the path to your background image */
                background-size: cover; /* Ensures the background image covers the entire viewport */
                background-position: center; /* Centers the background image */
                background-repeat: no-repeat; /* Prevents the background image from repeating */
                text-align: center;
                background-color: #f8f9fa;
                text-align: center;
                margin: 0;
                padding: 0;
            }

            h1 {
                color: #007bff;
                margin-bottom: 30px;
                 font-weight: bold; /* Make the heading bold */
    			
                
                
            }

            center {
                text-align: center;
            }

            #form {
                max-width: 600px;
                margin: 0 auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            label {
                display: inline-block;
                width: 150px; /* Adjust the width as needed */
                margin-bottom: 8px;
                font-weight: bold;
            }

            input,
            select {
                width: 50%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ced4da;
                border-radius: 4px;
                box-sizing: border-box;
            }

            select {
                appearance: none;
                background: url('https://cdn.jsdelivr.net/gh/GoogleWebComponents/google-web-components/google-logo.png') no-repeat right 10px center;
                background-size: 20px;
            }

            .addbutton {
                background-color: #28a745;
                color: #fff;
                padding: 12px 24px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
                transition: background-color 0.3s;
                margin-top: 10px;
            }

            .addbutton:hover {
                background-color: #218838;
                color: #fff;
            }

            .addbutton:active {
                background-color: #1e7e34;
            }
        </style>
    </head>
    <body>
        <center>
            <br/>
            <h1>
                <h:outputText value="Create a new plan" />
            </h1>
            
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
                <div id="form">
                    <label for="iname">Insurance name</label>
                    <h:inputText id="iname" value="#{insuranceDetails.insuranceName}" />
                    <br /><br />

                    <label for="type">Types</label>
                    <h:selectOneMenu id="type" value="#{insuranceDetails.type}">
                        <f:selectItem itemValue="Government" itemLabel="Government" />
                        <f:selectItem itemValue="Private" itemLabel="Private" />
                    </h:selectOneMenu>
                    <br/><br/>

                    <label for="pstart">Premium Start</label>
                    <h:inputText id="pstart" value="#{insuranceDetails.premiumStart}">
                        <f:convertDateTime pattern="yyyy-MM-dd"/>
                    </h:inputText>
                    <br /><br />

                    <label for="pend">Premium End</label>
                    <h:inputText id="pend" value="#{insuranceDetails.premiumEnd}">
                        <f:convertDateTime pattern="yyyy-MM-dd"/>
                    </h:inputText>
                    <br /><br />

                    <label for="ldate">Launch Date</label>
                    <h:inputText id="ldate" value="#{insuranceDetails.launchDate}" styleClass="form-control datepicker">
                        <f:convertDateTime pattern="yyyy-MM-dd"/>
                    </h:inputText>
                    <br /><br />

                    <label for="status">Status</label>
                    <h:selectOneMenu id="status" value="#{insuranceDetails.status}">
                        <f:selectItem itemValue="Active" itemLabel="Active" />
                        <f:selectItem itemValue="Pending" itemLabel="Pending" />
                    </h:selectOneMenu>

                    <br><br>
                </div>
                <h:commandButton styleClass="addbutton" action="#{insuranceController.addInsurance(insuranceDetails)}" value="Add a plan"/>
            </h:form>
        </center>
        <h:messages />
    </body>
    </html>
</f:view>

