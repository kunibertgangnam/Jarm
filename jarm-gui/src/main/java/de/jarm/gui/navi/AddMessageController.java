package de.jarm.gui.navi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.oberflaeche.ProjectController;
import de.jarm.gui.oberflaeche.UserAreaController;
import de.jarm.main.data.DataController;
import de.jarm.main.data.Project;
import de.jarm.main.data.User;

public class AddMessageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		Object id = request.getAttribute("id");
		int projectId;
		
		if(id!=null) {
			projectId = (int)id;
			Project p = DataController.getInstance().getProjectService().getProjectById(projectId);
			request.setAttribute("currentProject", p);
			if(request.getMethod().equals("POST")) {
				if(!request.getParameter("message").equals("")){
					DataController.getInstance().getProjectService().
					writeMessage(p, ""+request.getAttribute("message"), (User) request.getSession().getAttribute("user"));					}
			}
		}
		
		new ProjectController().execute(request, response, message);
		return "/projects/project";
	}

}
