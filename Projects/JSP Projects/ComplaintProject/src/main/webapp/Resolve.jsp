<%@page import="com.java.jsp.Complaint"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.java.jsp.ComplaintDAOImpl"%>
<%@page import="com.java.jsp.ComplaintDAO"%>
<%@page import="com.java.jsp.Resolve"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resolve Complaint</title>
 <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f2f2f2; /* Cool background color */
        }

        h1 {
            color: #3498db;
        }

        form {
            margin: 0 auto;
            width: 50%;
            text-align: left;
            background-color: #ffffff; /* Form background color */
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); /* Box shadow effect */
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }

        .button {
            display: inline-block;
            background-color: #3498db;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 4px;
            margin-top: 20px;
        }

        .button:hover {
            background-color: #2980b9;
        }
        </style>
    
    
<body>
<center>
	<h1>Resolve Complaint</h1>

    <form method="post" action="">
        <label for="complaintID">Complaint ID:</label>
        <input type="text" id="complaintID" name="complaintID" required><br><br>
        
       <label for="resolveDate">Resolve Date (yyyy-MM-dd HH:mm:ss):</label>
        <input type="text" id="resolveDate" name="resolveDate" required><br><br>
        
        <label for="resolvedBy">Resolved By:</label>
        <input type="text" id="resolvedBy" name="resolvedBy" required><br><br>
        
        <label for="comments">Comments:</label><br>
        <textarea id="comments" name="comments" rows="4" cols="50"></textarea><br><br>
        
        <input type="submit" value="Resolve Complaint">
    </form>

    <%
        if (request.getParameter("complaintID")!=null) {
            String complaintID = request.getParameter("complaintID");
            String resolveDateStr = request.getParameter("resolveDate");
            Timestamp resolveDate = Timestamp.valueOf(resolveDateStr);
            String resolvedBy = request.getParameter("resolvedBy");
            String comments = request.getParameter("comments");

            Resolve resolve = new Resolve();
            resolve.setComplaintID(complaintID);
            resolve.setResolveDate(resolveDate);
            resolve.setResolvedBy(resolvedBy);
            resolve.setComments(comments);

            
            ComplaintDAO complaintDAO = new ComplaintDAOImpl();

            String result = "Complaint Not Found"; // Default message

            Complaint complaintFound = complaintDAO.searchComplaintDAO(complaintID);
            if (complaintFound != null && "PENDING".equals(complaintFound.getStatus())) {
                result = complaintDAO.resolveComplaintDao(complaintID, resolve);
            } else if (complaintFound != null) {
                result = "Complaint is not in a pending state";
            }

            out.println("<p>" + result + "</p>");
        }
    %>
    
   
    <br><br> 
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
    <a href ="ResolveHis.jsp" class="button">Resolved Complaints</a>
    </center>
</body>
</html>
