package de.jarm.main.data;

import java.time.LocalDate;
import java.util.List;

import de.jarm.main.interfaces.ProjectServiceInterface;
import de.jarm.main.utils.ValidierungsException;

public class ProjectServiceDummy implements ProjectServiceInterface{
	private List<Project> projectList;

	
	private Project create(String projectTitle, User projectOwner, LocalDate creationDate)
			throws ValidierungsException {
		Project newProject = new Project(projectTitle, projectOwner, creationDate);
		projectList.add(newProject);
		return newProject;
	}
	
	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	@Override
	public Project create(String projectTitle, User projectOwner)
			throws ValidierungsException {
		return create(projectTitle, projectOwner, LocalDate.now());
	}
	
	public ProjectServiceDummy(List<Project> projectList) {
		this.projectList = projectList;
		
	}

	@Override
	public void writeMessage(Project project, String message, User author) {
		project.getMessages().add(new Message(message, author));
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
