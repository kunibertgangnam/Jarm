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

	public void loadProjects() {
		projects = new HashMap<String, Project>();

		try (Connection con = DBController.getInstance().getConnection(); Statement stmt = con.createStatement()) {

			ResultSet rs = stmt.executeQuery(DBStatements.SELECT_PROJECTS);
			while (rs.next()) {
				int ownerId = rs.getInt("id");
				User u = getUserById(ownerId);
				Project p = new Project(rs.getInt("id"), rs.getString("name"), u,
						DateUtils.toDate(rs.getString("created")));
			}

			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addProject(Project p, User u) {

		try (Connection con = DBController.getInstance().getConnection();
				PreparedStatement pstmt = con.prepareStatement(DBStatements.ADD_PROJECT)) {

			pstmt.setInt(0, u.getId());
			pstmt.setString(1, DateUtils.toString(LocalDate.now()));
<<<<<<< HEAD
			pstmt.setString(2, p.getTitle());		
=======
			pstmt.setString(2, p.getTitle());

>>>>>>> branch 'Jarm-1-Datenbankmodell' of https://github.com/kunibertgangnam/Jarm
			pstmt.execute();
<<<<<<< HEAD
			
=======
//			ResultSet rs = stmt.executeQuery(DBStatements.ADD_PROJECT);				
//			while (rs.next()) {
//				int ownerId = rs.getInt("id");			
//				User u = getUserById(ownerId);
//				Project p = new Project(rs.getInt("id"), rs.getString("name"), u, DateUtils.toDate(rs.getString("created")));
//			}
//			
//			rs.close();

>>>>>>> branch 'Jarm-1-Datenbankmodell' of https://github.com/kunibertgangnam/Jarm
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private User getUserById(int userId) throws SQLException {
		try (Connection con = DBController.getInstance().getConnection();
				PreparedStatement pstmt = con.prepareStatement(DBStatements.SELECT_USER_BY_ID)) {

			pstmt.setInt(0, userId);
			ResultSet rs = pstmt.executeQuery();
			User u = new User(userId, rs.getString("name"), rs.getString("password"), rs.getString("email"));
			rs.close();
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<ProjectToDo> getProjectTodos(int projectId) throws SQLException {
		List<ProjectToDo> todos = new ArrayList<>();

		try (Connection con = DBController.getInstance().getConnection();
				PreparedStatement pstmt = con.prepareStatement(DBStatements.SELECT_PROJECT_TODOS_BY_PROJECT_ID)) {
			pstmt.setInt(0, projectId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int todoId = rs.getInt("id");
				List<User> attachedUsers = getProjectTodoUsers(todoId);
				ProjectToDo d = new ProjectToDo(todoId, rs.getString("name"), rs.getString("description"), attachedUsers, rs.getInt("state"), DateUtils.toDate(rs.getString("created")));
			}

			rs.close();
		}

		return todos;
	}

	private List<User> getProjectTodoUsers(int todoId) throws SQLException {
		List<User> projectTodoUsers = new ArrayList<User>();

		try (Connection con = DBController.getInstance().getConnection();
				PreparedStatement pstmt = con
						.prepareStatement(DBStatements.SELECT_PROJECT_TODO_USERS_BY_PROJECT_TODO_ID)) {

			pstmt.setInt(0, todoId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"),
						rs.getString("email"));
				projectTodoUsers.add(u);
			}
			rs.close();
			return projectTodoUsers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<User> getProjectUsers(int projectId) throws SQLException {
		List<User> projectUsers = new ArrayList<User>();

		try (Connection con = DBController.getInstance().getConnection();
				PreparedStatement pstmt = con.prepareStatement(DBStatements.SELECT_PROJECT_USERS_BY_PROJECT_ID)) {
			pstmt.setInt(0, projectId);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"),
						rs.getString("email"));
				projectUsers.add(u);
			}
			rs.close();
			return projectUsers;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private List<Message> getProjectMessages(int projectId) throws SQLException {
		List<Message> projectMessages = new ArrayList<Message>();

		try (Connection con = DBController.getInstance().getConnection();
				PreparedStatement pstmt = con.prepareStatement(DBStatements.SELECT_PROJECT_MESSAGES_BY_PROJECT_ID)) {
			pstmt.setInt(0, projectId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				User u = getUserById(rs.getInt("user_id"));
				Message m = new Message(rs.getInt("id"), rs.getString("message"),
						DateUtils.toDate(rs.getString("created")), u);
				projectMessages.add(m);
			}
			rs.close();
			return projectMessages;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
