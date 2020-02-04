package bv.gui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.main.data.DataController;
import navi.Controller;

public class ForumController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		if (request.getMethod().equals("POST")) {
			String nachricht = request.getParameter("nachricht");
			nachrichtPruefen(nachricht);
			request.setAttribute("nachricht", null);
			nachrichtEinfuegen(nachricht, request);
			nachrichtenAusgeben();
		}
		return null;
	}

	private void nachrichtenAusgeben() {
		//DataController.getInstance().getProjectService()
	}

	private void nachrichtEinfuegen(String nachricht, HttpServletRequest request) {
		DataController.getInstance().getProjectService().writeMessage(request.getSession().getAttribute("projektName"), id, nachricht, request.getSession().getAttribute("eingeloggt"));
	}

	private void nachrichtPruefen(String nachricht) throws Exception {
		if(nachricht.equals(null)|| nachricht.equals("")|| nachricht.equals(" ")) {
			throw new Exception("Ungueltige Nachricht!");
		}
	}
}