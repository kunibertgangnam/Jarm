package de.jarm.gui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.utils.NotificationBuilder;
import de.jarm.main.data.management.DataController;

public class RemoveUserFromProjectController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		String projectIdString = request.getParameter("projectId");
		String userIdString = request.getParameter("userId");
		
		if (projectIdString != null && userIdString != null) {
			
			try {
				
				DataController.getInstance().getProjectService().removeSubscriber(new Integer(projectIdString), new Integer(userIdString));
				NotificationBuilder.addSuccessNotification(message, "User erfolgreich aus Projekt entfernt!");
				
			} catch(Exception e) {
				NotificationBuilder.addErrorNotification(message, e.getMessage());
			}
		}
		
		new ProjectController().execute(request, response, message);
		return "/projects/project";
	}

}
