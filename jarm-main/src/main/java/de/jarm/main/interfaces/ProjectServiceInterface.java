package de.jarm.main.interfaces;


import java.util.List;

import de.jarm.main.data.Message;
import de.jarm.main.data.Project;
import de.jarm.main.data.ProjectToDo;
import de.jarm.main.data.User;
import de.jarm.main.utils.ValidierungsException;

public interface ProjectServiceInterface {

	public Project create(String projectTitle, User projectOwner) throws ValidierungsException;
	public void writeMessage(Project project, String message, User author) throws ValidierungsException;
	public void addSubscriber(Project project, User subscriber) throws ValidierungsException;
	public void removeSubscriber(Project project, User subscriber);
	public void changeToDoState(ProjectToDo toDo, int newToDoState);
	public void removeToDo(Project project, ProjectToDo toDo);
	public void deleteProject(Project project);
	public void removeMessage(Project project, Message message);
	public void addToDo(Project project, ProjectToDo toDo) throws ValidierungsException;
	public List<Project> getProjectsByUser(User user) throws ValidierungsException;
	public Project getProjectById(int projectId) throws ValidierungsException;
	public void addUserToTodo(ProjectToDo todo, User user) throws ValidierungsException;
	
}
