package classes;

import java.time.LocalDate;

public class ProjectToDo {
	long iD;
	String name;
	String description;
	int state; //0 == unbearbeitet, 1 == in Arbei, 2 == fertig
	//Automatisch
	User instructedUser;
	LocalDate crationDate;
	
	public ProjectToDo(long iD, String name, String description, User instructedUser, int state, LocalDate crationDate) {
		setID(iD);
		setName(name);
		setDescription(description);
		setState(state);
		setInstructedUser(instructedUser);
		setCrationDate(crationDate);
	}
	public ProjectToDo(long iD, String name, String description, User instructedUser) {
		this(iD, name, description, instructedUser, 0, LocalDate.now());
	}

	public long getID() {
		return iD;
	}

	private void setID(long iD) {
		this.iD = iD;
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
		return crationDate;
	}

	private void setCrationDate(LocalDate crationDate) {
		this.crationDate = crationDate;
	}


}
