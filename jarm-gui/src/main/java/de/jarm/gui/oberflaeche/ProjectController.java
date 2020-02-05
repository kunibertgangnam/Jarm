package de.jarm.gui.oberflaeche;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.jarm.gui.navi.Controller;
import de.jarm.main.data.DataController;
import de.jarm.main.data.Project;

public class ProjectController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, StringBuffer message)
			throws Exception {
		
		int projectId = new Integer(request.getParameter("id"));
		
		try {
			Project p = DataController.getInstance().getProjectService().getProjectById(projectId);
			request.setAttribute("currentProject", p);
		} catch(Exception e) {
			message.append(e.getMessage());
		}
		
		String script = "$(document).ready(function() {\r\n" + 
				"	\r\n" + 
				"	function findUser(){\r\n" + 
				"		\r\n" + 
				"		var queryString = $('#query-input').val();\r\n" + 
				"		\r\n" + 
				"		$.ajax({\r\n" + 
				"			url: \"ajax.findUser\",\r\n" + 
				"			data: queryString,\r\n" + 
				"			success: function(result){\r\n" + 
				"				alert(result);\r\n" + 
				"			},\r\n" + 
				"			error: function (xhr, ajaxOptions, thrownError) {\r\n" + 
				"				alert(xhr.status);\r\n" + 
				"				alert(thrownError);\r\n" + 
				"			}\r\n" + 
				"		});\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"	$('#query-input').keyup(findUser);\r\n" + 
				"});";
		
		request.setAttribute("script", script);
		
		return null;
	}

}
