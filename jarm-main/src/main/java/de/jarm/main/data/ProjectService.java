package de.jarm.main.data;

import java.time.LocalDate;

import de.jarm.main.interfaces.ProjectServiceInterface;
import de.jarm.main.utils.ValidierungsException;

public class ProjectService implements ProjectServiceInterface{

	@Override
	public Project create(int projectId, String projectTitle, User projectOwner, LocalDate createDate)
			throws ValidierungsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeMessage(int id, String message, User author) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSubscriber(User subscriber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSubscriber(User subscriber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeToDoState(Project project, ProjectToDo toDo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeToDo(Project project, ProjectToDo toDo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletProject(Project project) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeMessage(Project project, Message message) {
		// TODO Auto-generated method stub
		
	}

}
