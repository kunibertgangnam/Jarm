package de.jarm.gui.oberflaeche;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.main.data.DataController;
import de.jarm.main.data.Message;
import de.jarm.main.data.Project;
import de.jarm.main.data.User;
import de.jarm.main.utils.ValidierungsException;

public class ForumController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		if (request.getMethod().equals("POST")) {
			String nachricht = request.getParameter("nachricht");
			nachrichtPruefen(nachricht);
			request.setAttribute("nachricht", null);
			nachrichtEinfuegen(nachricht, request);
			request.getSession().setAttribute("nachrichten", nachrichtenAuslesen(request));
		}
		return null;
	}

	private Map<String, String> nachrichtenAuslesen(HttpServletRequest request) {
		Map<String, String> nachrichtenMitName = new HashMap<String, String>();
		Project jetzt = (Project) request.getAttribute("projekt");
		List<Message> messages = jetzt.getMessages();
		for (Message m : messages) {
			nachrichtenMitName.put(m.getAuthor().getName(), m.getMessage());
		}
		return nachrichtenMitName;
	}

	private void nachrichtEinfuegen(String nachricht, HttpServletRequest request) throws ValidierungsException {
		DataController.getInstance().getProjectService().writeMessage((Project) request.getAttribute("projekt"), nachricht, (User) request.getSession().getAttribute("user"));
	}

	private void nachrichtPruefen(String nachricht) throws Exception {
		if(nachricht.equals(null)|| nachricht.equals("")|| nachricht.equals(" ")) {
			throw new Exception("Ungueltige Nachricht!");
		}
	}
}
