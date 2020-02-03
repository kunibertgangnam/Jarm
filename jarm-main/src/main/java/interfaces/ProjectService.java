package interfaces;

import java.time.LocalDate;
import classes.Project;
import classes.ProjectToDo;
import classes.User;

public interface ProjectService {

	Project create(long projectID, String projectTitle, User projectOwner, LocalDate createDate);
	void writeMessage(long iD, String message, User author);
	void addSubscriber(User subscriber);
	void changeToDoState(Project project, ProjectToDo toDo);
	
//	void loadMessages();
//	void loadUser();
//	void loadToDo();
//	void deleteProject(String projectname);
//	void removeUser(String user, String projectname);
//	void removeMessage();
//	void removeTodo();
}
