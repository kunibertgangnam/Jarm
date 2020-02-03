package interfaces;

public interface BenutzerService {

	UserInterface userNew(String user, String password, String passwordRepeat);
	
	UserInterface userLogin(String user, String password);
}
