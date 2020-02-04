package bv.gui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import navi.Controller;

public class ForumController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		if (request.getMethod().equals("POST")) {
			String nachricht = request.getParameter("nachricht");
			nachrichtPruefen(nachricht);
			request.setAttribute("nachricht", null);
			//Nachrichten müssn noch iwie aus der Datenbank geholt werden und angezeigt werden
		}
		return null;
	}

	private void nachrichtPruefen(String nachricht) throws Exception {
		if(nachricht.equals(null)|| nachricht.equals("")|| nachricht.equals(" ")) {
			throw new Exception("Ungueltige Nachricht!");
		}
	}
}
