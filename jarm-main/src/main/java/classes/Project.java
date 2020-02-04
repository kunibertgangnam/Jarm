package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {
		
	private int iD;
	private String title;
	private User owner;
	private LocalDate creationDate;
	private List<ProjectToDo> toDos = new ArrayList<>();
	private List<User> subscribers = new ArrayList<>();
	private List<Message> messages = new ArrayList<>();
	
	public List<ProjectToDo> getToDos() {
		return toDos;
	}

	public void setToDos(List<ProjectToDo> toDos) {
		this.toDos = toDos;
	}

	public List<User> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(List<User> subscribers) {
		this.subscribers = subscribers;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Project(int iD, String title, User owner, LocalDate creationDate) {
		setID(iD);
		setTitle(title);
		setOwner(owner);
		setCreationDate(creationDate);
	}
	
	
	public Project(int iD, String title, User owner) {
		this(iD, title, owner, LocalDate.now());
	}
	

	public int getID() {
		return iD;
	}
	
	private void setID(int iD) {
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
