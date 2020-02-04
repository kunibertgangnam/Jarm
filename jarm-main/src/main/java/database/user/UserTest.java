package database.user;

import de.jarm.main.data.User;
import de.jarm.main.database.exceptions.UserExistsException;

public class UserTest {

	private static UserDAO userDao = new UserDAO();
	
	public static void main(String[] args) {
		User u;
		System.out.println("TEST 1 - USER ADDEN --------------------");
		try {
			u = userDao.addUser(new User("Jonas", "123", "test"));
			System.out.println("ERFOLGREICH");
		} catch (Exception e) {
			System.out.println("FEHLER " + e.getMessage());
		}

		
		System.out.println("\n\nTEST 2 - LOGIN --------------------");
		try {
			u = userDao.logIn("test", "123");
			System.out.println("ERFOLGREICH");
		} catch (Exception e) {
			System.out.println("FEHLER " + e.getMessage());
		}
		
		System.out.println("\n\nTEST 3 - LOGIN MIT FALSCHEM PW --------------------");
		try {
			u = userDao.logIn("test", "1234");
			System.out.println("FEHLER ");
		} catch (Exception e) {
			System.out.println("ERFOLGREICH " + e.getMessage());
		}
		
		System.out.println("\n\nTEST 4 - LOGIN MIT NICHT VORHANDENEM USER --------------------");
		try {
			u = userDao.logIn("test123", "1234");
			System.out.println("FEHLER ");
		} catch (Exception e) {
			System.out.println("ERFOLGREICH " + e.getMessage());
		}
		
		
		System.out.println("\n\nTEST 5 - SELBER USER ERNEUT ANLEGEN --------------------");
		try {
			u = userDao.addUser(new User("Jonas", "123", "test"));
			System.out.println("FEHLER");
		} catch (Exception e) {
			System.out.println("ERFOLGREICH " + e.getMessage());
		}
	}

}
