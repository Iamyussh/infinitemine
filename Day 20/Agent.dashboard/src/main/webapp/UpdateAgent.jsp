<%@page import="infinite.Agent.dashboard.Gender"%>
<%@page import="infinite.Agent.dashboard.Agent"%>
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
		Agent agent = dao.searchAgentDao(agentId);
		
%>		
		<form method="get" action="UpdateAgent.jsp">
	<center>
	AGENT ID : 
		<input type="number" name="agentid" readonly="readonly" 
			value=<%=agent.getAgentId() %> /> <br/><br/>
	Agent Name : 
		<input type="text" name="name" 
			value=<%=agent.getName() %> /> <br/><br/>
	Agent City : 
		<input type="text" name="city" 
			value=<%=agent.getCity() %> /> <br/><br/>
	Gender : 
	<input type="text" name="gender" 
		value=<%=agent.getGender() %> /> <br/><br/>
	Marital Status : 
	<input type="text" name="maritalstatus" 
			value=<%=agent.getMaritalstatus() %> /> <br/><br/> 
	Premium : 
	<input type="number" name="premium"
			value=<%=agent.getPremium() %> /> <br/><br/>
	<input type="submit" value="Update Agent" />
	</center>
			</form>

			<%
			
			if(request.getParameter("agentid")!=null &&
			request.getParameter("premium")!=null){
				Agent agentUpdated = new Agent();
				agentUpdated.setAgentId(Integer.parseInt(request.getParameter("agentid")));
				agentUpdated.setName(request.getParameter("name"));
				agentUpdated.setCity(request.getParameter("city"));
				agentUpdated.setGender(Gender.valueOf(request.getParameter("gender")));
				agentUpdated.setMaritalstatus(Integer.parseInt(request.getParameter("maritalstatus")));
				agentUpdated.setPremium(Double.parseDouble(request.getParameter("premium")));
				
				dao.updateAgentDao(agentUpdated);
				%>
				<jsp:forward page="AgentShow.jsp" />
<% 
			}
			%>

</body>
</html>