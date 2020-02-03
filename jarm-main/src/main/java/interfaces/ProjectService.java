package interfaces;

public interface ProjectService {

	void newProject(String projectname);
	void loadMessages();
	void loadUser();
	void loadToDo();
	void writeMessage();
	void invite(String user);
	void deletProject(String projectname);
	void removeUser(String user);
	void removeMessage();
	void removeTodo();
}
