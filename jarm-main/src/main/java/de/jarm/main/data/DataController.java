package de.jarm.main.data;

import de.jarm.main.interfaces.ProjectServiceInterface;
import de.jarm.main.interfaces.UserServiceInterface;
import de.jarm.main.utils.TestDatenBestand;

public class DataController {
	
	private ProjectServiceInterface projectService;
	private UserServiceInterface userService;
	private static DataController instance;

	private DataController () {
		projectService = new ProjectService();
		userService = new UserService();
	}
	
	public ProjectServiceInterface getProjectService() {
		return projectService;
	}
	
	public UserServiceInterface getUserService() {
		return userService;
	}
	
	public static DataController getInstance () {
		if (DataController.instance == null) {
			DataController.instance = new DataController ();
		}
		return DataController.instance;
	}
}
