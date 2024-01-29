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
	font-family: Poppins serif;
	background-color: #272728;
	margin: 0;
	padding: 0;
	background-image: url('ins.jpg');
	/* Replace 'your-image-url.jpg' with the path to your background image */
	background-size: cover;
	/* Ensure the background image covers the entire body */
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
	cursor: default;
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

.colum {
	background-color: blue;
}

.my-datatable tbody tr:hover {
	background-color: #e0e0e0;
}

/* Styles for the button */
.my-button {
	display: inline-block;
	padding: 4px 18px;
	margin-right: -5;
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
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

.page-title {
	color: #141416; /* Set the color for the title */
	font-size: 24px; /* Set the font size */
	font-weight: bold; /* Set the font weight */
	padding: 13px; /* Add padding for better visual appearance */
	border: 4px solid #ddd; /* Increase the border width */
	background-color: #f9f9f9; /* Set a light background color */
	border-radius: 19px;
	margin-left: -18px;
	/* Add more styles as needed */
}

/* HTML: <div class="loader"></div> */
.loader {
	width: 100px;
	height: 45px;
	position: relative;
	margin-top: 30px;
	margin-left: 575px;
}

.loader:before, .loader:after {
	content: "";
	position: absolute;
	inset: 0;
	background: #000;
	box-shadow: 0 0 0 50px;
	clip-path: polygon(-50px -20px, 10% -12px, 20% 0, calc(50% - 15px) 0,
		calc(50% - 10px) -20px, calc(50% - 8px) -15px, calc(50% + 8px) -15px,
		calc(50% + 10px) -20px, calc(50% + 15px) 0, 80% 0, 90% -12px,
		calc(100% + 50px) -20px, 100% 80%, calc(100% + 10px) calc(100% + 10px),
		60% 100%, 50% calc(100% + 15px), 40% 100%, -10px calc(100% + 10px), 0
		80%);
}

.loader:after {
	animation: l9 1s infinite;
	transform: perspective(300px) translateZ(0px)
}

@
keyframes l9 {
	to {transform: perspective(300px) translateZ(100px);
	opacity: 0
}

}

/* Add this to your CSS stylesheet */
.arrow:hover {
	color: white; /* Change this to your preferred hover color */
	cursor: pointer;
}

.type-text:hover {
	text-decoration: underline;
	/* You can customize the underline style or remove it */
	cursor: pointer;
}

.insid {
	display: inline-block;
	padding: 4px 18px;
	margin-right: -5;
	font-size: 16px;
	text-align: center;
	text-decoration: none;
	cursor: pointer;
	border: 1px solid #3498db;
	color: black;
	background-color: #ffffff;
	border-radius: 5px;
	transition: background-color 0.3s, color 0.3s, border-color 0.3s;
}
</style>
</head>
<body>

	<div class="loader"></div>

	<h:form>
		<center>
			<h2>
				<h:outputText value="Insurance Details" styleClass="page-title" />
			</h2>
		</center>
		<h:dataTable value="#{paginationDao.getInsuranceList()}" var="e"
			border="2" styleClass="my-datatable">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance Id">
						<h:commandLink action="#{insuranceDetailsdao.sortorderById()}"
							style="text-decoration:none">
							<div style="display: inline-flex;">
								<p class="arrow">&#x25B2;</p>
								&nbsp;
								<p class="arrow">&#x25BC;</p>
							</div>
						</h:commandLink>
					</h:outputLabel>
				</f:facet>

				<h:commandButton
					action="#{insuranceDetailsdao.searchInsuranceDetails(e.insuranceId)}"
					value="#{e.insuranceId}" style="text-decoration:none"
					styleClass="insid" />


			</h:column>


			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance Name">
						<h:commandLink
							action="#{insuranceDetailsdao.sortByinsuranceName()}"
							style="text-decoration:none">
							<div style="display: inline-flex;">
								<p class="arrow">&#x25B2;</p>
								&nbsp;
								<p class="arrow">&#x25BC;</p>
							</div>
						</h:commandLink>
					</h:outputLabel>
				</f:facet>

				<h:outputText value="#{e.insuranceName}" />

			</h:column>


			<h:column>
				<f:facet name="header">
					<h:commandLink action="#{insuranceDetailsdao.sortorderByType()}"
						style="text-decoration:none">

						<h:outputLabel value="Type" />
						<div style="display: inline-flex;">
							<p class="arrow">&#x25B2;</p>
							<p class="arrow">&#x25BC;</p>
						</div>
					</h:commandLink>
				</f:facet>
				<h:outputText value="#{e.type}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:commandLink action="#{insuranceDetailsdao.sortorderByPstart()}"
						style="text-decoration:none">
						<h:outputLabel value="Premium Start" />
      		    &nbsp; &nbsp;<div style="display: inline-flex;">
							<p class="arrow">&#x25B2;</p>
							&nbsp;
							<p class="arrow">&#x25BC;</p>
						</div>
					</h:commandLink>
				</f:facet>
				<h:outputText value="#{e.premiumStart}" />

			</h:column>
			<h:column>
				<f:facet name="header">
					<h:commandLink action="#{insuranceDetailsdao.sortorderByPend()}"
						style="text-decoration:none">
						<h:outputLabel value="Premium End" />
      		    &nbsp; &nbsp;<div style="display: inline-flex;">
							<p class="arrow">&#x25B2;</p>
							&nbsp;
							<p class="arrow">&#x25BC;</p>
						</div>
					</h:commandLink>
				</f:facet>
				<h:outputText value="#{e.premiumEnd}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:commandLink action="#{insuranceDetailsdao.sortorderByldate()}"
						style="text-decoration:none">
						<h:outputLabel value="Launch Date" />
						<div style="display: inline-flex;">
							<p class="arrow">&#x25B2;</p>
							&nbsp;
							<p class="arrow">&#x25BC;</p>
						</div>
					</h:commandLink>
				</f:facet>
				<h:outputText value="#{e.launchDate}" />
			</h:column>


			<h:column>
				<f:facet name="header">
					<h:commandLink action="#{insuranceDetailsdao.sortorderBystatus()}"
						style="text-decoration:none">
						<h:outputLabel value="Status" />
						<div style="display: inline-flex;">
							<p class="arrow">&#x25B2;</p>
							&nbsp;
							<p class="arrow">&#x25BC;</p>
						</div>
					</h:commandLink>
				</f:facet>
				<h:outputText value="#{e.status}" />
			</h:column>



			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Show Plans" />
				</f:facet>
				<h:commandButton
					action="#{insurancePlansdao.redirectToInsurancePlan(e.insuranceId)}"
					value="show plans" styleClass="my-button" />
			</h:column>
		</h:dataTable>
		<br />
		<br />

		<center>
			<!--The paging buttons-->
			<h:commandButton value="first" action="#{paginationDao.pageFirst}"
				disabled="#{paginationDao.firstRow == 0}" styleClass="my-button" />
			<h:commandButton value="prev" action="#{paginationDao.pagePrevious}"
				disabled="#{paginationDao.firstRow == 0}" styleClass="my-button" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:commandButton value="next" action="#{paginationDao.pageNext}"
				disabled="#{paginationDao.firstRow + paginationDao.rowsPerPage >= paginationDao.totalRows}"
				styleClass="my-button" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:commandButton value="last" action="#{paginationDao.pageLast}"
				disabled="#{paginationDao.firstRow + paginationDao.rowsPerPage >= paginationDao.totalRows}"
				styleClass="my-button" />

			<h:outputText
				value="Page #{paginationDao.currentPage} / #{paginationDao.totalPages}"
				styleClass="my-button" />
			<br />

		</center>

		<br />
		<br />
		<center>
			<h:commandButton action="AddPlan.jsp" value="Add a plan"
				styleClass="my-button" />
			<br> <br>
			<h:commandButton action="ExistingPlans.jsp"
				value="Add subplan in existing plans" styleClass="my-button" />

		</center>
	</h:form>



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
</body>
	</html>
</f:view>