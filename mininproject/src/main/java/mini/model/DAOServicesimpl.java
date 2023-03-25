package mini.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.cj.protocol.Resultset;

//import com.mysql.cj.protocol.Resultset;

public class DAOServicesimpl implements DAOService {
	private Connection con; //yaha public kyu nahi kiya 
	private Statement stmnt;
	@Override
	public void connectionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","test");
				stmnt = con.createStatement();
		} catch (Exception e) {
		}
	}

	@Override
	public boolean verifyCredentials(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery(" select * from login where email = '"+email+"'and password= '"+password+"' ");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveregistration(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration value('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {

		}
	}

	public ResultSet listregistration() {
		try {
			ResultSet result = stmnt.executeQuery(" select * from registration ");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void deletebymobile(String mobile) {
		try {
			stmnt.executeUpdate(" delete from registration where mobile = '"+mobile+"'");
			//return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(String email, String mobile) {
		try {
			stmnt.executeUpdate(" UPDATE registration SET mobile = '"+mobile+"' WHERE email = '"+email+"'");
			//return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}