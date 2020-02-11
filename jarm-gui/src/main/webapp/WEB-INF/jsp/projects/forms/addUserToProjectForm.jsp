<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form method="post" action="<c:url value='/projects/addUserToProject.do'/>">	
	<input type="hidden" name="projectId" value="<c:out value="${currentProject.id}"/>" />
	<div class="modal fade" id="exampleModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Neues
						Mitglied</h5>
					<button type="button" class="close close-modal-window-project" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<br/>
					<input type="hidden" value="" name="AddedUserIdsProject" id="added-user-ids-project" />
					<div id="project-users-added">
						
					</div>
					<br/>
					<div class="input-group md-form form-sm form-1 pl-0">
						<div class="input-group-prepend">
							<span class="input-group-text cyan lighten-2" id="basic-text1"><i
								class="fas fa-search text-white" aria-hidden="true"></i></span>
						</div>
						<input class="form-control my-0 py-1" type="text" id="query-input-user"
							placeholder="Search" aria-label="Search" autocomplete="off">
					</div>
					<div id="query-output-user" class="dropdown-content invisible">		
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-info">Hinzufügen</button>
					<button type="button" class="btn btn-light close-modal-window-project" data-dismiss="modal">Abbrechen</button>
				</div>
			</div>
		</div>
	</div>
</form>