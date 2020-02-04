package de.jarm.gui.oberflaeche;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.oberflaeche.navi.Controller;

public class LogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		//NotificationBuilder.createNotification("Sie haben sich erfolgreich ausgeloggt!", request);
		request.getSession().invalidate();
		request.getSession().setAttribute("eingeloggt", null);
		//new InfoController().execute(request, response, message);
		return "/test/info";
	}

}
