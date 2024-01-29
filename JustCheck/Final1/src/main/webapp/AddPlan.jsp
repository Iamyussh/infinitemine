<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html xmlns="http://www.w3.org/1999/xhtml"
		xmlns:h="http://xmlns.jcp.org/jsf/html"
		xmlns:pt="http://xmlns.jcp.org/jsf/passthrough">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style type="text/css">
body {
	font-family: 'Roboto', sans-serif;
	background-image: url('add1.jpg');
	/* Set the path to your background image */
	background-size: cover;
	/* Ensures the background image covers the entire viewport */
	background-position: center; /* Centers the background image */
	background-repeat: no-repeat;
	/* Prevents the background image from repeating */
	text-align: center;
	background-color: #f8f9fa;
	text-align: center;
	margin: 0;
	padding: 0;
}

h1 {
	color: #2c0981;
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

input, select {
	width: 50%;
	padding: 7px;
	margin-bottom: 15px;
	border: 1px solid #ced4da;
	border-radius: 4px;
	box-sizing: border-box;
}

select {
	appearance: none;
	background:
		url('https://cdn.jsdelivr.net/gh/GoogleWebComponents/google-web-components/google-logo.png')
		no-repeat right 10px center;
	background-size: 20px;
	font-weight: 900;
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
	width: 120px;
}

.backbutton {
	background-color: #28a745;
	color: #fff;
	padding: 11px 24px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
	transition: background-color 0.3s;
	margin-top: 10px;
	width: 80px;
	margin-left: 130px;
}

.addbutton:hover {
	background-color: #218838;
	color: #fff;
}

.addbutton:active {
	background-color: #1e7e34;
}

/* Style for the datepicker container */
.ui-datepicker {
	font-size: 14px; /* Set the font size */
}

/* Style for the datepicker header */
.ui-datepicker-header {
	background-color: #48a958; /* Set the background color */
	color: white; /* Set the text color */
	border: none; /* Remove the border */
	margin-left: 280px;
	margin-top: -26px;
}

/* Style for the title in the header */
.ui-datepicker-title {
	font-weight: bold; /* Make the title bold */
	color: black;
}

/* Style for the datepicker calendar */
.ui-datepicker-calendar {
	background-color: #f0f0f0;
	/* Set the background color for the calendar */
	border: 1px solid #ccc; /* Add a border */
	border-radius: 4px; /* Add border radius */
	padding: 2px; /* Add some padding */
	margin-left: 280px;
}

/* Style for the datepicker days */
.ui-datepicker-calendar td {
	padding: 1px; /* Add some padding to the individual days */
	border: 1px solid #ddd; /* Add border to create grid lines */
}

/* Style for the selected date */
.ui-datepicker-calendar .ui-state-highlight {
	background-color: #20ad2b;
	/* Set the background color for the selected date */
	color: white; /* Set the text color for the selected date */
}

/* Style for the datepicker input field */
.datepicker {
	padding: 5px; /* Add some padding */
	border: 1px solid #ccc; /* Add a border */
	border-radius: 4px; /* Add border radius */
	color: #141010;
}

.ui-datepicker-month {
	color: black;
	font-weight: bold;
	padding-left: 14px;
	width: 56px;
	font-weight: bold;
}

.ui-datepicker-year {
	color: black;
	font-weight: bold;
	padding-left: 14px;
	width: 56px;
	font-weight: bold;
}

/* Style for the previous and next month buttons */
.ui-datepicker-prev, .ui-datepicker-next {
	background-color: #8f6d3a;
	/* Set the background color for the buttons */
	color: white; /* Set the text color for the buttons */
	border: none; /* Remove the border */
	padding: 0px 10px; /* Add padding */
	border-radius: 4px; /* Add border radius */
	cursor: pointer; /* Change cursor to pointer on hover */
}

.eror {
	color: red;
}

/* HTML: <div class="loader"></div> */
.loader {
	margin-left: 628px;
	width: 60px;
	aspect-ratio: 1;
	background: linear-gradient(45deg, #60B99A 50%, #0000 0),
		linear-gradient(45deg, #0000 50%, #60B99A 0),
		linear-gradient(-45deg, #f77825 50%, #0000 0),
		linear-gradient(-45deg, #0000 50%, #f77825 0),
		linear-gradient(#554236 0 0);
	background-size: 50% 50%;
	background-repeat: no-repeat;
	animation: l18 1.5s infinite;
}

a {
	text-decoration: none;
}

@
keyframes l18 { 0% {
	background-position: 50% 50%, 50% 50%, 50% 50%, 50% 50%, 50% 50%
}



</style>


</head>
<body>




	<br />
	<h1>
		<h:outputText value="Create a new plan" />
	</h1>




	<div class="loader"></div>



	<h:form id="form">

		<center>
			<!-- DatePicker JavaScript & CSS -->
			<!-- references to external JavaScript libraries (jQuery and jQuery UI) to enable datepicker functionality. -->
			<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.12.4.js"></script>
			<script type="text/javascript"
				src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

			<script>
 
	$(document).ready(function() {
		$( ".datepicker" ).datepicker({
			dateFormat: 'yy-mm-dd',  <!--set the date format-->
			changeMonth: true,   <!--  allows users to change the month -->
			changeYear: true,  <!--  allows users to change the year -->
			yearRange: "1960:2060"  <!--restrict the selectable yrs -->
		
		});
	});

	$(document).ready(function() {
		$(".loader").fadeOut("slow");
	});
 $(window).on('load', function() {
    $(".loader").fadeOut("very slow");
});

	
	</script>
			<div id="form">
				<label for="iname">Insurance name</label>
				<h:inputText id="iname" value="#{insuranceDetails.insuranceName}"
					autocomplete="off" />

				<br />
				<h:message for="iname" styleClass="eror" />
				<br />

				<h:outputLabel for="ptype">Plan types</h:outputLabel>
				<h:selectOneMenu id="type" value="#{insuranceDetails.type}">
					<f:selectItem itemLabel="Select type" itemValue="" />
					<f:selectItem itemValue="Government" itemLabel="Government" />
					<f:selectItem itemValue="Private" itemLabel="Private" />
				</h:selectOneMenu>
				<br />
				<h:message for="type" styleClass="eror" />
				<br />
				<h:outputLabel for="pstart">Premium Start</h:outputLabel>
				<h:inputText id="pstart" value="#{insuranceDetails.premiumStart}"
					styleClass="form-control datepicker" autocomplete="off">
					<f:convertDateTime pattern="yyyy-MM-dd" />
				</h:inputText>
				<br />

				<h:message for="pstart" styleClass="eror" />
				<br />

				<h:outputLabel for="pend">Premium End</h:outputLabel>
				<h:inputText id="pend" value="#{insuranceDetails.premiumEnd}"
					styleClass="form-control datepicker" autocomplete="off">
					<f:convertDateTime pattern="yyyy-MM-dd" />
				</h:inputText>
				<br />


				<h:message for="pend" styleClass="eror" />
				<br /> <label for="ldate">Launch Date</label>
				<h:inputText id="ldate" value="#{insuranceDetails.launchDate}"
					styleClass="form-control datepicker" autocomplete="off">
					<f:convertDateTime pattern="yyyy-MM-dd" />
				</h:inputText>
				<br />
				<h:message for="ldate" styleClass="eror" />
				<br />
				<h:outputLabel for="status">Status</h:outputLabel>
				<h:selectOneMenu id="status" value="#{insuranceDetails.status}">
					<f:selectItem itemLabel="Select Status" itemValue="" />
					<f:selectItem itemValue="Active" itemLabel="Active" />
					<f:selectItem itemValue="Pending" itemLabel="Pending" />
				</h:selectOneMenu>


				<br>
				<h:message for="status" styleClass="eror" />
				<br>
			</div>
			<h:commandButton styleClass="addbutton"
				action="#{insuranceController.addInsurance(insuranceDetails)}"
				value="Add a plan" onclick="showLoader()"
				title="Click to add a plan" />

			<h:commandButton styleClass="backbutton"
				action="InsuranceDetailsPagination.jsp" value="Back"
				onclick="showLoader()" />
		</center>
	</h:form>




</body>
	</html>
</f:view>


