<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="container">
		<form method="post">
			<div class="form-group">
				<div class="col-sm-4">
					<h2>Login</h2>
					<label for="formGroupExampleInput">Email:</label> <input
						type="text" class="form-control" id="formGroupExampleInput"
						placeholder="E-Mail" name="Email" value="<c:out value="${emailValue}"/>">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4">
					<label for="exampleInputPassword1">Passwort:</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Passwort" name="Passwort"  value="">
					<button type="submit" class="btn btn-info">Login</button>
				</div>
			</div>
		</form>
	</div>
