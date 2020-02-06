package de.jarm.main.data;

import java.util.List;

import database.project.ProjectDAO;
import de.jarm.main.interfaces.ProjectServiceInterface;
import de.jarm.main.utils.ValidierungsException;

public class ProjectService implements ProjectServiceInterface {
	
	private ProjectDAO projectDAO = new ProjectDAO();
	
	@Override
	public Project create(String projectTitle, User projectOwner) throws ValidierungsException {
		if (projectOwner == null) {
			throw new ValidierungsException("Daf�r m�ssen sie eingeloggt sein!");
		} else if (projectTitle.equals("")) {
			throw new ValidierungsException("Bitte einen Titel festlegen!");
		}
		try {
			return projectDAO.addProject(new Project(projectTitle, projectOwner));
		} catch(Exception e) {
			throw new ValidierungsException(e.getMessage());
		}
	}

	@Override
	public void writeMessage(Project project, String message, User author) throws ValidierungsException {
		if (message.equals("")) {
			throw new ValidierungsException("Bitte eine Nachricht eingeben!");
		} else if (project.getOwner() != author && !project.getSubscribers().contains(author)) {
			throw new ValidierungsException("Der Verfasser einer Nachricht muss dem Projekt zugeordnet sein!");
		} else if (project == null || author == null) {
			throw new ValidierungsException("Das Projekt oder der Autor konnten nicht gefunden werden!");
		}
		try {
			projectDAO.addMessageToProject(project, new Message(message, author));
		} catch(Exception e) {
			throw new ValidierungsException(e.getMessage());
		}
	}

	@Override
	public void addSubscriber(Project project, User subscriber) throws ValidierungsException {
		if (project == null || subscriber == null) {
			throw new ValidierungsException("Das Projekt oder der User konnten nicht gefunden werden!");
		} else if (project.getOwner() == subscriber) {
			throw new ValidierungsException("Dieser User ist bereits der Besitzer des Projekts!");
		} else if (project.getSubscribers().contains(subscriber)) {
			throw new ValidierungsException("Dieser User ist dem Projekt bereits zugeordnet!");
		}
		try {
			projectDAO.addUserToProject(project, subscriber);
		} catch (Exception e) {
			throw new ValidierungsException(e.getMessage());
		}
	}

	@Override
	public void removeSubscriber(Project project, User subscriber) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeToDoState(ProjectToDo toDo, int newToDoState) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeToDo(Project project, ProjectToDo toDo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProject(Project project) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeMessage(Project project, Message message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addToDo(Project project, ProjectToDo toDo) throws ValidierungsException {
		if (project == null || toDo == null) {
			throw new ValidierungsException("Projekt oder Todo nicht gefunden!");
		}
		try {
			projectDAO.addTodoToProject(project, toDo);
		} catch(Exception e) {
			throw new ValidierungsException(e.getMessage());
		}
	}

	@Override
	public List<Project> getProjectsByUser(User user) throws ValidierungsException {
		if (user == null) {
			throw new ValidierungsException("Dazu musst du eingeloggt sein!");
		}
		try {
			return projectDAO.loadProjectsByUser(user.getId());
		} catch(Exception e) {
			throw new ValidierungsException(e.getMessage());
		}

	}

	@Override
	public Project getProjectById(int projectId) throws ValidierungsException {
		try {
			return projectDAO.loadProjectById(projectId);
		} catch (Exception e) {
			throw new ValidierungsException(e.getMessage());
		}
	}

	@Override
	public void addUserToTodo(ProjectToDo todo, User user) throws ValidierungsException {
		try {
			projectDAO.addUserToTodo(todo, user);
		} catch(Exception e) {
			throw new ValidierungsException(e.getMessage());
		}
	}

}
