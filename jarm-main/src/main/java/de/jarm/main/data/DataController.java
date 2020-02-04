package de.jarm.main.data;

import java.util.ArrayList;

import de.jarm.main.interfaces.ProjectServiceInterface;
import de.jarm.main.interfaces.UserServiceInterface;

public class DataController {
	
	private ProjectServiceInterface projectService;
	private UserServiceInterface userService;
	private static DataController instance;

	private DataController () {
		projectService = new ProjectServiceDummy(new ArrayList<Project>());
		userService = new UserServiceDummy(new ArrayList<User>());
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
