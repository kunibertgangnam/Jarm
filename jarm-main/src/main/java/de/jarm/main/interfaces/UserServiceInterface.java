package de.jarm.main.interfaces;

import de.jarm.main.data.User;
import de.jarm.main.utils.ValidierungsException;

public interface UserServiceInterface {

	User create(int id, String name, String password, String email) throws ValidierungsException;
	
	User login(String user, String password);
	
	void remove(User user);
}
