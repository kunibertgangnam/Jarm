package de.jarm.main.data;

import de.jarm.main.interfaces.ProjectServiceInterface;
import de.jarm.main.interfaces.UserServiceInterface;
import de.jarm.main.utils.TestDatenBestand;

public class DataController {
	
	private ProjectServiceInterface projectService;
	private UserServiceInterface userService;
	private static DataController instance;

	private DataController () {
<<<<<<< HEAD
		projectService = new ProjectService();
		userService = new UserService();
=======
		projectService = new ProjectServiceDummy(new ArrayList<Project>());
		userService = new UserServiceDummy(new ArrayList<User>());
		TestDatenBestand.test();
>>>>>>> refs/remotes/origin/master
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
