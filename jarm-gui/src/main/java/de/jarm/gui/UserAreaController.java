package de.jarm.gui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;

public class UserAreaController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
//		Benutzer b = (Benutzer) request.getSession().getAttribute("user");
//		if (b == null) {
//			NotificationBuilder.createErrorNotification("Dafür musst du dich zunächst anmelden!", request);
//			return "/error/error";
//		}
		
		return null;
	}

}
