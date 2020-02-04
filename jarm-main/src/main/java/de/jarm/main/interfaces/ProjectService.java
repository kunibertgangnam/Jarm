package de.jarm.main.interfaces;

import java.time.LocalDate;

import de.jarm.main.data.Message;
import de.jarm.main.data.Project;
import de.jarm.main.data.ProjectToDo;
import de.jarm.main.data.User;
import de.jarm.main.utils.ValidierungsException;

public interface ProjectService {

	Project create(int projectId, String projectTitle, User projectOwner, LocalDate createDate) throws ValidierungsException;
	User create(int id, String name, String password, String email)throws ValidierungsException;
	void writeMessage(int id, String message, User author);
	void addSubscriber(User subscriber);
	void removeSubscriber(User subscriber);
	void changeToDoState(Project project, ProjectToDo toDo);
	void removeToDo(Project project, ProjectToDo toDo);
	void deletProject(Project project);
	void removeMessage(Project project, Message message);
	
	
}
