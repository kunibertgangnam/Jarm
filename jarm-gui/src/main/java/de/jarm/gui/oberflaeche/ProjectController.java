package de.jarm.gui.oberflaeche;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.gui.utils.JavaScriptFunctions;
import de.jarm.main.data.DataController;
import de.jarm.main.data.Message;
import de.jarm.main.data.Project;
import de.jarm.main.data.User;

public class ProjectController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		
		String projectIdString;
		
		if (request.getMethod().equals("GET")) {
			projectIdString = request.getParameter("projectId");
		} else {
			projectIdString = request.getParameter("id");
		}
		int projectId = new Integer(projectIdString);
		Project p = DataController.getInstance().getProjectService().getProjectById(projectId);
		request.setAttribute("currentProject", p);
		
//		User u = (User)request.getAttribute("user");
//		if(!(p.getOwner().getId()==u.getId()||p.getSubscribers().contains(u))) {
//			return "/secured/projektList";
//		}

		
		request.setAttribute("script", JavaScriptFunctions.FIND_USER_FOR_TODO + " " + JavaScriptFunctions.FIND_USER_FOR_PROEJCT);
		
		try {

			
			
			List<Message> messagesList = p.getMessages();
			Collections.reverse(messagesList);
			
			request.setAttribute("nachrichten", messagesList);
//			String messages = "";
//			for (int i = messagesList.size() - 1; i > messagesList.size() - 51 && i > 0; i--) {
//				messages += "<font style=\"font-weight=bold\">" + messagesList.get(i).getAuthor().getName()
//						+ "</font><br>" + messagesList.get(i).getMessage() + "<br><br>";
//			}

			//request.setAttribute("nachrichten", messages);
			
		} catch (Exception e) {
			message.append(e.getMessage());
		}
		
		return null;
	}

}
