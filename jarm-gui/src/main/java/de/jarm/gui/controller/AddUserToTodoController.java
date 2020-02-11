package de.jarm.gui.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.utils.NotificationBuilder;
import de.jarm.main.data.Project;
import de.jarm.main.data.ProjectToDo;
import de.jarm.main.data.User;
import de.jarm.main.data.management.DataController;

public class AddUserToTodoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		String userIdsStringToAdd = request.getParameter("AddedUserIdsTodo");
		System.out.println(userIdsStringToAdd);
		
		if (userIdsStringToAdd != null) {			
			String[] userIdArray = userIdsStringToAdd.split(" ");

			List<Integer> idListToAdd = new ArrayList<Integer>();
			
			for (String idString : userIdArray) {
				if (!idString.equals("") && !idString.equals(" ")) {
					int thisId = new Integer(idString);
					idListToAdd.add(thisId);
					System.out.println("Adding user with id " + thisId);
				}
			}
			
			int todoId = new Integer(request.getAttribute("todoId").toString());
			int projectId = new Integer(request.getParameter("projectId"));
			
			try {
				Project currentProject = DataController.getInstance().getProjectService().getProjectById(projectId);
				
				for (ProjectToDo t : currentProject.getToDos()) {
					if (t.getId() == todoId) {					
						for (Integer i : idListToAdd) {
							User userToAdd = DataController.getInstance().getUserService().getUserById(i);
							DataController.getInstance().getProjectService().addUserToTodo(t, userToAdd);
						}		
						break;
					}
				}
				NotificationBuilder.addSuccessNotification(message, "User erfolgreich zum Todo hinzugefügt");
				
			} catch(Exception e) {
				NotificationBuilder.addErrorNotification(message, e.getMessage());
			}
		}
		
		new ProjectController().execute(request, response, message);
		return "/projects/project";
	}

}
