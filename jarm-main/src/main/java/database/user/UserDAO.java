package database.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import database.DBController;
import database.DBStatements;

public class UserDAO {
	
	private Map<String, User> users;
	
	public void loadUsers() {
		users = new HashMap<String, User>();
		
		Statement stmt = DBController.getInstance().getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(DBStatements.SELECT_ALL_USERS);
		
		while (rs.next()) {
			// user objekt zusammenbauen
		}
	}
	
}
