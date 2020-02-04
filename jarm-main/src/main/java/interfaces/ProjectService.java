package interfaces;

import java.time.LocalDate;

import classes.Message;
import classes.Project;
import classes.ProjectToDo;
import classes.User;

public interface ProjectService {

	Project create(int projectID, String projectTitle, User projectOwner, LocalDate createDate);
	void writeMessage(int iD, String message, User author);
	void addSubscriber(User subscriber);
	void removeSubscriber(User subscriber);
	void changeToDoState(Project project, ProjectToDo toDo);
	void removeToDo(Project project, ProjectToDo toDo);
	void deletProject(Project project);
	void removeMessage(Project project, Message message);
	
	
}
