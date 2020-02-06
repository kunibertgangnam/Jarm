package de.jarm.gui.navi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.oberflaeche.ProjectController;
import de.jarm.gui.oberflaeche.UserAreaController;

public class AddMessageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		new ProjectController().execute(request, response, message);
		return "/projects/project";
	}

}
