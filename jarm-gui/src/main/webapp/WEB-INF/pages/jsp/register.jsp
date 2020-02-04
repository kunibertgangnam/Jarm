<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="container">
		</p>
		<form method="post">
			<div class="form-group">
				<div class="col-sm-5">
					<h2>
						Registrier dich bei Jarm
						<ion-icon name="contacts"></ion-icon>
					</h2>
					</p>
					<label for="formGroupExampleInput">Benutzername:</label> <input
						type="text" class="form-control" id="formGroupExampleInput"
						placeholder="Benutzername" value="<c:out value="${NameValue}"/>">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-5">
					<label for="exampleInputEmail1">E-Mail:</label> <input type="email"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="E-Mail"
						value="<c:out value="${EmailValue}"/>">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-5">
					<label for="exampleInputPassword1">Passwort:</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Passwort" value="<c:out value="${PasswortValue}"/>">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-5">
					<label for="exampleInputPassword1">Passwort wiederholen:</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Passwort wiederholen" value="<c:out value="${PasswortWdhValue}"/>">
					</p>
					<button type="submit" class="btn btn-info">Registrieren</button>
				</div>
			</div>
		</form>
	</div>