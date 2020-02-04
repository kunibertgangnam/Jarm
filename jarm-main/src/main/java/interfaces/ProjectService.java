package interfaces;

import java.time.LocalDate;

import data.Message;
import data.Project;
import data.ProjectToDo;
import data.User;

public interface ProjectService {

	Project create(int projectid, String projectTitle, User projectOwner, LocalDate createDate);
	void writeMessage(int id, String message, User author);
	void addSubscriber(User subscriber);
	void removeSubscriber(User subscriber);
	void changeToDoState(Project project, ProjectToDo toDo);
	void removeToDo(Project project, ProjectToDo toDo);
	void deletProject(Project project);
	void removeMessage(Project project, Message message);
	
	
}
