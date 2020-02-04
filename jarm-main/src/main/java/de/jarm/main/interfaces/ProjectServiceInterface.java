package de.jarm.main.interfaces;

import java.time.LocalDate;

import de.jarm.main.data.Message;
import de.jarm.main.data.Project;
import de.jarm.main.data.ProjectToDo;
import de.jarm.main.data.User;
import de.jarm.main.utils.ValidierungsException;

public interface ProjectServiceInterface {

	Project create(int projectId, String projectTitle, User projectOwner, LocalDate creationDate) throws ValidierungsException;
	void writeMessage(Project project, int id, String message, User author);
	void addSubscriber(Project project, User subscriber);
	void removeSubscriber(Project project, User subscriber);
	void changeToDoState(ProjectToDo toDo, int newToDoState);
	void removeToDo(Project project, ProjectToDo toDo);
	void deletProject(Project project);
	void removeMessage(Project project, Message message);
	
	
}
