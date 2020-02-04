package database.user;

import de.jarm.main.data.User;

public class UserTest {

	private static UserDAO userDao = new UserDAO();
	
	public static void main(String[] args) {
		
		System.out.println("TEST 1 - USER ADDEN --------------------");
		User u = userDao.addUser(new User("Jonas", "123", "test"));
		if (u == null) {
			System.out.println("FEHLER");
		} else {
			System.out.println("ERFOLGREICH");
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
