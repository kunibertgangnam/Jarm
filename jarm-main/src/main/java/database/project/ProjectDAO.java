package database.project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import database.DBController;
import database.DBStatements;
import utils.DateUtils;

public class ProjectDAO {
	
	private Map<String, Project> projects;
	
	public void loadProjects() {
		projects = new HashMap<String, Project>();
		
		Statement stmt = DBController.getInstance().getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(DBStatements.SELECT_PROJECTS);
		
		while (rs.next()) {
			// project objekt zusammenbauen
		}
	}
	
	public void addProject(Project p, User u) {
		PreparedStatement pstmt = DBController.getInstance().getConnection().prepareStatement(DBStatements.ADD_PROJECT);
		pstmt.setInt(0, u.getId());
		pstmt.setString(1, DateUtils.toString(LocalDate.now()));
		pstmt.setInt(2, p.getName());
	}
}
