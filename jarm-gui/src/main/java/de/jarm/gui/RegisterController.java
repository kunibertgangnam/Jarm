package de.jarm.gui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.gui.utils.ValidierungsException;

public class RegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		if (request.getMethod().equals("POST")) {
			String email = request.getParameter("Email");
			String name = request.getParameter("Name");
			String passwort = request.getParameter("Passwort");
			String passwortNochmal = request.getParameter("Passwortwiederholung");
			String vorname = request.getParameter("Vorname");
					
//			try {
////				BenutzerServiceImpl.getInstance().comparePasswords(passwort, passwortNochmal);
////				Benutzer b = new Benutzer(name,email,passwort,vorname);
////				BenutzerServiceImpl.getInstance().neu(b);
////				NotificationBuilder.createSuccessNotification("Sie haben sich erfolgreich registriert!", request);
//				//request.getSession().setAttribute("user", b);
//				return "/secured/userArea";
//			} catch(ValidierungsException e) {
//				//NotificationBuilder.createErrorNotification(e.getMessage(), request);
//				request.setAttribute("emailValue", email);
//				request.setAttribute("nameValue", name);
//				request.setAttribute("vornameValue", name);
//			}					
		}
		return null;
	}		
}
