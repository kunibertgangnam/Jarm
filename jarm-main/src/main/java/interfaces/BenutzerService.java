package interfaces;

public interface BenutzerService {

	User userNew(String user, String password, String passwordRepeat);
	
	User userLogin(String user, String password);
}
