package bv.gui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.main.data.User;

public class UserAreaController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		User u = (User) request.getSession().getAttribute("user");
		
		if (u == null) {
			return "/bv/login";
		}
		
//		Benutzer b = (Benutzer) request.getSession().getAttribute("user");
//		if (b == null) {
//			NotificationBuilder.createErrorNotification("Dafür musst du dich zunächst anmelden!", request);
//			return "/error/error";
//		}
		
		return null;
	}

}
