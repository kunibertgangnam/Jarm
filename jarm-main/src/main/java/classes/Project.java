package classes;

import java.time.LocalDate;

public class Project {
		
	private long iD;
	private String projectTitle;
	private User owner;
	private LocalDate creatDate;
	
	public Project(long projectID, String projectTitle, User owner, LocalDate creatDate) {
		
		this.iD = projectID;
		this.projectTitle = projectTitle;
		this.owner = owner;
		this.creatDate = creatDate;
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
