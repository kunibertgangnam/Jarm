package de.jarm.main.interfaces;

import de.jarm.main.data.User;
import de.jarm.main.utils.ValidierungsException;

public interface UserServiceInterface {

	public User create(int id, String name, String password, String email) throws ValidierungsException;
	
	public User login(String user, String password);
	
	void remove(User user);
}
