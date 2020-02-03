package interfaces;

public interface BenutzerService {

	Benutzer userNew(String user, String password, String passwordRepeat);
	
	Benutzer userLogin(String user, String password);
}
