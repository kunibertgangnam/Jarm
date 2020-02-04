package de.jarm.gui.oberflaeche;

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
			new LoginController().execute(request, response, message);
			return "/bv/login";
		}
		
		return null;
	}

}
