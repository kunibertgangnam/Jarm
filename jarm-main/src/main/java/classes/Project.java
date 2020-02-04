package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {
		
	private int id;
	private String title;
	private User owner;
	private LocalDate creationDate;
	private List<ProjectToDo> todos = new ArrayList<ProjectToDo>();
	private List<User> subscribers = new ArrayList<User>();
	private List<Message> messages = new ArrayList<Message>();
	
	public Project(int id, String title, User owner, LocalDate creationDate) {
		setID(id);
		setTitle(title);
		setOwner(owner);
		setCreationDate(creationDate);
	}
	
	public Project(int id, String title, User owner) {
		this(id, title, owner, LocalDate.now());
	}
	
	public void addTodo(String name, String description, User instructedUser) {
		todos.add(new ProjectToDo(todos.size(), name, description, instructedUser));
	}
	
	public void addMessage(int id, String message, User author) {
		messages.add(new Message(id, message, author));
	}
	
	public void addSubscriber(User subscriber) {
		subscribers.add(subscriber);
		subscriber.newProject(this);
	}

	public int getId() {
		return id;
	}
	
	private void setID(int id) {
		this.id = id;
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
