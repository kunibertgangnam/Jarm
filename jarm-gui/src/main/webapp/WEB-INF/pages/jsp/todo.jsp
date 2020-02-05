<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
					<c:out value="${user.name}" />(owner) ,
					<c:forEach var="projectUser" items="${currentProject.subscribers}">
						<c:out value="${projectUser.name}" />
						<i class="fas fa-user-minus fa-xs darkblue"></i> , </c:forEach>
				</h5>
				<br />
				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#exampleModal">Mitglied hinzufügen</button>
				<form method="post" action="<c:url value='/projects/addUserToProject.do'/>">	
				<input type="hidden" name="id" value="<c:out value="${currentProject.id}"/>" />
				<div class="modal fade" id="exampleModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Neues
									Mitglied</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<div class="input-group md-form form-sm form-1 pl-0">
									<div class="input-group-prepend">
										<span class="input-group-text cyan lighten-2" id="basic-text1"><i
											class="fas fa-search text-white" aria-hidden="true"></i></span>
									</div>
									<input class="form-control my-0 py-1" type="text"
										placeholder="Search" aria-label="Search" >
								</div>
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-info">Hinzufügen</button>
								<button type="button" class="btn btn-light" data-dismiss="modal">Abbrechen</button>
							</div>
						</div>
					</div>

				</div>
				</form>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-7">
			<h6>
				<br /> Deine To-Dos:
			</h6>

			<ul class="list-group">
				<c:forEach var="todo" items="${currentProject.toDos}">
					<li class="list list-group-item"><c:out value="${todo.name}" />
						<div class="float-right">
							<i class="fas fa-edit orange"></i> <i
								class="fas fa-check-circle green"></i> <i
								class="fas fa-trash-alt grey"></i>
						</div></li>
				</c:forEach>
			</ul>
			<br />
			<button type="button" class="btn btn-info" data-toggle="modal"
				data-target="#staticBackdrop">Neues To-Do</button>
		<form method="post" action="<c:url value='/projects/addTodo.do'/>">
			<input type="hidden" name="id" value="<c:out value="${currentProject.id}"/>" />
			<div class="modal fade" id="staticBackdrop" data-backdrop="static"
				tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="staticBackdropLabel">Neues To-Do</h5>
							<button type="button" class="close" data-dismiss="modal"
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
								<input type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default" name="Titel">
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">Info</span>
								</div>
								<textarea class="form-control" aria-label="With textarea"  name="Description"></textarea>
							</div>
							<br /> User zuweisen:
							<div class="input-group md-form form-sm form-1 pl-0">
								<div class="input-group-prepend">
									<span class="input-group-text cyan lighten-2" id="basic-text1"><i
										class="fas fa-search text-white" aria-hidden="true"></i></span>
								</div>
								<input class="form-control my-0 py-1" type="text"
									placeholder="Search" aria-label="Search">
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-info">Speichern</button>
							<button type="button" class="btn btn-light" data-dismiss="modal">Abbrechen</button>
						</div>
					</div>
				</div>
			</div>
			</form>
		</div>
	</div>
</div>