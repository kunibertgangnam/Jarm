package de.jarm.gui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.utils.NotificationBuilder;
import de.jarm.main.data.User;
import de.jarm.main.data.management.DataController;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		
		if (request.getMethod().equals("POST")) {
			String email = request.getParameter("Email");
			String passwort = request.getParameter("Passwort");
			
			try {
				User u = DataController.getInstance().getUserService().login(email, passwort);
				if (u != null) {
					NotificationBuilder.addSuccessNotification(message, "Sie haben sich erfolgreich eingeloggt!");
					request.getSession().setAttribute("user", u);
					new ProjectListController().execute(request, response, message);
					return "/projects/projectList";
				}
				else {
					NotificationBuilder.addSuccessNotification(message, "Benutzername oder Passwort falsch!");
					request.setAttribute("emailValue", email);
				}
			} catch(Exception e) {
				NotificationBuilder.addErrorNotification(message, e.getMessage());
			}
		}
		return null;
	}
}
