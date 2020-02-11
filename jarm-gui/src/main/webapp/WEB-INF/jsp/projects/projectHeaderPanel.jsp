<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<br />
	<div class="form-group">
		<div class="col-sm-7">
			<div class="border2">
				<h3>
					<c:out value="${currentProject.title}" />
				</h3>
				<br />
				<h5>
					Mitglieder:
					<c:out value="${currentProject.owner.name}" />(owner) <span class="current-project-subscribers" style="visibility: hidden;"><c:out value="${currentProject.owner.id}"/></span>
					<c:forEach var="projectUser" items="${currentProject.subscribers}">
						<c:out value="${projectUser.name}" />
						<a href="<c:url value='/projects/removeUserFromProject.do?projectId='/><c:out value="${currentProject.id}" />&userId=<c:out value="${projectUser.id}" />">
							<i class="fas fa-user-minus fa-xs darkblue"></i>
						</a> 
						<span class="current-project-subscribers" style="visibility: hidden;"><c:out value="${projectUser.id}"/></span>
					</c:forEach>
				</h5>
				<br />
				<c:if test="${user.id == currentProject.owner.id}">
					<button type="button" class="btn btn-info" data-toggle="modal" data-target="#exampleModal">Mitglied hinzufügen</button>
				</c:if>
			</div>
		</div>
	</div>
</div>