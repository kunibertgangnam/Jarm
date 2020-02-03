package classes;

import java.time.LocalDate;
import java.util.List;

public class Project {
		
	private long iD;
	private String title;
	private User owner;
	private LocalDate creationDate;
	private List<ProjectToDo> toDos;
	private List<User> subscribers;
	private List<Message> Messages;
	
	public Project(long iD, String title, User owner, LocalDate creationDate) {
		setID(iD);
		setTitle(title);
		setOwner(owner);
		setCreationDate(creationDate);
	}
	
	public Project(long iD, String title, User owner) {
		this(iD, title, owner, LocalDate.now());
	}
	
	public void newToDo(String name, String description, User instructedUser) {
		toDos.add(new ProjectToDo(toDos.size(), name, description, instructedUser));
	}
	
	public void writeMessage(long iD, String message, User author) {
		Messages.add(new Message(iD, message, author));
	}
	
	public void addSubscriber(User subscriber) {
		subscribers.add(subscriber);
		subscriber.newProject(this);
	}

	public long getProjectID() {
		return iD;
	}
	
	private void setID(long iD) {
		this.iD = iD;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creatDate) {
		this.creationDate = creatDate;
	}


}
