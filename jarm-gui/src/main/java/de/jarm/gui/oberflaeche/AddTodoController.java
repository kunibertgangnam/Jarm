package de.jarm.gui.oberflaeche;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.main.data.DataController;
import de.jarm.main.data.Project;
import de.jarm.main.data.ProjectToDo;

public class AddTodoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		String titel = request.getParameter("Titel");
		String description = request.getParameter("Description");
		int projectId = new Integer(request.getParameter("id"));
		
		try {
			Project currentProject = DataController.getInstance().getProjectService().getProjectById(projectId);
			DataController.getInstance().getProjectService().addToDo(currentProject, new ProjectToDo(titel, description));
			message.append("Todo hinzugefügt!");
		} catch(Exception e){
			message.append(e.getMessage());
		}
		
		System.out.println(titel + " " + description);
		new ProjectController().execute(request, response, message);
		return "/projects/project";
	}

}
