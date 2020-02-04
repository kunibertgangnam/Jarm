package database.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.DBController;
import database.DBStatements;
import de.jarm.main.data.Message;
import de.jarm.main.data.Project;
import de.jarm.main.data.ProjectToDo;
import de.jarm.main.data.User;
import utils.DateUtils;

public class ProjectDAO {
	
	private Map<String, Project> projects;
	
	public void loadProjects() throws Exception {
		projects = new HashMap<String, Project>();
		
		try (Connection con = DBController.getInstance().getConnection();
		         Statement stmt = con.createStatement()) {

			ResultSet rs = stmt.executeQuery(DBStatements.SELECT_PROJECTS);				
			while (rs.next()) {
				int ownerId = rs.getInt("id");			
				User u = getUserById(ownerId);
				Project p = new Project(rs.getInt("id"), rs.getString("name"), u, DateUtils.toDate(rs.getString("created")));
			}
			
			rs.close();
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void addProject(Project p, User u) throws Exception {
		
		try (Connection con = DBController.getInstance().getConnection();
		         PreparedStatement pstmt = con.prepareStatement(DBStatements.ADD_PROJECT)) {
			
			pstmt.setInt(1, u.getId());
			pstmt.setString(2, DateUtils.toString(LocalDate.now()));
			pstmt.setString(3, p.getTitle());		
			pstmt.execute();
			
		} catch (SQLException e) {
			throw e;
		}
		
	}
	
	private User getUserById(int userId) throws Exception{
		try (Connection con = DBController.getInstance().getConnection();
		         PreparedStatement pstmt = con.prepareStatement(DBStatements.SELECT_USER_BY_ID)) {
			
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			User u = new User(userId, rs.getString("name"), rs.getString("password"), rs.getString("email"));
			rs.close();
			return u;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	private List<ProjectToDo> getProjectTodos(int projectId) throws Exception{
		List<ProjectToDo> todos = new ArrayList<>();
		
		try (Connection con = DBController.getInstance().getConnection();
		         PreparedStatement pstmt = con.prepareStatement(DBStatements.SELECT_PROJECT_TODOS_BY_PROJECT_ID)) {
			pstmt.setInt(1, projectId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int todoId = rs.getInt("id");
				List<User> attachedUsers = getProjectTodoUsers(todoId);
				ProjectToDo d = new ProjectToDo(todoId, rs.getString("name"), rs.getString("description"), attachedUsers, rs.getInt("state"), DateUtils.toDate(rs.getString("created")));
			}
			
			rs.close();
		} catch (Exception e) {
			throw e;
		}
		
		
		return todos;
	}
	
	private List<User> getProjectTodoUsers(int todoId) throws Exception{
		List<User> projectTodoUsers = new ArrayList<User>();
		
		try (Connection con = DBController.getInstance().getConnection();
		         PreparedStatement pstmt = con.prepareStatement(DBStatements.SELECT_PROJECT_TODO_USERS_BY_PROJECT_TODO_ID)) {
			
		
			pstmt.setInt(1, todoId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("email"));
				projectTodoUsers.add(u);
			}
			rs.close();
			return projectTodoUsers; 
		} catch (Exception e) {
			throw e;
		}
	}
	
	private List<User> getProjectUsers(int projectId) throws Exception{
		List<User> projectUsers = new ArrayList<User>();
		
		try (Connection con = DBController.getInstance().getConnection();
		         PreparedStatement pstmt = con.prepareStatement(DBStatements.SELECT_PROJECT_USERS_BY_PROJECT_ID)) {
			pstmt.setInt(1, projectId);
			
			ResultSet rs = pstmt.executeQuery();	
			while (rs.next()) {
				User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"), rs.getString("email"));
				projectUsers.add(u);
			}
			rs.close();
			return projectUsers;
		} catch(SQLException e) {
			throw e;
		}
	}
	
	private List<Message> getProjectMessages(int projectId) throws Exception {
		List<Message> projectMessages = new ArrayList<Message>();
		
		try (Connection con = DBController.getInstance().getConnection();
		         PreparedStatement pstmt = con.prepareStatement(DBStatements.SELECT_PROJECT_MESSAGES_BY_PROJECT_ID)) {
			pstmt.setInt(1, projectId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				User u = getUserById(rs.getInt("user_id"));
				Message m = new Message(rs.getInt("id"), rs.getString("message"), DateUtils.toDate(rs.getString("created")), u);
				projectMessages.add(m);
			}
			rs.close();
			return projectMessages;
			
		} catch (SQLException e) {
			throw e;
		}
		
	}
}
