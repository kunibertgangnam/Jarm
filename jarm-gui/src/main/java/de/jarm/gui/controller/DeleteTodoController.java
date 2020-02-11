package de.jarm.gui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.utils.NotificationBuilder;
import de.jarm.main.data.management.DataController;

public class DeleteTodoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		String projectIdString = request.getParameter("projectId");
		String todoIdString = request.getParameter("todoId");
		
		if (projectIdString != null && todoIdString != null) {
			
			try {
				
				DataController.getInstance().getProjectService().removeTodoById(new Integer(todoIdString), new Integer(projectIdString));
				NotificationBuilder.addSuccessNotification(message, "Todo erfolgreich entfernt!");
				
			} catch(Exception e) {
				NotificationBuilder.addErrorNotification(message, e.getMessage());
			}
		}
		
		new ProjectController().execute(request, response, message);
		return "/projects/project";
	}

}
