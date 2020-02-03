package classes;

import java.time.LocalDate;

public class Project {
		
	private long projectID;
	private String projectTitle;
	private User owner;
	private LocalDate creatDate;
	
	public Project(long projectID, String projectTitle, User owner, LocalDate creatDate) {
		
		this.projectID = projectID;
		this.projectTitle = projectTitle;
		this.owner = owner;
		this.creatDate = creatDate;
	}


}
