package de.jarm.main.data;

import java.util.List;

import de.jarm.main.interfaces.ProjectServiceInterface;
import de.jarm.main.utils.ValidierungsException;

public class ProjectServiceDummy implements ProjectServiceInterface{
	private List<Project> projectList;

	@Override
	public Project create(String projectTitle, User projectOwner)
			throws ValidierungsException {
		Project newProject = new Project(projectTitle, projectOwner);
		projectList.add(newProject);
		return newProject;
	}
	
	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	
	public ProjectServiceDummy(List<Project> projectList) {
		this.projectList = projectList;
		
	}
	
	public Project getProject(int id) {
		for (Project project : projectList) {
			if(project.getId() == id) {
				return project;
			}
		}
		return null;
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
	public void deleteProject(Project project) {
		projectList.remove(project);
		
	}

	@Override
	public void removeMessage(Project project, Message message) {
		project.getMessages().remove(message);
		
	}

	@Override
	public void addToDo(Project project, ProjectToDo toDo) throws ValidierungsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Project> getProjectsByUser(User user) throws ValidierungsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project getProjectById(int projectId) throws ValidierungsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserToTodo(ProjectToDo todo, User user) throws ValidierungsException {
		// TODO Auto-generated method stub
		
	}

}
