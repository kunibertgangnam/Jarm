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
		int projektId = (int) request.getAttribute("projektId");
		try {
			DataController.getInstance().getProjectService().addSubscriber(DataController.getInstance().getProjectService().getProjectById(projektId), DataController.getInstance().getUserService().getUser(userId));
			new ProjectController().execute(request, response, message);
		}catch (Exception e) {
			message.append(e.getMessage());
		}
		return "/projects/project";
	}

}