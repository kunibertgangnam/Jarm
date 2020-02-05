package de.jarm.gui.utils;

public class JavaScriptFunctions {
	
	public static final String FIND_USER_FOR_TODO = "var elementsAddedToTodo = [];\r\n" + 
			"\r\n" + 
			"function addUserToTodo(element){\r\n" + 
			"	\r\n" + 
			"	$(\"#todo-users-added\").append(\"<div>\" + $(element).html() + \"</div>\");\r\n" + 
			"	$('#query-input-todo').val(\"\");\r\n" + 
			"	$('#query-output-todo').empty();\r\n" + 
			"	elementsAddedToTodo.push(element.value);\r\n" + 
			"}\r\n" + 
			"	\r\n" + 
			"function findUserForTodo(){\r\n" + 
			"	\r\n" + 
			"	var queryString = $('#query-input-todo').val();\r\n" + 
			"	var projectId = $('#current-project-id').html();\r\n" + 
			"	\r\n" + 
			"	if (queryString.length >= 3){\r\n" + 
			"		$.ajax({\r\n" + 
			"			url: \"ajax.findUser\",\r\n" + 
			"			data: {\r\n" + 
			"				userName : queryString,\r\n" + 
			"				projectId : projectId\r\n" + 
			"			},\r\n" + 
			"			success: function(result){\r\n" + 
			"				\r\n" + 
			"				$('#query-output-todo').empty();\r\n" + 
			"				\r\n" + 
			"				var users = result.split(\"<:>\");\r\n" + 
			"				\r\n" + 
			"				users.forEach(function(item){\r\n" + 
			"					\r\n" + 
			"					if (item != \"\"){\r\n" + 
			"						var user = item.split(\"<&>\");\r\n" + 
			"					\r\n" + 
			"						var userId = user[0];\r\n" + 
			"						\r\n" + 
			"						if (!elementsAddedToTodo.includes(userId)){\r\n" + 
			"							var userEmail = user[1];\r\n" + 
			"							var userName = user[2];\r\n" + 
			"						\r\n" + 
			"							$('#query-output-todo').append(\"<div><button id='todoU\" + userId + \"' type='button' value='\" + userId + \"'>\" + userName + \" - \" + userEmail + \"</button></div>\");\r\n" + 
			"							$('#todoU' + userId).click(function(){\r\n" + 
			"								addUserToTodo(this);\r\n" + 
			"							});\r\n" + 
			"						}\r\n" + 
			"					}								\r\n" + 
			"				});	\r\n" + 
			"			}\r\n" + 
			"		});\r\n" + 
			"	} else {\r\n" + 
			"		$('#query-output-todo').empty();\r\n" + 
			"	}\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"$('#query-input-todo').keyup(findUserForTodo);";
	
	public static final String FIND_USER_FOR_PROEJCT = "var elementsAddedToProject = [];\r\n" + 
			"\r\n" + 
			"function addUserToProject(element){\r\n" + 
			"	\r\n" + 
			"	$(\"#project-users-added\").append(\"<div>\" + $(element).html() + \"</div>\");\r\n" + 
			"	$('#query-input-project').val(\"\");\r\n" + 
			"	$('#query-output-user').empty();\r\n" + 
			"	elementsAddedToProject.push(element.value);\r\n" + 
			"}\r\n" + 
			"	\r\n" + 
			"function findUserForProject(){\r\n" + 
			"	\r\n" + 
			"	var queryString = $('#query-input-user').val();\r\n" + 
			"	\r\n" + 
			"	if (queryString.length >= 3){\r\n" + 
			"		$.ajax({\r\n" + 
			"			url: \"ajax.findUser\",\r\n" + 
			"			data: {\r\n" + 
			"				userName : queryString\r\n" + 
			"			},\r\n" + 
			"			success: function(result){\r\n" + 
			"				\r\n" + 
			"				$('#query-output-user').empty();\r\n" + 
			"				\r\n" + 
			"				var users = result.split(\"<:>\");\r\n" + 
			"				\r\n" + 
			"				users.forEach(function(item){\r\n" + 
			"					\r\n" + 
			"					if (item != \"\"){\r\n" + 
			"						var user = item.split(\"<&>\");\r\n" + 
			"					\r\n" + 
			"						var userId = user[0];\r\n" + 
			"						\r\n" + 
			"						if (!elementsAddedToProject.includes(userId)){\r\n" + 
			"							var userEmail = user[1];\r\n" + 
			"							var userName = user[2];\r\n" + 
			"						\r\n" + 
			"							$('#query-output-user').append(\"<div><button id='proj\" + userId + \"' type='button' value='\" + userId + \"'>\" + userName + \" - \" + userEmail + \"</button></div>\");\r\n" + 
			"							$('#proj' + userId).click(function(){\r\n" + 
			"								addUserToProject(this);\r\n" + 
			"							});\r\n" + 
			"						}\r\n" + 
			"					}								\r\n" + 
			"				});	\r\n" + 
			"			}\r\n" + 
			"		});\r\n" + 
			"	} else {\r\n" + 
			"		$('#query-output-user').empty();\r\n" + 
			"	}\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"$('#query-input-user').keyup(findUserForProject);";
	
}
