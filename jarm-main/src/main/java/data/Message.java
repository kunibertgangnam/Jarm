package data;

import java.time.LocalDate;

public class Message {
	private int id;
	private String message;
	private LocalDate crationDate;
	private User author;
	
	public int getId() {
		return id;
	}

	private void setId(int iD) {
		this.id = iD;
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
		setId(iD);
		setMessage(message);
		setCreationDate(creationDate);
		setAuthor(author);
	}
	
	
	
}
