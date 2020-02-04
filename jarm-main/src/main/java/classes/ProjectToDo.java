package classes;

import java.time.LocalDate;
import java.util.List;

public class ProjectToDo {
	int iD;
	String name;
	String description;
	int state; //0 == unbearbeitet, 1 == in Arbei, 2 == fertig
	//Automatisch
	public static final int UNBEARBEITET = 0;
	public static final int IN_ARBEIT = 1;
	public static final int FERTIG = 2;
	List<User> instructedUsers;
	LocalDate crationDate;
	
	public ProjectToDo(int iD, String name, String description, List<User> instructedUsers, int state, LocalDate crationDate) {
		setID(iD);
		setName(name);
		setDescription(description);
		setState(state);
		setInstructedUsers(instructedUsers);
		setCrationDate(crationDate);
	}
	public ProjectToDo(int iD, String name, String description, List<User> instructedUsers) {
		this(iD, name, description, instructedUsers, 0, LocalDate.now());
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
	
	public int getID() {
		return iD;
	}

	private void setID(int iD) {
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


	public LocalDate getCrationDate() {
		return crationDate;
	}

	private void setCrationDate(LocalDate crationDate) {
		this.crationDate = crationDate;
	}


}
