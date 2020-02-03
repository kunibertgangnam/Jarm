package database.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import database.DBController;
import database.DBStatements;
import utils.DateUtils;

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
	
	public User findBenutzerByEmail(String email) {
		return users.get(email);
	}
	
	public void addUser(User u) {
		PreparedStatement pstmt = DBController.getInstance().getConnection().prepareStatement(DBStatements.ADD_USER);
		pstmt.setString(0, u.getName());
		pstmt.setString(1, u.getPassword());
		pstmt.setInt(2, DateUtils.toString(u.getCreated()));
		pstmt.setString(3, u.getEmail());
	}
	
}
