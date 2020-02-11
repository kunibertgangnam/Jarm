<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form method="post" action="<c:url value='/projects/addTodo.do'/>">
	<input type="hidden" name="projectId" value="<c:out value="${currentProject.id}"/>" />
	<div class="modal fade" id="staticBackdrop" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Neues To-Do</h5>
					<button type="button" class="close close-modal-window-todo" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-default">Titel</span>
						</div>
						<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="Titel">
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">Info</span>
						</div>
						<textarea class="form-control" aria-label="With textarea" name="Description"></textarea>
					</div>
					<br/>
					<div id="todo-users-added"></div>
					<input type="hidden" value="" name="AddedUserIdsTodo" id="added-user-ids-todo" />
					<br/>
					<br /> User zuweisen:
					<div class="input-group md-form form-sm form-1 pl-0">
						<div class="input-group-prepend">
							<span class="input-group-text cyan lighten-2" id="basic-text1">
								<i class="fas fa-search text-white" aria-hidden="true"></i>
							</span>	
						</div>
						
						<input id="query-input-todo" class="form-control my-0 py-1" type="text" placeholder="Search" aria-label="Search" autocomplete="off">
						
					</div>
					<div id="query-output-todo" class="dropdown-content invisible">		
					</div>	
					
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-info">Speichern</button>
					<button type="button" class="btn btn-light close-modal-window-todo" data-dismiss="modal">Abbrechen</button>
				</div>
			</div>
		</div>
	</div>
</form>