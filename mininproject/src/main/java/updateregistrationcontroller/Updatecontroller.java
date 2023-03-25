package updateregistrationcontroller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.model.DAOService;
import mini.model.DAOServicesimpl;
@WebServlet("/update")
public class Updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Updatecontroller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/regfol/update.jsp");
		dispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
			
		
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOService data = new DAOServicesimpl();
		data.connectionDB();
		data.update(email,mobile);	
		
		ResultSet result = data.listregistration();
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/regfol/listall.jsp");
		dispatcher.forward(request, response);
	}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("minilogin.jsp");
			dispatcher.forward(request, response);
		}
	}
}