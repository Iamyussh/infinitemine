<%@page import="com.java.jsp.Resolve"%>
<%@page import="java.util.List"%>
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

    .pink {
        background-color: pink;
    }

    .red {
        background-color: red;
        color: white; 
    }
    
    
</style>
</head>
<body>


<center>
		<h1>List of Resolved Complaints</h1>
    <table border="1">
        <tr>	
        	<th>Resolve ID</th>
            <th>Complaint ID</th>
            <th>Complaint Date</th>
            <th>Resolve Date</th>
            <th>Resolved By</th>
            <th>Comments</th>
           
        </tr>
        <%
            
            ComplaintDAO dao = new ComplaintDAOImpl();
            
           
            List<Resolve> resolved = dao.showResolveDAO();

            
            for (Resolve res : resolved) {
            	
            	long complaintToResolveDays = (res.getResolveDate().getTime() - res.getComplaintDate().getTime()) / (1000 * 60 * 60 * 24);
                String rowColor = (complaintToResolveDays >= 7 && complaintToResolveDays <= 10) ? "pink" : (complaintToResolveDays >= 10) ? "red" : "";
        %>
                <tr class="<%= rowColor %>">
                    <td><%= res.getResolveID() %></td>
                    <td><%= res.getComplaintID() %></td>
                    <td><%= res.getComplaintDate() %></td>
                    <td><%= res.getResolveDate() %></td>
                    <td><%= res.getResolvedBy() %></td>
                    <td><%= res.getComments() %></td>
                    
                </tr>
        <%
            }
        %>
        
    </table>
    
    </center>


</body>
</html>