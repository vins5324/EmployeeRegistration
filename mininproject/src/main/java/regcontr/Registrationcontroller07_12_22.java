package regcontr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.model.DAOService;
import mini.model.DAOServicesimpl;

@WebServlet("/registration")
public class Registrationcontroller07_12_22 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Registrationcontroller07_12_22() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/regfol/registration07_12_22.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
		
		//7
		DAOService data = new DAOServicesimpl();
		data.connectionDB();
		data.saveregistration(name, city, email, mobile);
		
		request.setAttribute("msg", "record is save");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/regfol/registration07_12_22.jsp");
		dispatcher.forward(request, response);
	}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("minilogin.jsp");
		dispatcher.forward(request, response);
	}

}}
