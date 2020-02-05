package de.jarm.gui.oberflaeche;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.main.data.DataController;
import de.jarm.main.data.Project;
import de.jarm.main.data.User;

public class InfokastenController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		String projektName = (String) request.getSession().getAttribute("imProjekt");
		List<String> mitglieder = nutzerAuslesen(projektName);
		request.getSession().setAttribute("mitglieder", mitglieder);
		return null;
	}

	private List<String> nutzerAuslesen(String projektName) {
		 List<Project> projekte = DataController.getInstance().getProjectService().getProjectList();
		 List<String> namenMitglieder = new ArrayList<>();
		 for (Project p : projekte) {
			 if(p.getTitle().equals(projektName)) {
				int id = p.getId();
				List<User> user = DataController.getInstance().getProjectService().getProject(id).getSubscribers();
				for(User u : user) {
					namenMitglieder.add(u.getName());
				 }
				break;
			 }
		 } 
		return namenMitglieder;
	}
}