package interfaces;

import data.User;
import utils.ValidierungsException;

public interface UserService {

	User create(User user) throws ValidierungsException;
	
	User login(String user, String password);
}
