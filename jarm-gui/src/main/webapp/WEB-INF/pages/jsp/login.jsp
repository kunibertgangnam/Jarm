<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="container">
		</p>
		<form method="post">
			<div class="form-group">
				<div class="col-sm-4">
					<h2>Login</h2>
					</p>
					<label for="formGroupExampleInput">Benutzername:</label> <input
						type="text" class="form-control" id="formGroupExampleInput"
						placeholder="Benutzername oder E-Mail" value="<c:out value="${EmailValue}"/>">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4">
					<label for="exampleInputPassword1">Passwort:</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Passwort" value="<c:out value="${PasswortValue}"/>">
					</p>
					<button type="submit" class="btn btn-info">Login</button>
				</div>
			</div>
		</form>
	</div>
