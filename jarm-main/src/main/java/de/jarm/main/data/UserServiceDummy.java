package de.jarm.main.data;

import java.util.ArrayList;
import java.util.List;

import de.jarm.main.interfaces.UserServiceInterface;
import de.jarm.main.utils.ValidierungsException;

public class UserServiceDummy implements UserServiceInterface {
	private List<User> userList;
	
	public UserServiceDummy() {//List<User> userList) {
		this.userList = new ArrayList<>();
		//TODO
		try {
			create(0, "Mami", "Nani");
			create(1, "Manni", "Manfred");
			create(2, "Manno", "Manfred", "h@gmx.de");
		} catch (ValidierungsException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User create(int id, String name, String password, String email) throws ValidierungsException {
		User newUser = new User(id, name, password, email);
		userList.add(newUser);
		return newUser;
	}
	
	public User create(int id, String name, String password) throws ValidierungsException {
		return create(id, name, password, null);
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

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public void remove(User user) {
		userList.remove(user);
		
	}

}
