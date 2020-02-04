package database;

public class DBStatements {
	
	//QUERY
	
	public static final String SELECT_USER_LOGIN = "SELECT * FROM user WHERE email = ? AND password = ?;";
	
	public static final String SELECT_PROJECTS = "SELECT * FROM project;";
	
	//public static final String SELECT_PROJECT_USERS_BY_PROJECT_ID = "SELECT * FROM project_user WHERE project_id = ?;";
	
	public static final String SELECT_PROJECT_USERS_BY_PROJECT_ID = "SELECT * FROM user WHERE (SELECT user_id FROM project_user WHERE project_id = ?) = id;";
	
	public static final String SELECT_PROJECT_TODOS_BY_PROJECT_ID = "SELECT * FROM project_todo WHERE project_id = ?;";
	
	public static final String SELECT_PROJECT_TODO_USERS_BY_PROJECT_TODO_ID = "SELECT * FROM user WHERE (SELECT user_id FROM project_todo_user WHERE project_todo_id = ?) = id;";
	
	public static final String SELECT_PROJECT_MESSAGES_BY_PROJECT_ID = "SELECT * FROM project_message WHERE project_id = ?;";
	
	public static final String SELECT_ALL_USERS = "SELECT * FROM user;";
	
	public static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id = ?;";
	
	//INSERT
	
	public static final String ADD_USER = "INSERT INTO user (name, password, created, email) VALUES (?,?,?,?);";
	
	public static final String ADD_PROJECT = "INSERT INTO project (owner_id, created, name) VALUES (?,?,?);";
	
	public static final String ADD_TODO = "INSERT INTO project_todo (created, done, name, description, project_id, in_progress) VALUES (?,?,?,?,?,?);";
	
	public static final String ADD_MESSAGE = "INSERT INTO project_message (created, user_id, message, project_id) VALUES (?,?,?,?);";
	
	public static final String ADD_USER_TO_PROJECT = "INSERT INTO project_user (user_id, project_id) VALUES (?,?);";
	
	public static final String ADD_USER_TO_TODO = "INSERT INTO project_todo_user (project_todo_id, user_id) VALUES (?,?);";
	
	//UPDATE
	
	public static final String SET_TODO_IN_PROGRESS_BY_ID = "UPDATE project_todo SET in_progress = ? WHERE id = ?;";
	
	public static final String SET_TODO_DONE_BY_ID = "UPDATE project_todo SET done = ? WHERE id = ?;";
	
	//DELETE

	public static final String REMOVE_USER_FROM_TODO = "DELETE FROM project_todo_user WHERE project_todo_id = ? AND user_id = ?;";
	
	public static final String REMOVE_USER_FROM_PROJECT = "DELETE FROM project_user WHERE project_id = ? AND user_id = ?;";
}
