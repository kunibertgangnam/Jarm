package bv.gui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bv.daten.Benutzer;
import navi.Controller;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		
		if (request.getMethod().equals("POST")) {
			String email = request.getParameter("Email");
			String passwort = request.getParameter("Passwort");
			// wenn man sich erfolgreich eingeloggt hat ---> damit der Header richtig angezeigt wird
			request.getSession().setAttribute("eingeloggt", true);
			
			
			
//			Benutzer b = BenutzerServiceImpl.getInstance().login(email, passwort);
//			
//			if (b != null) {
//				message.append("Sie haben sich erfolgreich eingeloggt!");
//				//NotificationBuilder.createSuccessNotification("Sie haben sich erfolgreich eingeloggt!", request);
//				request.getSession().setAttribute("user", b);
//				return "/secured/userArea";
//			}
//			else {
//				message.append("Benutzername oder Passwort falsch!");
//				//NotificationBuilder.createErrorNotification("Benutzername oder Passwort falsch!", request);
//				request.setAttribute("emailValue", email);
//			}
		}
		return null;
	}
}
