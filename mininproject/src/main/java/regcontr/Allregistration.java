package regcontr;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.mysql.cj.protocol.Resultset;

import mini.model.DAOServicesimpl;


@WebServlet("/Allregistration")
public class Allregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Allregistration() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		DAOServicesimpl data =new  DAOServicesimpl();
		data.connectionDB();
		ResultSet result = data.listregistration();
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/regfol/listall.jsp");
		dispatcher.forward(request, response);
	}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("minilogin.jsp");
		dispatcher.forward(request, response);
	}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
