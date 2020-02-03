package classes;

import java.time.LocalDate;
import java.util.List;

public class Project {
		
	private long iD;
	private String projectTitle;
	private User owner;
	private LocalDate creatDate;
	private List<ProjectToDo> toDos;
	private List<User> subscribers;
	private List<Message> Messages;
	
	public Project(long projectID, String projectTitle, User owner, LocalDate creatDate) {
		
		this.iD = projectID;
		this.projectTitle = projectTitle;
		this.owner = owner;
		this.creatDate = creatDate;
	}
	
	public void newToDo(String name, String description, User instructedUser) {
		toDos.add(new ProjectToDo(toDos.size(), name, description, instructedUser));
	}
	
	public void newMessage(long iD, String message, User author) {
		Messages.add(new Message(iD, message, author));
	}
	
	public void addSubscriber(User subscriber) {
		subscribers.add(subscriber);
		subscriber.newProject(this);
	}

	public long getProjectID() {
		return iD;
	}


	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public LocalDate getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(LocalDate creatDate) {
		this.creatDate = creatDate;
	}


}
