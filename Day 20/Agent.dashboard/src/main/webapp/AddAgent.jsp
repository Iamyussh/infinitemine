<%@page import="infinite.Agent.dashboard.Gender"%>
<%@page import="infinite.Agent.dashboard.AgentDAOImpl"%>
<%@page import="infinite.Agent.dashboard.Agent"%>
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
<form method="get" action="AddAgent.jsp">
	<center>
		Agent No : 
		<input type="number" name="agentId" /> <br/><br/>
		Agent Name : 
		<input type="text" name="name" /> <br/><br/>
		Agent City : 
		<input type="text" name="city" /> <br/><br/>
		Gender : 
		<select name="gender">
			<option value="MALE">Male</option>
			<option value="FEMALE">Female</option>
		</select> <br/><br/>
		
		Agent maritalstatus : 
		<input type="number" name="maritalstatus" /> <br/><br/>
		
		Premium:
		<input type="number" name="premium" /> <br/><br/>
		<input type="submit" value="Add Agent" />
	</center>
	</form>
	
	
	
	<%
	
	if(request.getParameter("agentId")!=null && request.getParameter("premium")!=null){
		AgentDAO dao = new AgentDAOImpl();
		Agent agent = new Agent();
		agent.setAgentId(Integer.parseInt(request.getParameter("agentId")));
		agent.setName(request.getParameter("name"));
		agent.setCity(request.getParameter("city"));
		agent.setGender(Gender.valueOf(request.getParameter("gender")));
		agent.setMaritalstatus(Integer.parseInt(request.getParameter("maritalstatus")));
		agent.setPremium(Double.parseDouble(request.getParameter("premium")));
		
		dao.addAgent(agent);
		%>
		
		<jsp:forward page = "AgentShow.jsp"/>;
		<% 
	}

%>
</body>
</html>