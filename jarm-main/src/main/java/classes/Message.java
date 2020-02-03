package classes;

import java.time.LocalDate;

public class Message {
	private int id;
	private String message;
	private LocalDate creationDate;
	private User author;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public Message(int id, String message, User author) {
		this(id, message, LocalDate.now(), author);
	}

	public Message(int id, String message, LocalDate creationDate, User author) {
		setId(id);
		setMessage(message);
		setCreationDate(creationDate);
		setAuthor(author);
	}
	
	
	
}
