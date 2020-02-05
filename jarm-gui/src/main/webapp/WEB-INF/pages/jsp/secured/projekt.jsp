<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	</p>
	<form method="POST">
		<div class="form-group">
			<div class="col-sm-5">
				<div id="zentriert" class="border border-white">
					<h2>
						<b>Hallo <c:out value="${user.name}" /> <i
							class="fas fa-hippo blue"></i>
						</b>
					</h2>
					</p>
					<h5>Deine Projekte:</h5>
					</p>
				</div>
				<ul class="list-group">
					</p>
					<li
						class=" list list-group-item d-flex justify-content-between align-items-center">
						Projekt 1 <span class="badge badge-primary badge-pill">14</span>
					</li>
					<li
						class="list list-group-item d-flex justify-content-between align-items-center">
						Projekt 2 <span class="badge badge-primary badge-pill">2</span>
					</li>
					<li
						class="list list-group-item d-flex justify-content-between align-items-center">
						Projekt 3 <span class="badge badge-primary badge-pill">1</span>
					</li>
				</ul>
			</div>
		</div>
</div>
</form>
</div>
