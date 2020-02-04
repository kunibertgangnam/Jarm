package de.jarm.main.interfaces;


import de.jarm.main.data.Message;
import de.jarm.main.data.Project;
import de.jarm.main.data.ProjectToDo;
import de.jarm.main.data.User;
import de.jarm.main.utils.ValidierungsException;

public interface ProjectServiceInterface {

	public Project create(String projectTitle, User projectOwner) throws ValidierungsException;
	public void writeMessage(Project project, String message, User author);
	public void addSubscriber(Project project, User subscriber);
	public void removeSubscriber(Project project, User subscriber);
	public void changeToDoState(ProjectToDo toDo, int newToDoState);
	public void removeToDo(Project project, ProjectToDo toDo);
	public void deletProject(Project project);
	public void removeMessage(Project project, Message message);
	
	
}
