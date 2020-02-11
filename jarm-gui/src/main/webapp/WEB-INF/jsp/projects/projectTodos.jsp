<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="form-group">
		<div class="col-sm-7">
			<h4>
				<br /> Deine To-Dos:
			</h4>
			<ul class="list-group">
				<c:forEach var="todo" items="${currentProject.toDos}">
					<li class="list list-group-item">
						<h6>
							<c:out value="${todo.name}" />
						</h6>
						<c:forEach var="instructedUser" items="${todo.instructedUsers }">
							<span>
								<c:out value="${instructedUser.name }"></c:out>, 
							</span>
						</c:forEach>
						<div class="float-right">
							<a data-toggle="modal" data-target="#myModal" data-todo-id="<c:out value="${todo.id}" />" class="button pointer edit-todo">
								<i class="fas fa-edit orange"></i>
							</a> 
							<c:if test="${todo.state == 2}"> 
								<i class="fas fa-check-circle green"></i> 
							</c:if>
						 	<c:if test="${todo.state == 1}"> 
						 		<i class="fas fa-hourglass-start yellow"></i> 
					 		</c:if>
						 	<c:if test="${todo.state == 0}"> 
						 		<i class="fas fa-question darkblue"></i> 
					 		</c:if>	 							
							<a href="<c:url value='/projects/deleteTodo.do?todoId='/><c:out value="${todo.id}" />&projectId=<c:out value="${currentProject.id}" />">
								<i class="fas fa-trash-alt grey"></i>
							</a>
						</div>
					</li>
				</c:forEach>
			</ul>
			<br />		
			<button type="button" class="btn btn-info" data-toggle="modal" data-target="#staticBackdrop">Neues To-Do</button>
		</div>
	</div>
</div>