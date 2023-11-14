package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Resetpassword
 */
public class Resetpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resetpassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 
		HttpSession session = request.getSession(true);
		String username = (String)session.getAttribute("username");
		System.out.println(username);
		
			CustomerDAO dao = new CustomerDAOImpl();
			String resetKey = request.getParameter("resetKey");
			String newPass = request.getParameter("newpassword");
			String renewPass = request.getParameter("retypepassword");
			if(newPass.equals(renewPass)) {
				
				try {
					out.println(dao.resetPasswordDAO(resetKey,username,renewPass));
					RequestDispatcher disp = request.getRequestDispatcher("Login2.jsp");
					disp.include(request, response);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
			else {
				System.out.println("Both passwords must be same..");
			}
	}

}
