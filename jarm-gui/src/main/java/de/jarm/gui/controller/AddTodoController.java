package de.jarm.gui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.utils.NotificationBuilder;
import de.jarm.main.data.Project;
import de.jarm.main.data.ProjectToDo;
import de.jarm.main.data.management.DataController;

public class AddTodoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		String titel = request.getParameter("Titel");
		String description = request.getParameter("Description");
		int projectId = new Integer(request.getParameter("projectId"));
		
		try {
			Project currentProject = DataController.getInstance().getProjectService().getProjectById(projectId);
			int newTodoId = DataController.getInstance().getProjectService().addToDo(currentProject, new ProjectToDo(titel, description));
			NotificationBuilder.addSuccessNotification(message, "Todo hinzugefügt!");
			
			request.setAttribute("todoId", newTodoId);
			
			new AddUserToTodoController().execute(request, response, message);
			
		} catch(Exception e){
			NotificationBuilder.addErrorNotification(message, e.getMessage());
		}
		
		new ProjectController().execute(request, response, message);
		return "/projects/project";
	}

}
