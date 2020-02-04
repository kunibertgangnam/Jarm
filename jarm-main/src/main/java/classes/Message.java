package classes;

import java.time.LocalDate;

public class Message {
	private int iD;
	private String message;
	private LocalDate crationDate;
	private User author;
	
	public int getID() {
		return iD;
	}

	private void setID(int iD) {
		this.iD = iD;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getCreationDate() {
		return crationDate;
	}

	public void setCreationDate(LocalDate crationDate) {
		this.crationDate = crationDate;
	}

	public User getAuthor() {
		return author;
	}

	private void setAuthor(User author) {
		this.author = author;
	}
	
	public Message(int iD, String message, User author) {
		this(iD, message, LocalDate.now(), author);
	}

	public Message(int iD, String message, LocalDate creationDate, User author) {
		setID(iD);
		setMessage(message);
		setCreationDate(creationDate);
		setAuthor(author);
	}
	
	
	
}
