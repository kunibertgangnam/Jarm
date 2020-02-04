package interfaces;

import classes.User;
import utils.ValidierungsException;

public interface UserService {

	User newU(User user) throws ValidierungsException;
	
	User login(String user, String password);
}
