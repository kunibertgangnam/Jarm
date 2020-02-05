package de.jarm.gui.oberflaeche;

import java.util.ArrayList;
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

public class ForumController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		if (request.getMethod().equals("POST")) {
			String nachricht = request.getParameter("nachricht");
			nachrichtPruefen(nachricht);
			request.setAttribute("nachricht", null);
			nachrichtEinfuegen(nachricht, request);
			request.getSession().setAttribute("nachrichten", nachrichtenAusgeben());
		}
		return null;
	}

	private Map<String, String> nachrichtenAusgeben() {
		Map<String, String> nachrichtenMitName = new HashMap<String, String>();
		List<Message> ausgelesen = new ArrayList<>();
		ausgelesen = DataController.getInstance().getProjectService().getProjectList().get(2).getMessages();
		//nur zu Testzwecken
		nachrichtenMitName.put(ausgelesen.get(ausgelesen.size()-1).getAuthor().toString(),ausgelesen.get(ausgelesen.size()-1).getMessage());
		
		return nachrichtenMitName;
	}

	private void nachrichtEinfuegen(String nachricht, HttpServletRequest request) {
		DataController.getInstance().getProjectService().writeMessage((Project)request.getSession().getAttribute("projektName"), nachricht, (User) request.getSession().getAttribute("eingeloggt"));
	}

	private void nachrichtPruefen(String nachricht) throws Exception {
		if(nachricht.equals(null)|| nachricht.equals("")|| nachricht.equals(" ")) {
			throw new Exception("Ungueltige Nachricht!");
		}
	}
}