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
</head>
<style>

 body {
     font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    h1 {
        text-align: center;
        background-color: #333;
        color: #fff;
        padding: 20px;
        margin: 0;
    }

    .container {
        width: 80%;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    label {
        font-weight: bold;
    }

    input[type="text"] {
        width: 50%; /* Reduced width to make it smaller */
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    button[type="submit"] {
        background-color: #333;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    button[type="submit"]:hover {
        background-color: #555;
    }

    p {
        color: red;
    }
    </style>
    
    
    
<body>
 <h1>Search for Complaint</h1>
    
    <%
        String complaintid = request.getParameter("complaintid");
        if (complaintid != null) {
    
            ComplaintDAO dao = new ComplaintDAOImpl(); 
            Complaint complaint = dao.searchComplaintDAO(complaintid);

            if (complaint != null) {
    %>
                <table>
            <tr>
                <th>Complaint ID</th>
                <th>Complaint Type</th>
                <th>Description</th>
                <th>Severity</th>
                <th>Status</th>
                <th>Complaint Date</th>
            </tr>
            <tr>
                <td><%= complaint.getComplaintid() %></td>
                <td><%= complaint.getComplaintType() %></td>
                <td><%= complaint.getCDescription() %></td>
                <td><%= complaint.getSeverity() %></td>
                <td><%= complaint.getStatus() %></td>
                <td><%= complaint.getComplaintDate() %></td>
            </tr>
        </table>
                <br><br>
    <%
            } else {
    %>
                <p>Complaint not found.</p>
    <%
            }
        }
    %>
    
   		 <form method="get">
        <label for="complaintid">Complaint ID:</label>
        <input type="text" id="complaintid" name="complaintid" required>
        <button type="submit">Search</button>
    		</form>

</body>
</html>