package de.jarm.main.data;

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
	
	public Message(String message, User author) {
		this(message, LocalDate.now(), author);
	}

	public Message(String message, LocalDate creationDate, User author) {
		setMessage(message);
		setCreationDate(creationDate);
		setAuthor(author);
	}
	
	
	
}
