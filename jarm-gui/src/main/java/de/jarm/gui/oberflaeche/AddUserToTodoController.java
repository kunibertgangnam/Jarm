package de.jarm.gui.oberflaeche;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.main.data.DataController;
import de.jarm.main.data.Project;
import de.jarm.main.data.ProjectToDo;
import de.jarm.main.data.User;

public class AddUserToTodoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {

		
		int userId = new Integer(request.getParameter("userToAdd"));
		int todoId = new Integer(request.getParameter("todo"));
		int currentProjectId = new Integer(request.getParameter("currentProject"));
		
		try {
			Project currentProject = DataController.getInstance().getProjectService().getProjectById(currentProjectId);
			User userToAdd = DataController.getInstance().getUserService().getUserById(userId);
			
			for (ProjectToDo t : currentProject.getToDos()) {
				if (t.getId() == todoId) {
					DataController.getInstance().getProjectService().addUserToTodo(t, userToAdd);
					break;
				}
			}
			message.append("User erfolgreich zum Projekt hinzugefügt");
			
		} catch(Exception e) {
			message.append(e.getMessage());
		}
		
		new ProjectController().execute(request, response, message);
		return "/projects/project";
	}

}
