package de.jarm.main.data;

import java.time.LocalDate;

public class Message {
	private int id;
	private String message;
	private LocalDate creationDate;
	private User author;
	
	public Message(String message, User author) {
		this(message, LocalDate.now(), author);
	}

	public Message(String message, LocalDate creationDate, User author) {
		setMessage(message);
		setCreationDate(creationDate);
		setAuthor(author);
	}
	
	public Message(int id, String message, LocalDate creationDate, User author) {
		this.id = id;
		this.message = message;
		this.creationDate = creationDate;
		this.author = author;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int iD) {
		this.id = iD;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate crationDate) {
		this.creationDate = crationDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	

	
	
	
}
