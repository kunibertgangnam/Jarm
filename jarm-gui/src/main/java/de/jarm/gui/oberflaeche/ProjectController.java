package de.jarm.gui.oberflaeche;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.gui.utils.JavaScriptFunctions;
import de.jarm.main.data.DataController;
import de.jarm.main.data.Project;

public class ProjectController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		int projectId = new Integer(request.getParameter("id"));
		
		try {
			Project p = DataController.getInstance().getProjectService().getProjectById(projectId);
			request.setAttribute("currentProject", p);
		} catch(Exception e) {
			message.append(e.getMessage());
		}
		
		request.setAttribute("script", JavaScriptFunctions.FIND_USER_FOR_TODO + " " + JavaScriptFunctions.FIND_USER_FOR_PROEJCT);
		
		return null;
	}

}
