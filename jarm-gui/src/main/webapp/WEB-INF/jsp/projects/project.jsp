<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- LAYOUT  -->
<c:import url="/WEB-INF/jsp/projects/projectHeaderPanel.jsp"></c:import>
<c:import url="/WEB-INF/jsp/projects/projectTodos.jsp"></c:import>
<c:import url="/WEB-INF/jsp/projects/projectMessages.jsp"></c:import>

<!-- FORMS -->
<c:import url="/WEB-INF/jsp/projects/forms/addTodoForm.jsp"></c:import>
<c:import url="/WEB-INF/jsp/projects/forms/editTodoForm.jsp"></c:import>
<c:import url="/WEB-INF/jsp/projects/forms/addUserToProjectForm.jsp"></c:import>

<!-- FOR AJAX -->
<span id="current-project-id" style="visibility: hidden;"><c:out value="${currentProject.id}"/></span>