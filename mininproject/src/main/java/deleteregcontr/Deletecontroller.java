package deleteregcontr;

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


@WebServlet("/delete")
public class Deletecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Deletecontroller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		
			String mobile = request.getParameter("mobile");
			DAOService data = new DAOServicesimpl();
			data.connectionDB();
			data.deletebymobile(mobile);
		//redirect to table
		
		ResultSet result = data.listregistration();
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/regfol/listall.jsp");
		dispatcher.forward(request, response);
	}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("minilogin.jsp");
		dispatcher.forward(request, response);
	}}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
