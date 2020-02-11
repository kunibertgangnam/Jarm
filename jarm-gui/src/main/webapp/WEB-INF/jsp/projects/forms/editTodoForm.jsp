<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form method="post" action="<c:url value='/projects/editTodo.do'/>">
	<input type="hidden" name="projectId" value="<c:out value="${currentProject.id}"/>" />
	<input id="todo-id-input" type="hidden" name="todoId" value="" />
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">To-Do bearbeiten</h5>
					<button type="button" class="close close-modal-window-edit-todo" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-default">Titel</span>
						</div>
						<input id="title-textfield" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="todoTitle">
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">Info</span>
						</div>
						<textarea id="description-textfield" class="form-control" aria-label="With textarea" name="todoDescription" ></textarea>
					</div>
					<br />
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="inputGroupSelect01">Status</label>
						</div>
						<select class="custom-select" id="inputGroupSelect01" name="todoState">
							<option selected value="0">Unbearbeitet</option>
							<option value="1">In Bearbeitung</option>
							<option value="2">Fertig</option>
						</select>
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
						</div>
						<div class="custom-file">
							<input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
							<label class="custom-file-label" for="inputGroupFile01"></label>
						</div>
					</div><br />
					<div id="edit-todo-users-added"></div>
					<input type="hidden" value="" name="AddedUserIdsEditTodo" id="added-user-ids-edit-todo" />
					<br /> User zuweisen:
					<div class="input-group md-form form-sm form-1 pl-0">
						<div class="input-group-prepend">
							<span class="input-group-text cyan lighten-2" id="basic-text1"><i
								class="fas fa-search text-white" aria-hidden="true"></i></span>
						</div>
						<input class="form-control my-0 py-1" type="text"  id="query-input-edit-todo"
							placeholder="Search" aria-label="Search" autocomplete="off">
					</div>
					<div id="query-output-edit-todo" class="dropdown-content">		
					</div>	
					
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-info">Speichern</button>
					<button type="button" class="btn btn-light close-modal-window-edit-todo" data-dismiss="modal">Abbrechen</button>
				</div>
			</div>
		</div>
	</div>
</form>