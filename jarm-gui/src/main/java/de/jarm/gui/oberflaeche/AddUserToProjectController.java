package de.jarm.gui.oberflaeche;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.main.data.DataController;

public class AddUserToProjectController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		int userId = (int) request.getAttribute("userId");
		int projectId = (int) request.getAttribute("projektId");
		try {
			DataController.getInstance().getProjectService().addSubscriber(DataController.getInstance().getProjectService().getProjectById(projectId), DataController.getInstance().getUserService().getUserById(userId));
		}catch (Exception e) {
			message.append(e.getMessage());
		}
		new ProjectController().execute(request, response, message);
		return "/projects/project";
	}
}