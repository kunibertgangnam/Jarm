package de.jarm.gui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.utils.NotificationBuilder;
import de.jarm.main.data.Project;
import de.jarm.main.data.User;
import de.jarm.main.data.management.DataController;

public class AddMessageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		String id = request.getParameter("id");
		
		if(id!=null) {
			try {
				int projectId = new Integer(id);
				Project p = DataController.getInstance().getProjectService().getProjectById(projectId);
				request.setAttribute("currentProject", p);
				if(!request.getParameter("message").equals("")){
					DataController.getInstance().getProjectService().
					writeMessage(p, ""+request.getParameter("message"), (User) request.getSession().getAttribute("user"));					
				}
				NotificationBuilder.addSuccessNotification(message, "Nachricht erfolgreich hinzugefügt!");
				
			} catch(Exception e) {
				NotificationBuilder.addErrorNotification(message, e.getMessage());
			}
		} 
		
		new ProjectController().execute(request, response, message);
		return "/projects/project";
	}

}
