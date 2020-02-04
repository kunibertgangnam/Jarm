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
	
	public void removeMessage(Message messageToRemove) {
		if(messages.contains(messageToRemove)) {
			messages.remove(messageToRemove);
		}
	}
	
	public void removeSubscriber(User subscriberToRemove) {
		if(subscribers.contains(subscriberToRemove)) {
			subscribers.remove(subscriberToRemove);
		}
	}
	
	public Project(int iD, String title, User owner) {
		this(iD, title, owner, LocalDate.now());
	}
	
	public void newToDo(String name, String description, User instructedUser) {
		toDos.add(new ProjectToDo(toDos.size(), name, description, instructedUser));
	}
	
	public void writeMessage(int iD, String message, User author) {
		messages.add(new Message(iD, message, author));
	}
	
	public void addSubscriber(User subscriber) {
		subscribers.add(subscriber);
		subscriber.newProject(this);
	}

	public int getProjectID() {
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
