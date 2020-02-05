<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container">
	</p>
	<form method="post">
		<div class="form-group">
			<div class="col-sm-7">
				<div class="border2">
					<h3><c:forEach var="project" items="${projects}"> <c:out value="${projects.name}"/></h3> </c:forEach>
					</p>
					<h5>
						Mitglieder: <c:forEach var="user" items="${users}"> <c:out value="${user.name}"/> <i class="fas fa-user-minus fa-xs darkblue"></i> , </c:forEach>
					</h5>
					</p>
					</p>
					<button type="submit" class="btn btn-info">Mitglied
						hinzufügen</button>
				</div>
				</p>
				<h6>
					Deine To-Dos:
					</p>
				</h6>
				<ul class="list-group">
					<c:forEach var="todo" items="${todos}"> <li class="list list-group-item"> <c:out value="${todo.name}"/>
						<div class="float-right">
							<i class="fas fa-edit orange"></i> <i
								class="fas fa-check-circle green"></i> <i
								class="fas fa-trash-alt grey"></i>
						</div></c:forEach>
					</li>
				</ul>
			</div>
		</div>
	</form>
</div>