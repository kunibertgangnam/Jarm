package de.jarm.gui.oberflaeche;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;

public class EditTodoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {

		String todoId = request.getParameter("todoId");
		String todoTitle = request.getParameter("todoTitle");
		String todoDescription = request.getParameter("todoDescription");
		String todoState = request.getParameter("todoState");
		String usersAdded = request.getParameter("AddedUserIdsEditTodo");
		
		if (usersAdded != null) {
			String[] allUsers = usersAdded.split(" ");
		}
		
		System.out.println("TODO - id: " + todoId + ", title: " + todoTitle + ", description: " + todoDescription + ", state: " + todoState + ", USER IDS: " + usersAdded);
		
		new ProjectController().execute(request, response, message);
		return "/projects/project";
	}

}
