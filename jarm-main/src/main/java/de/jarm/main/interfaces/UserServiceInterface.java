package de.jarm.main.interfaces;

import de.jarm.main.data.User;
import de.jarm.main.utils.ValidierungsException;

public interface UserServiceInterface {

	User create(User user) throws ValidierungsException;
	
	User login(String user, String password);
}
