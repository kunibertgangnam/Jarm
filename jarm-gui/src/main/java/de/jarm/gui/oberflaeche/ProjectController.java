package de.jarm.gui.oberflaeche;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.main.data.DataController;
import de.jarm.main.data.Message;
import de.jarm.main.data.Project;
import de.jarm.main.data.User;

public class ProjectController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		
		
		
		try {
			Object id = request.getAttribute("id");
			int projectId;
			
			if(id!=null) {
				projectId = (int)id;
				Project p = DataController.getInstance().getProjectService().getProjectById(projectId);
				request.setAttribute("currentProject", p);
				List<Message> messagesList = p.getMessages();
				if(request.getMethod().equals("POST")) {
					if(!request.getParameter("message").equals("")){
						messagesList.add(new Message(request.getParameter("message"), (User)request.getSession().getAttribute("user")));
						p.setMessages(messagesList);
					}
				}
				
				String messages = "";
				for(int i = messagesList.size()-1; i > messagesList.size()-51 && i > 0; i--) {
					messages += "<font style=\"font-weight=bold\">"+ messagesList.get(i).getAuthor().getName()+ "</font><br>" + 
					messagesList.get(i).getMessage()+ "<br><br>";
				}
				
				request.setAttribute("nachrichten", messages);
			}	
		} catch(Exception e) {
			message.append(e.getMessage());
		}
		
		
		return null;
	}

}