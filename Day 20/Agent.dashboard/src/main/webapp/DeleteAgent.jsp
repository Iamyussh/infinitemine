<%@page import="infinite.Agent.dashboard.AgentDAOImpl"%>
<%@page import="infinite.Agent.dashboard.AgentDAO"%>
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
		int agentId = Integer.parseInt(request.getParameter("agentid"));
		AgentDAO dao = new AgentDAOImpl();
		dao.deleteAgentDao(agentId);
%>
		<jsp:forward page="AgentShow.jsp"/>
</body>
</html>