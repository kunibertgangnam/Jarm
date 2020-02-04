package classes;

import java.time.LocalDate;

public class ProjectToDo {
	int id;
	String name;
	String description;
	int state; //0 == unbearbeitet, 1 == in Arbei, 2 == fertig
	//Automatisch
	User instructedUser;
	LocalDate creationDate;
	
	public ProjectToDo(int id, String name, String description, User instructedUser, int state, LocalDate crationDate) {
		setID(id);
		setName(name);
		setDescription(description);
		setState(state);
		setInstructedUser(instructedUser);
		setCrationDate(crationDate);
	}
	public ProjectToDo(int id, String name, String description, User instructedUser) {
		this(id, name, description, instructedUser, 0, LocalDate.now());
	}

	public long getID() {
		return id;
	}

	private void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public User getInstructedUser() {
		return instructedUser;
	}

	public void setInstructedUser(User instructedUser) {
		this.instructedUser = instructedUser;
	}

	public LocalDate getCrationDate() {
		return creationDate;
	}

	private void setCrationDate(LocalDate crationDate) {
		this.creationDate = crationDate;
	}


}
