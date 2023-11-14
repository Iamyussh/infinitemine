<%@page import="com.java.jsp.Employee"%>
<%@page import="com.java.jsp.EmployeeDAOImpl"%>
<%@page import="com.java.jsp.EmployeeDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	EmployeeDAO dao = new EmployeeDAOImpl();
	List<Employee> employeeList = dao.showEmployeeDAO();
%>
<center>
<table border="3" align="center">
	<tr>
		<th>Employ Id</th>
		<th>Employ Name</th>
		<th>Employ Email</th>
		<th>Employ MobileNo</th>
		<th>Employ DateOfJoin</th>
		<th>Employ ManagerId</th>
		<th>Employ LeaveAvail</th>
		<th>Show</th>
	</tr>
	<%
		int empid=1;
		for(Employee employee : employeeList) {
			 empid = employee.getEmpId();
	%>
		<tr>
			<td><%=employee.getEmpId() %> </td>
			<td><%=employee.getEmpName() %>  </td>
			<td><%=employee.getEmpMail() %> </td>
			<td><%=employee.getMobileNo() %> </td>
			<td><%=employee.getDateofJoin() %> </td>
			<td><%=employee.getManagerId() %> </td>
			<td><%=employee.getLeaveAvail() %> </td>
			<td> 
				<a href=DashBoard.jsp?empId=<%=employee.getEmpId() %>&mgrId=<%=employee.getManagerId() %> >Show</a>
			</td>
		</tr>
	<%
		}
	%>
	
</table>
</center>

</body>
</html>