package de.jarm.gui.oberflaeche;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.main.data.DataController;

public class AddUserToProjectController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		Object userIdObjectToAdd = request.getParameter("AddedUserIdsProject");
		
		if (userIdObjectToAdd != null) {
			String userIdsStringToAdd = userIdObjectToAdd.toString();
			
			String[] userIdArray = userIdsStringToAdd.split(" ");

			List<Integer> idListToAdd = new ArrayList<Integer>();
			
			for (String idString : userIdArray) {
				if (!idString.equals("")) {
					int thisId = new Integer(idString);
					idListToAdd.add(thisId);
				}
			}
			
			int projectId = new Integer( request.getParameter("id"));
			try {			
				for (Integer i : idListToAdd) {
					DataController.getInstance().getProjectService().addSubscriber(DataController.getInstance().getProjectService().getProjectById(projectId), DataController.getInstance().getUserService().getUserById(i));
				}
			}catch (Exception e) {
				message.append(e.getMessage());
			}
		}
		
		
		new ProjectController().execute(request, response, message);
		return "/projects/project";
	}
}