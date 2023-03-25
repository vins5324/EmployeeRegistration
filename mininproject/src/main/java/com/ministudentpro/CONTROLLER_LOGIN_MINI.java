package com.ministudentpro;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.model.DAOService;
import mini.model.DAOServicesimpl;

@WebServlet("/verifying")
public class CONTROLLER_LOGIN_MINI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CONTROLLER_LOGIN_MINI() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	doGet(request, response);
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	//upcasting krni hai 
	DAOService service = new DAOServicesimpl();
	service.connectionDB();
	
	boolean status = service.verifyCredentials(email, password);
	
	if (status == true) {
		
		//session variable har kahi hoga 
		HttpSession session = request.getSession(true);
		session.setAttribute("email", service);
		
		//automatic logout ho jaega time out se 
		//session.setMaxInactiveInterval(10);
		//07/12/22
		///WEB-INF/regfol/registration07_12_22.jsp ye next jsp page le jaega ese 
		//web-inf islye bcz registration page ke bad ye wala page open ho ilsye only servlet can call
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/regfol/registration07_12_22.jsp");
		dispatcher.forward(request, response);
	
//YAHATAK	
	}else {
		request.setAttribute("error", "invalid password or user name ");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("minilogin.jsp");
		dispatcher.forward(request, response);
	}

}}
