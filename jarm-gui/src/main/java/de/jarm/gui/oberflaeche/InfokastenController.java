package de.jarm.gui.oberflaeche;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.main.data.DataController;
import de.jarm.main.data.Project;
import de.jarm.main.data.User;
import de.jarm.main.utils.ValidierungsException;

public class InfokastenController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		String projektName = (String)request.getAttribute("projekt");
		List<String> mitglieder = nutzerAuslesen(projektName, (User)request.getSession().getAttribute("user"));
		request.getSession().setAttribute("mitglieder", mitglieder);
		return null;
	}

	private List<String> nutzerAuslesen(String projektName, User user) throws ValidierungsException {
		List<Project> projekte = DataController.getInstance().getProjectService().getProjectsByUser(user);
		List<String> namenMitglieder = new ArrayList<>();;
		for(Project p : projekte) {
			if(p.getTitle().equals(projektName)) {
				List<User> mitglieder = p.getSubscribers();
				for(User u : mitglieder) {
					namenMitglieder.add(u.getName());
				}
			}
		}
		return namenMitglieder;
	}
}