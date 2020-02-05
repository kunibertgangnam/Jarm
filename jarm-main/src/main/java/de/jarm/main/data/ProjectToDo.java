package de.jarm.main.data;

import java.time.LocalDate;
import java.util.List;

public class ProjectToDo {
	int id;
	String name;
	String description;
	int state; //0 == unbearbeitet, 1 == in Arbei, 2 == fertig
	//Automatisch
	public enum State{
		UNBEAEBEITET, IN_ARBEIT, FERTIG
	}
	List<User> instructedUsers;
	LocalDate creationDate;
	
	public ProjectToDo(String name, String description) {
		this.name = name;
		this.description = description;
		state = 0;
		creationDate = LocalDate.now();
	}
	
	public ProjectToDo(int id, String name, String description, List<User> instructedUsers, int state, LocalDate creationDate) {
		setId(id);
		setName(name);
		setDescription(description);
		setState(state);
		setInstructedUsers(instructedUsers);
		setCrationDate(creationDate);
	}
	
	public ProjectToDo(int id, String name, String description, List<User> instructedUsers) {
		this(id, name, description, instructedUsers, 0, LocalDate.now());
	}

	public List<User> getInstructedUsers() {
		return instructedUsers;
	}
	public void setInstructedUsers(List<User> instructedUsers) {
		this.instructedUsers = instructedUsers;
	}
	public ProjectToDo(List<User> instructedUsers) {
		this.instructedUsers = instructedUsers;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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


	public LocalDate getCrationDate() {
		return creationDate;
	}

	public void setCrationDate(LocalDate crationDate) {
		this.creationDate = crationDate;
	}


}
