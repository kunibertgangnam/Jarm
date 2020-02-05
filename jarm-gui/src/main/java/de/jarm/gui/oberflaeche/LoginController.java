package de.jarm.gui.oberflaeche;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.main.data.DataController;
import de.jarm.main.data.User;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		
		if (request.getMethod().equals("POST")) {
			String email = request.getParameter("Email");
			String passwort = request.getParameter("Passwort");

			User u = DataController.getInstance().getUserService().login(email, passwort);
			
			if (u != null) {
				message.append("Sie haben sich erfolgreich eingeloggt!");
				request.getSession().setAttribute("user", u);
				new UserAreaController().execute(request, response, message);
				return "/secured/projekt";
			}
			else {
				message.append("Benutzername oder Passwort falsch!");
				request.setAttribute("emailValue", email);
			}
		}
		return null;
	}
}
