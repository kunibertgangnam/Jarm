package de.jarm.main.interfaces;

import de.jarm.main.data.User;
import de.jarm.main.utils.ValidierungsException;

public interface UserServiceInterface {

	public User create(String name, String password, String email) throws ValidierungsException;
	
	public User create(String name, String password) throws ValidierungsException;
	
	public User login(String user, String password);
	
	public void remove(User user);

	public User getUser(String string);
	
	public User getUser(int id);
}
