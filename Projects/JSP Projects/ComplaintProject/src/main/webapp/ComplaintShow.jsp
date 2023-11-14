<%@page import="com.java.jsp.ComplaintDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.java.jsp.Complaint" %>
<%@ page import="com.java.jsp.ComplaintDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Timestamp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Complaints</title>
    
    <style>
    
     .button {
        display: inline-block;
        padding: 10px 20px;
        font-size: 16px;
        background-color: #3498db;
        color: #fff;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease;
        margin: 5px;
    }

    .button:hover {
        background-color: #2980b9;
    }
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
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #333;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
    <h1>List of Complaints</h1>
    <table border="1">
        <tr>
            <th>Complaint ID</th>
            <th>Complaint Type</th>
            <th>Description</th>
            <th>Complaint Date</th>
            <th>Severity</th>
            <th>Status</th>
            
        </tr>
        <%
            
            ComplaintDAO dao = new ComplaintDAOImpl();
            
           
            List<Complaint> complaints = dao.showComplaintDAO();

            
            for (Complaint complaint : complaints) {
        %>
                <tr>
                    <td><%= complaint.getComplaintid() %></td>
                    <td><%= complaint.getComplaintType() %></td>
                    <td><%= complaint.getCDescription() %></td>
                    <td><%= complaint.getComplaintDate() %></td>
                    <td><%= complaint.getSeverity() %></td>
                    <td><%= complaint.getStatus() %></td>
                    
                </tr>
        <%
            }
        %>
        
    </table>
    
    
    <center>
     <a href="searchcomplaint.jsp" class="button">Search Complaint</a><br><br>
    <a href="addcomplaint.jsp" class="button">Raise a Complaint</a><br><br>
    <a href="Resolve.jsp" class="button">Resolve a Complaint</a>
   
    </center>
   
    
</body>
</html>


