package database.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import database.DBController;
import database.DBStatements;
import de.jarm.main.data.User;
import de.jarm.main.database.exceptions.UserExistsException;
import de.jarm.main.database.exceptions.WrongUserOrPasswordException;
import utils.DateUtils;

public class UserDAO {
	
	public List<User> loadUsers() throws Exception {
		List<User> users = new ArrayList<User>();		

		try (Connection con = DBController.getInstance().getConnection();
				Statement stmt = con.createStatement();){
			
			ResultSet rs = stmt.executeQuery(DBStatements.SELECT_ALL_USERS);
			
			while (rs.next()) {
				User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("email"));
				users.add(u);
			}
			
			return users;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public User logIn(String email, String password) throws Exception {
		try (Connection con = DBController.getInstance().getConnection();
				PreparedStatement pstmt = con.prepareStatement(DBStatements.SELECT_USER_LOGIN)){
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("email"));
			return u;
			
		} catch (Exception e) {
			throw new WrongUserOrPasswordException();
		}
	}
	
	public User loadUserById(int id) throws Exception {
		try (Connection con = DBController.getInstance().getConnection();
				PreparedStatement pstmt = con.prepareStatement(DBStatements.SELECT_USER_BY_ID)){
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("email"));
			return u;
			
		} catch (SQLException e) {
			throw new Exception("Kein user unter der id " + id + " gefunden");
		}
	}
	
	
	
	public User addUser(User u) throws UserExistsException {
		
		try (Connection con = DBController.getInstance().getConnection();
				PreparedStatement pstmt = con.prepareStatement(DBStatements.ADD_USER)){
			
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, DateUtils.toString(LocalDate.now()));
			pstmt.setString(4, u.getEmail());	
			pstmt.executeUpdate();
			
			return u;
			
		} catch (SQLException e) {
			throw new UserExistsException();
		} 
	}
	
}