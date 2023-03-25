package mini.model;

import java.sql.ResultSet;

//import com.mysql.cj.protocol.Resultset;

public interface DAOService {
	public void connectionDB();
	public boolean verifyCredentials(String email, String password);
	public void saveregistration(String name, String city, String email, String mobile );
	public ResultSet listregistration();
	//interface me in complete method bane 
	//complete method public void connectionDB(){ ese 
	public void deletebymobile(String mobile);
	public void update(String email, String mobile);

}
