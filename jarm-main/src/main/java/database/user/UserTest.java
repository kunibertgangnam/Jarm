package database.user;

import de.jarm.main.data.User;
import de.jarm.main.database.exceptions.UserExistsException;

public class UserTest {

	private static UserDAO userDao = new UserDAO();
	
	public static void main(String[] args) {
		
		System.out.println("TEST 1 - USER ADDEN --------------------");
		User u;
		try {
			u = userDao.addUser(new User("Jonas", "123", "test"));
			System.out.println("ERFOLGREICH");
		} catch (UserExistsException e) {
			System.out.println("FEHLER " + e.getMessage());
		}

		
		System.out.println("\n\nTEST 2 - LOGIN --------------------");
		u = userDao.logIn("test", "123");
		if (u == null) {
			System.out.println("FEHLER");
		} else {
			System.out.println("ERFOLGREICH");
		}
		

	}

}
