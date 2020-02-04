package de.jarm.main.data;

import java.util.List;

import de.jarm.main.interfaces.UserServiceInterface;
import de.jarm.main.utils.ValidierungsException;

public class UserServiceDummy implements UserServiceInterface {
	private List<User> userList;
	
	@Override
	public User create(int id, String name, String password, String email) throws ValidierungsException {
		User newUser = new User(id, name, password, email);
		userList.add(newUser);
		return newUser;
	}

	@Override
	public User login(String user, String password) {
		for (User userFromList : userList) {
			if(userFromList.getName().equals(user) && userFromList.getPassword().equals(password)) {
				return userFromList;
			}
		}
		return null;
	}

	@Override
	public void remove(User user) {
		userList.remove(user);
		
	}

}
