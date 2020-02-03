package classes;

import java.time.LocalDate;

public class ProjectToDo {
	long iD;
	String name;
	String description;
	byte state; //0 == unbearbeitet, 1 == in Arbei, 2 == fertig
	User instructedUser;
	LocalDate crationDate;
	long projectID;
	
	public ProjectToDo(long iD, String name, String description, byte state, User instructedUser, LocalDate crationDate,
			long projectID) {
		setID(iD);
		setName(name);
		setDescription(description);
		setState(state);
		setInstructedUser(instructedUser);
		setCrationDate(crationDate);
		setProjectID(projectID);
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

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
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

	public long getProjectID() {
		return projectID;
	}

	private void setProjectID(long projectID) {
		this.projectID = projectID;
	}

}
