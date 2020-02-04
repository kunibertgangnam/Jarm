package de.jarm.main.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import de.jarm.main.interfaces.ProjectServiceInterface;
import de.jarm.main.utils.ValidierungsException;

public class ProjectServiceDummy implements ProjectServiceInterface{
	private List<Project> projectList;

	
	private Project create(int projectId, String projectTitle, User projectOwner, LocalDate creationDate)
			throws ValidierungsException {
		Project newProject = new Project(projectId, projectTitle, projectOwner, creationDate);
		projectList.add(newProject);
		return newProject;
	}
	
	@Override
	public Project create(int projectId, String projectTitle, User projectOwner)
			throws ValidierungsException {
		return create(projectId, projectTitle, projectOwner, LocalDate.now());
	}
	
	public ProjectServiceDummy() {//List<Project> projectList) {
		this.projectList = new ArrayList<Project>();//projectList;
		try {
			create(0, "Projekt 1", new User(0, "Name", "Passwort"));
			create(1, "Projekt 2", new User(1, "Na", "Passrt"));
			create(2, "Projekt 3", new User(2, "Ne", "Passwort"));
		} catch (ValidierungsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void writeMessage(Project project, int id, String message, User author) {
		project.getMessages().add(new Message(id, message, author));
	}

	@Override
	public void addSubscriber(Project project, User subscriber) {
		project.getSubscribers().add(subscriber);
		
	}

	@Override
	public void removeSubscriber(Project project, User subscriber) {
		project.getSubscribers().remove(subscriber);
		
	}

	@Override
	public void changeToDoState(ProjectToDo toDo, int newToDoState) {
		toDo.setState(newToDoState);
		
	}

	@Override
	public void removeToDo(Project project, ProjectToDo toDo) {
		project.getToDos().remove(toDo);
		
	}

	@Override
	public void deletProject(Project project) {
		projectList.remove(project);
		
	}

	@Override
	public void removeMessage(Project project, Message message) {
		project.getMessages().remove(message);
		
	}

}
