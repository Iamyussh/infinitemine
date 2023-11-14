<%@page import="com.java.jsp.Complaint"%>
<%@page import="com.java.jsp.ComplaintDAOImpl"%>
<%@page import="com.java.jsp.ComplaintDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    /* Add your CSS styles here */
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
    }
    
    
    h1 {
        text-align: center;
        color: #333;
    }

    form {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    label {
        display: block;
        margin-bottom: 10px;
    }

    input[type="text"],
    textarea,
    select {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }

    select {
        height: 35px;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        padding: 10px 20px;
        border-radius: 3px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
  <h1>Raise Complaint</h1>

    <form action="addcomplaint.jsp" method="post">
       

        <label for="ComplaintType">Complaint Type:</label>
        <input type="text" id="ComplaintType" name="ComplaintType"><br>

        <label for="CDescription">Description:</label>
        <textarea id="CDescription" name="CDescription"></textarea><br>

        <label for="severity">Severity:</label>
        <Select name ="severity">
       <option value="Low">Low</option>
    <option value="Medium">Medium</option>
    <option value="High">High</option>
        </Select>
       

        <input type="submit" value="Submit">
    </form>
		
		
		<%
    
		if(request.getParameter("ComplaintType")!=null){
    
    ComplaintDAO complaintDAO = new ComplaintDAOImpl();
    Complaint newComplaint = new Complaint();
    
    newComplaint.setComplaintType(request.getParameter("ComplaintType"));
    newComplaint.setCDescription(request.getParameter("CDescription"));
    newComplaint.setSeverity(request.getParameter("severity"));
    

   
    complaintDAO.addComplaintDAO(newComplaint);
		
%>

    <jsp:forward page = "ComplaintShow.jsp"/>
		<%
		
		

		}
		%>
       

</body>
</html>